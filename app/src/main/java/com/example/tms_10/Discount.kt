package com.example.tms_10

// DONE 1
class Discount(
    title: String,
    description: String,
    val discountAmount: Int,
    val imageUrl: String? = null,
    val siteUrl: String? = null,

    ) {
    // DONE 2
    val title: String = title
        get() {
            return field.uppercase()
        }

    // DONE 2
    var description: String = description
        set(value) {
            field = if (value.length >= 100) {
                value.substring(0, 100)
            } else {
                value
            }
        }
}

//class Discount {
//    val title: String = ""
//    val description: String = ""
//    val discountAmount: Int = 0
//    val imageUrl: String? = null
//    val siteUrl: String? = null
//}