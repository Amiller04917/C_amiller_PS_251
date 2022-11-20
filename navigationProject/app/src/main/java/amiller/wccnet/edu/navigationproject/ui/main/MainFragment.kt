package amiller.wccnet.edu.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import amiller.wccnet.edu.navigationproject.R
import amiller.wccnet.edu.navigationproject.databinding.FragmentMainBinding
import androidx.navigation.Navigation

class MainFragment : Fragment() {
    lateinit var _binding: FragmentMainBinding
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        _binding.button.setOnClickListener{
            val action: MainFragmentDirections.ActionMainFragmentToSecondFragment =
                MainFragmentDirections.actionMainFragmentToSecondFragment(
                    R.drawable.android_image_1,
                    "Image 1"
                )
            Navigation.findNavController(it).navigate(action)
        }

        _binding.button2.setOnClickListener{
            val action: MainFragmentDirections.ActionMainFragmentToSecondFragment =
                MainFragmentDirections.actionMainFragmentToSecondFragment(
                    R.drawable.android_image_2,
                    "Image 2"
                )
            Navigation.findNavController(it).navigate(action)
        }

        _binding.button3.setOnClickListener{
            val action: MainFragmentDirections.ActionMainFragmentToSecondFragment =
                MainFragmentDirections.actionMainFragmentToSecondFragment(
                    R.drawable.android_image_3,
                    "Image 3"
                )
            Navigation.findNavController(it).navigate(action)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false);
        return _binding.root;
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }



}