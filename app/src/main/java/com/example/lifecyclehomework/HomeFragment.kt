package com.example.lifecyclehomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifecyclehomework.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    // Binding-lazy
    private lateinit var fragmentHomeBinding: FragmentHomeBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Initialize binding
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)
        //Click listener for button
        fragmentHomeBinding.saveButton.setOnClickListener {
            buttonClick()
        }
        return fragmentHomeBinding.root
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        savedInstanceState?.let {
            val content = fragmentHomeBinding.editTextName.text.toString()

            fragmentHomeBinding.textViewForResult.text = content
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val textViewMessage = fragmentHomeBinding.textViewForResult.text.toString()
        fragmentHomeBinding.textViewForResult.text = textViewMessage
    }

    private fun buttonClick(){
        //So as not to write it twice
        fragmentHomeBinding.apply {
            //Get editTextTextPersonName
            val editText = editTextName.text.toString()

            //Set textViewForResult
            val tvText = "$editText"
            textViewForResult.text = tvText
        }



    }

}