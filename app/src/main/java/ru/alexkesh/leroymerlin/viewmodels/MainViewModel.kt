package ru.alexkesh.leroymerlin.viewmodels

import androidx.lifecycle.ViewModel
import ru.alexkesh.leroymerlin.data.repository.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {

    fun getGroups() = repository.getGroups()

}