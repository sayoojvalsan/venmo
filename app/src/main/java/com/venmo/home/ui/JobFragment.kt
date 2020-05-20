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
class JobFragment : Fragment() {

    private lateinit var jobViewModel: JobsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        jobViewModel =
            ViewModelProviders.of(this).get(JobsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_job, container, false)
        val textView: TextView = root.findViewById(R.id.text_job)
        jobViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

}
