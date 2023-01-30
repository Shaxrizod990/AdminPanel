package uz.smartmuslim.adminpanel.domain.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.smartmuslim.adminpanel.data.local.room.dao.AppealDao
import uz.smartmuslim.adminpanel.data.local.room.dao.UserDao
import uz.smartmuslim.adminpanel.data.local.room.database.AppDatabase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DatabaseModule {


    @[Singleton Provides]
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "admin_panel").build()

    @[Singleton Provides]
    fun provideUserDao(appDatabase: AppDatabase): UserDao = appDatabase.userDao()

    @[Singleton Provides]
    fun provideAppealDao(appDatabase: AppDatabase): AppealDao = appDatabase.appealDao()
}