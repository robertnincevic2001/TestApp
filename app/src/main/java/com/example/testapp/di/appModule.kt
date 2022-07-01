package com.example.testapp

import com.example.testapp.data.remote.TodoApi
import com.example.testapp.data.repository.GameRepository
import com.example.testapp.ui.game.GameViewModel
import com.example.testapp.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    fun provideGameRepository(todoAPI : TodoApi) : GameRepository {
        return GameRepository(todoAPI)
    }

    fun provideMainViewModel(gameRepository: GameRepository) : MainViewModel {
        return MainViewModel(gameRepository)
    }

    fun provideGameViewModel(gameRepository: GameRepository) : GameViewModel {
        return GameViewModel(gameRepository)
    }


    single{ provideGameRepository(get()) }

    viewModel { provideMainViewModel(get()) }

    viewModel { provideGameViewModel(get())}

}