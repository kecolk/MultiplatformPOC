package eu.feg.kmp.pos

import androidx.lifecycle.ViewModel
import eu.feg.kmp.poc.shared.SportsRepository

class SportsViewModel(
    private val repository: SportsRepository
) : ViewModel() {

    val sports = repository.sports

    init{
        repository.getSports()
    }
}