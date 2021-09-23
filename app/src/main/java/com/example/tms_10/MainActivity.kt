package com.example.tms_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

//DONE 4
fun main() {
    val discount = Discount(
        "Сеть пиццерий \"Додо пицца\"",
        "Скидка 20% по промокоду распространяется на всю продукцию, кроме соусов, комбо, доп. ингредиентов, кусочков пиццы и категории \"другие товары\". Действует при оформлении заказа в ресторане, а также на доставку и самовывоз. Заказ по акции можно оформить с 11.00 до 23.00. Скидка по промокоду не суммируется с другими акциями и специальными предложениями пиццерий «Додо Пицца». Промокод действует во всех пиццериях Додо Пицца, кроме г. Жлобин",
        20,
        "https://thumb.tildacdn.com/tild3339-3961-4335-a333-613339336332/-/resize/520x/-/format/webp/-.jpeg",
        "https://dodopizza.by/minsk?roistat_visit=729770",
        DiscountType.FixAmount(5) // DONE 6
    )
    println(discount)

    //DONE 7
    val discountCopy = discount.copy(discountType = DiscountType.RangeAmount(5,10))
    println(discountCopy)

    //DONE 9
    val discountCopyWithNoDiscountType = discount.copy(discountType = DiscountType.NoDiscount)
    println(discountCopyWithNoDiscountType)

}