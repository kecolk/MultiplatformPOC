import eu.feg.kmp.poc.shared.SportsRepository
import eu.feg.kmp.poc.shared.TournamentsRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val sharedModule = module {
    singleOf(::SportsRepository)
    factoryOf(::TournamentsRepository)
}
