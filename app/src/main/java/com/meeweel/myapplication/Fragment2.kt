package com.meeweel.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.meeweel.myapplication.databinding.Fragment1Binding
import com.meeweel.myapplication.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment2Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.message1.observe(activity as LifecycleOwner, {
            binding.text2.text = it
        })
        binding.btn2.setOnClickListener {
            dataModel.message2.value = "Hello from Second"
        }
        binding.btn2Second.setOnClickListener {
            dataModel.message3.value = "Hello, activity, from Second"
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = Fragment2()
    }
}