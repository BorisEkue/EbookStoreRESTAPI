package com.hotshi.com.hotshi.ebookStore.routes

import com.hotshi.com.hotshi.ebookStore.authentication.userAuthenticate
import com.hotshi.com.hotshi.ebookStore.http.error
import com.hotshi.com.hotshi.ebookStore.http.response
import com.hotshi.com.hotshi.ebookStore.models.EBook
import com.hotshi.com.hotshi.ebookStore.models.RoleType
import com.hotshi.com.hotshi.ebookStore.models.User
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IEbookRepository
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IRoleRepository
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IUserRepository
import com.hotshi.com.hotshi.ebookStore.services.EbookService
import com.hotshi.com.hotshi.ebookStore.services.UserService
import com.hotshi.com.hotshi.ebookStore.utils.generateIdByCustomer
import io.ktor.application.ApplicationCallPipeline
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.PartData
import io.ktor.http.content.forEachPart
import io.ktor.locations.get
import io.ktor.request.path
import io.ktor.request.receiveMultipart
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.get
import io.ktor.routing.route
import io.ktor.util.AttributeKey
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun Route.booksRoutes(userRepository: IUserRepository, roleRepository: IRoleRepository, eBookRepository: IEbookRepository) {
    route("/ebooks") {
        val ebookService = EbookService(eBookRepository, userRepository)
        val userService = UserService(userRepository, roleRepository)

        val userKey = AttributeKey<User>("userKey")

        intercept(ApplicationCallPipeline.Call) {
            userAuthenticate(call, this, userService, userKey)
        }

        post("/upload") {
            val user = call.attributes[userKey]
            if(user.hasRole(RoleType.seller.name)) {
                var title: String = ""
                var author: String = ""
                var publishedDate = ""
                var isbn = ""
                var description = ""
                var category = ""
                var ext: String = ""
                var fileName = ""
                var fileURL = ""
                var thumbnail = ""

                val multipart = call.receiveMultipart()
                multipart.forEachPart { part ->
                    when(part) {
                        is PartData.FormItem -> {
                            if(part.name == "title") title = part.value
                            if(part.name == "author") author = part.value
                            if(part.name == "publishedDate") publishedDate = part.value
                            if(part.name == "description") description = part.value
                            if(part.name == "isbn") isbn = part.value
                            if(part.name == "category") category = part.value
                        }
                        is PartData.FileItem -> {
                             ext = File(part.originalFileName).extension
                            val file = File("C:\\Users\\bekue\\Documents\\IMG", "file-${System.currentTimeMillis()}.$ext")

                        }
                    }
                    part.dispose
                }

                val ebook = EBook(
                    idBook = generateIdByCustomer("e", user.idUser),
                    title = title,
                    author = author,
                    publishedDate = LocalDateTime.parse(publishedDate, DateTimeFormatter.ISO_DATE_TIME),
                    description = description,
                    isbn = isbn,
                    category = category,
                    fileName = fileName,
                    fileURL = fileURL,
                    thumbnail = thumbnail,
                    uploadedAt = LocalDateTime.now(),
                    idUser = user.idUser
                )

                // Save the ebook
                ebookService.save(ebook)

                //call.respond("$title/$ext/$author/$publishedDate/$description/$isbn/$category")
                call.respond(response(HttpStatusCode.OK, call, "ebook", ebook))
            } else
                call.respond(error(HttpStatusCode.Unauthorized, call, "You donn't have permission to upload ebooks!"))

        }

        get("/{id_ebook}") {
            val idEbook = call.parameters["id_ebook"]

            idEbook?.let {
                val ebook = ebookService.findById(idEbook)
                ebook?.let {
                    call.respond(response(HttpStatusCode.OK, call, "ebook", ebook))
                } ?: call.respond(error(HttpStatusCode.NotFound, call, "Ebook not found"))
            } ?: call.respond(error( HttpStatusCode.NotFound, call, "id_ebook can not be empty") )
        }

        get("/all") {
            val ebooks = ebookService.all("all")
            call.respond(response(HttpStatusCode.OK, call, "ebooks", ebooks))
        }

        get("/all/{category}") {
            val category = call.parameters["category"] ?: ""
            val ebooks = ebookService.all(category)
            call.respond(response(HttpStatusCode.OK, call, "ebooks", ebooks))
        }


    }
}