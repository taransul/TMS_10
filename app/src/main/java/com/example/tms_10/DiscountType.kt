package com.example.tms_10

// DONE 6
enum class DiscountType {
    FixAmount,
    RangeAmount;

    override fun toString(): String {
        return when (this) {
            FixAmount -> "Fix amount discount type"
            RangeAmount -> "Range amount discount type"
        }
    }
}