package com.example.mailapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class MailDetailFragment(private val task: Mail) :
    Fragment() {
    private lateinit var title: TextView
    private lateinit var date: TextView
    private lateinit var author: TextView
    private lateinit var text: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView =
            inflater.inflate(R.layout.mail_detail_fragment, container, false) as ViewGroup
        title = rootView.findViewById(R.id.title)
        date = rootView.findViewById(R.id.date)
        author = rootView.findViewById(R.id.author)
        text = rootView.findViewById(R.id.text)

        title.text = task.title
        date.text = task.date
        author.text = task.author
        text.text = task.text
        return rootView
    }
}