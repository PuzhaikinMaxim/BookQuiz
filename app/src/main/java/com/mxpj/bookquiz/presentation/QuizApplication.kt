package com.mxpj.bookquiz.presentation

import android.app.Application

class QuizApplication: Application() {

    val dependencyContainer by lazy {
        QuizApplicationDependencyContainer(this)
    }
}