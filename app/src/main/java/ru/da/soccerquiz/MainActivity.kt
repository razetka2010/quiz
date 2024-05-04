package ru.da.soccerquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ru.da.soccerquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bunding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main)
    }
}