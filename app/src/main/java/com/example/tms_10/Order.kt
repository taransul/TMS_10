package com.example.tms_10

// DONE 12
data class Order(
    val id: Int,
    val time: String,
    val customerAddress: String,
    val customerName: String?,
    val items: List<Item> = emptyList()
)

data class Item(
    val id: Int,
    val title: String
)