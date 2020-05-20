package com.venmo.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.venmo.home.R

class NetworkFragment : Fragment() {
    private lateinit var networkViewModel: NetworkViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        networkViewModel =
            ViewModelProviders.of(this).get(NetworkViewModel::class.java)

        // Inflate the layout for this fragment
        val root =  inflater.inflate(R.layout.fragment_network, container, false)
        val textView: TextView = root.findViewById(R.id.network_text)
        networkViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

}
