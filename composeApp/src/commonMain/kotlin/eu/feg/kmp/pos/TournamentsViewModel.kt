package eu.feg.kmp.pos

import androidx.lifecycle.ViewModel
import eu.feg.kmp.poc.shared.TournamentsRepository

class TournamentsViewModel(
    private val repository: TournamentsRepository,
    private val sportId: String,
) : ViewModel() {

    val tournaments = repository.tournaments

    init{
        repository.getTournaments(sportId)
    }
}
