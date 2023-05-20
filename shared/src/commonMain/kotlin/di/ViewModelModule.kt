package di

import HomeViewModel
import org.koin.dsl.module

internal val viewModelModule = module {
    factory { HomeViewModel(get()) }
}