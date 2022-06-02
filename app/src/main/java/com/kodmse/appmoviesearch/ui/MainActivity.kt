package com.kodmse.appmoviesearch.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appmoviesearch.R
import com.kodmse.appmoviesearch.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}