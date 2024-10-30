package eu.feg.kmp.pos.viewmodels

import androidx.lifecycle.ViewModel
import repositories.TournamentsRepository

class TournamentsViewModel(
    private val repository: TournamentsRepository,
    private val sportId: String,
) : ViewModel() {

    val tournaments = repository.tournaments

    init{
        repository.getTournaments(sportId)
    }
}
