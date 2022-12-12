package edu.wccnet.amiller.contacts.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import edu.wccnet.amiller.contacts.Contact
import edu.wccnet.amiller.contacts.R
import edu.wccnet.amiller.contacts.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var adapter: RecyclerAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel //by viewModels()
    private lateinit var _binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false);
        return _binding.root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        recyclerSetup()
        listenerSetup()
        observerSetup()
    }

    private fun listenerSetup() {

        _binding.add.setOnClickListener {
            val name = _binding.enterName.text.toString()
            val phonenum = _binding.enterPhone.text.toString()

            if (name != "" && phonenum != "") {
                val contact = Contact(name, phonenum)
                viewModel.insertContact(contact)
                clearFields()
            } else {
                // send toast stating invalid information
                //_binding.customerID.text = "Incomplete information"
                Snackbar.make(_binding.recyclerView, "Incomplete information",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }

        _binding.find.setOnClickListener {
            viewModel.findContact(_binding.enterName.text.toString())
            viewModel.getSearchResults().observe(viewLifecycleOwner, Observer { contacts ->
                adapter?.setContactList(contacts)
            } )
        }

        _binding.asc.setOnClickListener{
            viewModel.getAsc()
            viewModel.getAscResults()?.observe(viewLifecycleOwner, Observer{ contacts ->
                adapter?.setContactList(contacts)
            })
        }

        _binding.desc.setOnClickListener{
            viewModel.getDesc()
            viewModel.getDescResults()?.observe(viewLifecycleOwner, Observer{ contacts ->
                adapter?.setContactList(contacts)
            })
        }
        adapter!!.settingListener(object: RecyclerAdapter.onItemClickListener {
            override fun onClick(id: Int) {
                viewModel.deleteContact(id)
            }
        })
//
    }

    private fun observerSetup() {

        viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer { contact ->
            contact?.let  {
                adapter?.setContactList(it)
            }
        })

        viewModel.getSearchResults().observe(viewLifecycleOwner, Observer { contact ->

            contact?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                } else {
                    Snackbar.make(_binding.recyclerView, "No matches",
                        Snackbar.LENGTH_LONG).setAction("Action", null).show()
                }
            }
        })
    }

    private fun recyclerSetup() {
        adapter = RecyclerAdapter()
        _binding.recyclerView.layoutManager = LinearLayoutManager(context)
        _binding.recyclerView.adapter = adapter
    }

    private fun clearFields() {
        _binding.enterName.setText("")
        _binding.enterPhone.setText("")
    }
}