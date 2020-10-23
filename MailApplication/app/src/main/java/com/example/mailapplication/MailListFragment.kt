package com.example.mailapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MailListFragment(
    private val list: ArrayList<Mail>,
    private val listener: MailListAdapter.ItemClickListener
) :
    Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var mailListAdapter: MailListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mailListAdapter = MailListAdapter(list, context!!, listener)
        val rootView = inflater.inflate(R.layout.mail_list_fragment, container, false) as ViewGroup
        recyclerView = rootView.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = mailListAdapter
        return rootView
    }

}