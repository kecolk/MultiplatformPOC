import eu.feg.kmp.pos.viewmodels.SportsViewModel
import eu.feg.kmp.pos.viewmodels.TournamentsViewModel
import eu.feg.kmp.pos.viewmodels.FixturesViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

actual val viewModelModule = module {
    singleOf(::SportsViewModel)
    factoryOf(::TournamentsViewModel)
    factoryOf(::FixturesViewModel)
}

