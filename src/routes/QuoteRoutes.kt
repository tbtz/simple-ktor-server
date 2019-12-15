package de.tbtz.routes

import de.tbtz.services.Quote
import de.tbtz.services.QuoteService
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*

fun Routing.quoteRoutes(quoteService: QuoteService) {
    route("/quotes") {

        get("/") {
            call.respond(quoteService.getAllQuotes())
        }

        get("/{id}") {
            val id = call.parameters["id"]!!.toInt()
            call.respond(quoteService.getQuote(id) ?: HttpStatusCode.NotFound)
        }

        post("/") {
            val quote = call.receive<Quote>()
            call.respond(quoteService.addQuote(quote))
        }

        delete("/{id}") {
            val id = call.parameters["id"]!!.toInt()
            val successful = quoteService.deleteQuote(id)
            call.respond(if (successful) HttpStatusCode.OK else HttpStatusCode.NotFound)
        }
    }
}
