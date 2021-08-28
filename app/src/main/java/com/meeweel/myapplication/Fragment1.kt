package com.meeweel.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.meeweel.myapplication.databinding.Fragment1Binding

class Fragment1 : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btn1.setOnClickListener {
            dataModel.message2.observe(activity as LifecycleOwner, {
                binding.text1.text = it
            })
            dataModel.message1.value = "Hello from First"
        }
        binding.btn1Second.setOnClickListener {
            dataModel.message3.value = "Hello, activity, from First"
        }
    }
    companion object {

        @JvmStatic
        fun newInstance() = Fragment1()
    }
}