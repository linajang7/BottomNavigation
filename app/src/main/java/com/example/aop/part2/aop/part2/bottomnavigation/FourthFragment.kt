package com.example.aop.part2.aop.part2.bottomnavigation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.*


class FourthFragment : Fragment() {

    companion object {
        fun newInstance() = FourthFragment()
    }

    private lateinit var viewModel: FourthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fourth_fragment, container, false)
        val search = view.findViewById<SearchView>(R.id.searchView)
        val listView = view.findViewById<ListView>(R.id.listView)
        val names = arrayOf("상품명","Switzerland", "Korea", "Japan", "United States", "Russia", "Singapore", "Canada", "Mexico", "Brazil", "Russia","Switzerland", "Korea", "Japan", "United States", "Russia", "Singapore", "Canada", "Mexico", "Brazil", "Russia","Switzerland", "Korea", "Japan", "United States", "Russia", "Singapore", "Canada", "Mexico", "Brazil", "Russia","Switzerland", "Korea", "Japan", "United States", "Russia", "Singapore", "Canada", "Mexico", "Brazil", "Russia","Switzerland", "Korea", "Japan", "United States", "Russia", "Singapore", "Canada", "Mexico", "Brazil", "Russia","Switzerland", "Korea", "Japan", "United States", "Russia", "Singapore", "Canada", "Mexico", "Brazil", "Russia","Switzerland", "Korea", "Japan", "United States", "Russia", "Singapore", "Canada", "Mexico", "Brazil", "Russia","Switzerland", "Korea", "Japan", "United States", "Russia", "Singapore", "Canada", "Mexico", "Brazil", "Russia","Switzerland", "Korea", "Japan", "United States", "Russia", "Singapore", "Canada", "Mexico", "Brazil", "Russia").sortedArray()
        val adapter: ArrayAdapter<String> = activity?.let {
            ArrayAdapter(
                it, android.R.layout.simple_list_item_1, names)
        }!!
        listView.adapter = adapter


        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val clicked = names[position]
            val myIntent = Intent(activity, ClickEvent::class.java)
            myIntent.putExtra("Info", clicked)
            startActivity(myIntent)
        }

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                search.clearFocus()
                if (names.contains(query)) {
                    adapter.filter.filter(query)
                } else {
                    Toast.makeText(activity, "Item not found", Toast.LENGTH_LONG).show()
                }
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                adapter.filter.filter(query)
                return true
            }
        })

        val sideView = view.findViewById<SideBar>(R.id.sideBar)
        val contactsFloatLetter = view.findViewById<TextView>(R.id.contactsFloatLetter)
        sideView.setTextView(contactsFloatLetter)
        sideView.setOnTouchingLetterChangedListener(object : OnTouchingLetterChangedListener {
            override fun onTouchingLetterChanged(s: String) {
                for (i in names.indices) {
                    val character = names[i].first()
                    if (character == s.first()) {
                        listView.setSelection(i)
                        return
                    }
                }
            }
        })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FourthViewModel::class.java)
        // TODO: Use the ViewModel
    }

}