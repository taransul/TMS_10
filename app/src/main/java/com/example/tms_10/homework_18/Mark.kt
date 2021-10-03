package com.example.tms_10.homework_18

import android.util.Log

//DONE 2
class Mark(
    var student: Student,
    var discipline: Discipline,
    var value: ArrayList<Int>
) {
    //DONE 5
    fun calculatingTheAverageScore(): Double {
        val averageValue = value.average()
        Log.w(
            "DisciplineAverage",
            "Студент: ${student.name} (id: ${student.id});" +
                    " дисциплина: ${discipline.title} (id: ${discipline.id});" +
                    " средний бал: ${"%.2f".format(averageValue)}"
        )
        return averageValue
    }
}