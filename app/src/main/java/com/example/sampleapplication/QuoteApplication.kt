package com.example.sampleapplication

import android.app.Application
import com.example.sampleapplication.api.QuoteService
import com.example.sampleapplication.api.RetrofitHelper
import com.example.sampleapplication.db.QuoteDatabase
import com.example.sampleapplication.repository.QuoteRepository


class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database, applicationContext)
    }
}