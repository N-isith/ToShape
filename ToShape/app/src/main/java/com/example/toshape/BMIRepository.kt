package com.example.toshape

class BMIRepository(private val databaseHelper: DatabaseHelper) {

    fun getAllBMI(): List<BMIModel> {
        return databaseHelper.getAllBMI()
    }

    fun addBMI(weight: String, height: String): Boolean {
        val bmiModel = BMIModel().apply {
            this.weight = weight
            this.height = height
        }
        return databaseHelper.addBMI(bmiModel)
    }

    fun getBMI(weight: String): BMIModel? {
        return databaseHelper.getBMI(weight)
    }

    fun deleteBMI(weight: String): Boolean {
        return databaseHelper.deleteBMII(weight)
    }

    fun updateBMI(bmiModel: BMIModel): Boolean {
        return databaseHelper.updateBMI(bmiModel)
    }
}
