package com.example.toshape

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BMIViewModel(private val repository: BMIRepository) : ViewModel() {

    private val _allBMI: MutableLiveData<List<BMIModel>> = MutableLiveData()
    val allBMI: LiveData<List<BMIModel>> = _allBMI

    fun loadAllBMI() {
        _allBMI.value = repository.getAllBMI()
    }

    fun addBMI(weight: String, height: String): Boolean {
        return repository.addBMI(weight, height)
    }

    fun getBMI(weight: String): BMIModel? {
        return repository.getBMI(weight)
    }

    fun deleteBMI(weight: String): Boolean {
        return repository.deleteBMI(weight)
    }

    fun updateBMI(bmiModel: BMIModel): Boolean {
        return repository.updateBMI(bmiModel)
    }
}
