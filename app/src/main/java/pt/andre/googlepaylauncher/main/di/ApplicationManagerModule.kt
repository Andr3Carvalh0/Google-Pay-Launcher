package pt.andre.googlepaylauncher.main.di

import android.content.pm.PackageManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pt.andre.googlepaylauncher.main.apps.ApplicationManager
import pt.andre.googlepaylauncher.main.apps.ApplicationManagerImpl

@InstallIn(ViewModelComponent::class)
@Module
object ApplicationManagerModule {
    @Provides
    internal fun provideApplicationManager(packageManager: PackageManager): ApplicationManager {
        return ApplicationManagerImpl(packageManager)
    }
}
