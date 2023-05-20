package di

import data.repositories.InMemoryTextRepository
import domain.repositories.TextRepository
import org.koin.dsl.module

internal val repositoryModule = module {
    single<TextRepository> { InMemoryTextRepository() }
}