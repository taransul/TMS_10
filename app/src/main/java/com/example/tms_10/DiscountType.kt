package com.example.tms_10

// DONE 8
sealed class DiscountType {
    data class FixAmount(val value: Int): DiscountType()
    data class RangeAmount(val startValue: Int, val endValue: Int): DiscountType()
    object NoDiscount: DiscountType()

    override fun toString(): String {
        return when (this) {
            is FixAmount -> "Fix amount: $value"
            is RangeAmount -> "Range amount: $startValue - $endValue"
            NoDiscount -> "No discount"
        }
    }
}