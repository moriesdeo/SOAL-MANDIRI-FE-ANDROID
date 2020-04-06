package com.example.soalmandirifeandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.soalmandirifeandroid.R
import com.example.soalmandirifeandroid.di.Injection
import com.example.soalmandirifeandroid.viewmodel.VmMovies

class MoviesFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProvider(
            this,
            Injection.provideViewModelFactory(activity!!.application)
        ).get(VmMovies::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_movies, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        return root
    }
}
