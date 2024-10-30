package eu.feg.kmp.pos.viewmodels

import androidx.lifecycle.ViewModel
import repositories.SportsRepository

class SportsViewModel(
    private val repository: SportsRepository
) : ViewModel() {

    val sports = repository.sports

    init{
        repository.getSports()
    }
}