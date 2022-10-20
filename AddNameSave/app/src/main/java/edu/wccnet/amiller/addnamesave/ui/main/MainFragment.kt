package edu.wccnet.amiller.addnamesave.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.wccnet.amiller.addnamesave.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var _binding: MainFragmentBinding
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false);
        return _binding.root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Observing to update
        val nameObserver = Observer<String> {
                names -> _binding.textView.text = names.toString()
        }
        viewModel.getName().observe(viewLifecycleOwner, nameObserver)

        // Invokes method to add names to string which is outputted by the observer.
        _binding.button.setOnClickListener {
            viewModel.addName(_binding);
        }

    }

}