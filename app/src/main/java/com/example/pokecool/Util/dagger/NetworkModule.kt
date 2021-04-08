package com.example.pokecool.Util.dagger

import com.example.pokecool.Data.Api.PokeService
import com.example.pokecool.Data.Api.PokeServiceImpl
import com.example.pokecool.Domain.PokeRepositoryImpl
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton


//@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {


    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
                //.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setLenient()
                .create()
    }
    @Singleton
    @Provides
    fun provideRetrofit(gson:Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @Singleton
    @Provides
    fun providePokeService(retrofit: Retrofit): PokeService {
        return retrofit.create(PokeService::class.java)
    }
}