import eu.feg.kmp.pos.SportsViewModel
import eu.feg.kmp.pos.TournamentsViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

actual val viewModelModule = module {
    singleOf(::SportsViewModel)
    factoryOf(::TournamentsViewModel)
}

