import repositories.SportsRepository
import repositories.TournamentsRepository
import repositories.FixturesRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val sharedModule = module {
    singleOf(::SportsRepository)
    factoryOf(::TournamentsRepository)
    factoryOf(::FixturesRepository)
}
