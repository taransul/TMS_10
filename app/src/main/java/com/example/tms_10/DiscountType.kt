package com.example.tms_10

sealed class DiscountType(
    val calculate: (Int) -> String //DONE 10
) {
    data class FixAmount(val value: Int) : DiscountType({
        (it * value).toString() //DONE 10
    })

    data class RangeAmount(val startValue: Int, val endValue: Int) : DiscountType({
        (it * (startValue + endValue) / 2).toString() //DONE 10
    })

    object NoDiscount : DiscountType({
        "0" //DONE 10
    })
}