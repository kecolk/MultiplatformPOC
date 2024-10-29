import eu.feg.kmp.pos.SportsViewModel
import eu.feg.kmp.pos.TournamentsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

actual val viewModelModule = module {
    viewModelOf(::SportsViewModel)
    viewModelOf(::TournamentsViewModel)
}

