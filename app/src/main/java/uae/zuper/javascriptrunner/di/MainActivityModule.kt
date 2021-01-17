
package uae.zuper.javascriptrunner.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uae.zuper.javascriptrunner.ui.main.MainActivity

@Module
abstract class MainActivityModule
{
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

}