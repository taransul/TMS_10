package com.example.tms_10

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.tms_10.homework_18.Discipline
import com.example.tms_10.homework_18.Mark
import com.example.tms_10.homework_18.Student
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //DONE 3
        val studentList: ArrayList<String> =
            arrayListOf("Evgeniy", "Aleksander", "Sergey", "Alla", "Svetlana", "Viktoria")
        val disciplineList: ArrayList<String> = arrayListOf("Mathematics", "History", "Geography")
        val markListRandom: ArrayList<Int> = arrayListOf()
        val averageDisciplineList: MutableList<Double> = mutableListOf()
        val averageAllList: MutableList<Double> = mutableListOf()
        //DONE 4
        for (i in studentList.indices) {
            val student = Student(studentList[i], i + 1)
            for (j in disciplineList.indices) {
                val discipline = Discipline(disciplineList[j], j + 101)
                val randomMarkQuantity = Random.nextInt(2, 10)
                for (n in 1..randomMarkQuantity) {
                    markListRandom.add(Random.nextInt(4, 11))
                }
                //DONE 5
                val mark = Mark(student, discipline, markListRandom)
                val addAverageDouble = mark.calculatingTheAverageScore()
                averageDisciplineList.add(addAverageDouble)
                averageAllList.add(addAverageDouble)
                markListRandom.clear()
            }
            val averageDiscipline = averageDisciplineList.average()
            Log.v(
                "StudentAverage",
                "Студент: ${student.name} (id: ${student.id}); средний бал: ${
                    "%.2f".format(
                        averageDiscipline
                    )
                }"
            )
            averageDisciplineList.clear()
        }
        Log.e(
            ContentValues.TAG,
            "Средний балл по классу: ${"%.2f".format(averageAllList.average())}"
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main() {
    val discount = Discount(
        "Сеть пиццерий \"Додо пицца\"",
        "Скидка 20% по промокоду распространяется на всю продукцию, кроме соусов, комбо, доп. ингредиентов, кусочков пиццы и категории \"другие товары\". Действует при оформлении заказа в ресторане, а также на доставку и самовывоз. Заказ по акции можно оформить с 11.00 до 23.00. Скидка по промокоду не суммируется с другими акциями и специальными предложениями пиццерий «Додо Пицца». Промокод действует во всех пиццериях Додо Пицца, кроме г. Жлобин",
        20,
        "https://thumb.tildacdn.com/tild3339-3961-4335-a333-613339336332/-/resize/520x/-/format/webp/-.jpeg",
        "https://dodopizza.by/minsk?roistat_visit=729770",
        DiscountType.FixAmount(5) // DONE 6
    )
    println(discount.discountType.calculate(5)) // DONE 11

    //DONE 7
    val discountCopy = discount.copy(discountType = DiscountType.RangeAmount(5, 10))
    println(discountCopy.discountType.calculate(5)) // DONE 11

    //DONE 9
    val discountCopyWithNoDiscountType = discount.copy(discountType = DiscountType.NoDiscount)
    println(discountCopyWithNoDiscountType.discountType.calculate(5)) // DONE 11

    // DONE 15
    val orderOne = Order(
        id = 1,
        time = "22 Sep, 12:18",
        customerAddress = "Minsk, Scoriny 2",
        customerName = "Andrew",
        items = listOf(Item(123, "T-shirt"))
    )

    val orderTwo = Order(
        id = 2,
        time = "25 Sep, 12:18",
        customerAddress = "Minsk, Scoriny 2",
        customerName = "Evgeniy",
        items = listOf(Item(2345, "Milk"), Item(2346, "Juice"))
    )

    val orderThree = Order(
        id = 3,
        time = "30 Sep, 19:00",
        customerAddress = "Minsk, Timeryazeva 67, 433",
        customerName = null,
        items = listOf(Item(24, "Pizza"))
    )

    val orders = listOf(orderOne, orderTwo, orderThree)

    val bikeDelivery = Delivery.BikeDelivery("XB3")
    val carDelivery = Delivery.CarDelivery("Tesla S")
    val postDelivery = Delivery.PostDelivery("Post of Minsk")

    val deliveries = listOf(bikeDelivery, carDelivery, postDelivery)

    // DONE 16
    orders.forEach { order ->
        deliveries.forEach { delivery ->
            delivery.deliver(order)
        }
        println("\n")
    }

    // DONE 17
    bikeDelivery.deliver = {
        println("No print info regarding order delivery")
    }

    postDelivery.deliver = {
        println("${postDelivery.post} delivered your order $it")
    }

    orders.forEach { order ->
        deliveries.forEach { delivery ->
            delivery.deliver(order)
        }
        println()
    }
}