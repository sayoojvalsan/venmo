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

/**
 * A simple [Fragment] subclass.
 */
class EarningsFragment : Fragment() {

    private lateinit var earningsViewModel: EarningsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        earningsViewModel =
            ViewModelProviders.of(this).get(EarningsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_navigation_earnings, container, false)
        val textView: TextView = root.findViewById(R.id.text_earnings)
        earningsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

}
