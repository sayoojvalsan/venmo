package com.venmo.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.venmo.di.Injectable
import com.venmo.di.injectActivityViewModel
import com.venmo.home.R
import timber.log.Timber
import javax.inject.Inject

class HomeFragment : Fragment(), Injectable {

    private lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        homeViewModel = injectActivityViewModel(viewModelFactory)

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

//        homeViewModel.user.observe(viewLifecycleOwner, Observer {
//            Timber.d("User data $it")
//        })
        return root
    }

}
