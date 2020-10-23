package com.example.mailapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), MailListAdapter.ItemClickListener {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var mailListFragment: MailListFragment
    private lateinit var mailDetailFragment: MailDetailFragment
    private lateinit var fragmentManager: FragmentManager
    private lateinit var logoutButton: Button
    private var list = ArrayList<Mail>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        setContentView(R.layout.activity_main)
        logoutButton = findViewById(R.id.logout)
        logoutButton.setOnClickListener {
            logout()
        }
        for (i in 1..20) {
            list.add(
                Mail(
                    i,
                    "Date$i",
                    "Title$i",
                    "Author$i",
                    "Text$i"
                )
            )
        }
        mailListFragment = MailListFragment(list, this)
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragment, mailListFragment).commit()

    }

    override fun itemClicked(item: Mail) {
        mailDetailFragment = MailDetailFragment(item)
        fragmentManager.beginTransaction().replace(R.id.fragment, mailDetailFragment)
            .addToBackStack("tag").commit()
    }

    fun logout() {
        val editor = sharedPreferences.edit()
        editor.remove("user")
        editor.apply()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}