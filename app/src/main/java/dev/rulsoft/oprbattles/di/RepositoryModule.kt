package dev.rulsoft.oprbattles.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.rulsoft.oprbattles.data.club.networking.ClubDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideClubsRepository(
        db: FirebaseFirestore
    ) : ClubDataSource {
        return ClubDataSource(db)
    }

}