package com.example.tms_10

// DONE 13
sealed class Delivery {
    data class BikeDelivery(val bike: String) : Delivery()
    data class CarDelivery(val car: String) : Delivery()
    data class PostDelivery(val post: String) : Delivery()
}