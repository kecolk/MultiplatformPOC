package eu.feg.kmp.poc.shared.di

import eu.feg.kmp.poc.shared.Repository
import eu.feg.kmp.poc.shared.TournamentsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val sharedModule = module {
    singleOf(::Repository)
    singleOf(::TournamentsRepository)
}
