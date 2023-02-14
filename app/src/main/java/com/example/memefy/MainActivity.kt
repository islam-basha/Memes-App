package com.example.memefy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.memefy.Model.Getmemes.MySharedPref
import com.example.memefy.databinding.ActivityMainBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var pref: MySharedPref

    fun n() {
        var n= pref.getnum()?.toInt() !!

        binding.bottomNav.getOrCreateBadge(R.id.home_nav).apply {
            number = n

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pref=MySharedPref(this@MainActivity)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
            pref.save("3")

    }



}