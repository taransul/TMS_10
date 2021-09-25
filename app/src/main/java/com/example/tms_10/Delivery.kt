package com.example.tms_10

// DONE 13
sealed class Delivery(
    val deliver: (Order) -> Unit // DONE 14
) {
    data class BikeDelivery(val bike: String) : Delivery({
        println("Bike delivery of order ${it.id} using bike $bike")  // DONE 14
    })

    data class CarDelivery(val car: String) : Delivery({
        println("$car delivered your order ${it.id}")  // DONE 14
    })

    data class PostDelivery(val post: String) : Delivery({
        println("$post had lost you order ${it.id} and stolen your ${it.items}")  // DONE 14
    })
}