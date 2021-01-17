package uae.zuper.javascriptrunner.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uae.zuper.javascriptrunner.ui.main.viewmodel.MainActivityViewModel

/*
you should provide your view model here
 */
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

   @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel




}