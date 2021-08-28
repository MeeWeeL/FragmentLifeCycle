package com.meeweel.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.meeweel.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFrag(Fragment1.newInstance(), R.id.place1)
        openFrag(Fragment2.newInstance(), R.id.place2)
        dataModel.message3.observe(this, {
            binding.text.text = it
        })
    }

    private fun openFrag(f: Fragment, id: Int) {
        supportFragmentManager.beginTransaction().replace(id, f).commit()
    }
}