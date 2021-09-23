package com.example.tms_10


// DONE 3
data class Discount(
    val title: String,
    var description: String,
    val discountAmount: Int,
    val imageUrl: String? = null,
    val siteUrl: String? = null,
) {
    fun getUppercaseTitle() = title.uppercase()

    fun updateDescription(description: String) {
        this.description = if (description.length >= 100) {
            description.substring(0, 100)
        } else {
            description
        }
    }
}