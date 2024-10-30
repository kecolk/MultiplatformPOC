import eu.feg.kmp.pos.viewmodels.SportsViewModel
import eu.feg.kmp.pos.viewmodels.TournamentsViewModel
import eu.feg.kmp.pos.viewmodels.FixturesViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

actual val viewModelModule = module {
    viewModelOf(::SportsViewModel)
    viewModelOf(::TournamentsViewModel)
    viewModelOf(::FixturesViewModel)
}

