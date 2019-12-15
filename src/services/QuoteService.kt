package de.tbtz.services

data class Quote(
    val id: Int = System.currentTimeMillis().toInt(),
    var text: String,
    val dateCreate: Long = System.currentTimeMillis()
)

val quotes: ArrayList<Quote> = ArrayList()

class QuoteService {
    fun getAllQuotes(): ArrayList<Quote> {
        return quotes
    }

    fun getQuote(id: Int): Quote? {
        return quotes.first { quote -> quote.id == id }
    }

    fun addQuote(quote: Quote): Quote {
        quotes += quote
        return quote
    }

    fun deleteQuote(id: Int): Boolean {
        val quote = quotes.first { quote -> quote.id == id }
        return quotes.remove(quote)
    }
}
