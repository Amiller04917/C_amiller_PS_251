package edu.wccnet.amiller.lifecycle.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.wccnet.amiller.lifecycle.LifeObserver
import edu.wccnet.amiller.lifecycle.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    lateinit var _binding: FragmentMainBinding
    companion object {
        fun newInstance() = MainFragment()
    }

    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false);
        return _binding.root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        lifecycle.addObserver(LifeObserver())

        val resultObserver = Observer<String> {
                result -> _binding.textView.text = result.toString()
        }
        viewModel.getLifeVal().observe(viewLifecycleOwner, resultObserver)

    }

}