
package uae.zuper.javascriptrunner.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import uae.zuper.javascriptrunner.MyApplication

import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, MainActivityModule::class])

public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    fun inject(app: MyApplication)


}
