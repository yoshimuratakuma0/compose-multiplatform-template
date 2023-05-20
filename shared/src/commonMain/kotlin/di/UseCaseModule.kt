package di

import domain.usecases.GetSampleTextUseCase
import org.koin.dsl.module

internal val useCaseModule = module {
    single { GetSampleTextUseCase(get()) }
}