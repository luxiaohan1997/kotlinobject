package com.goketech.smartcommunity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.goketech.smartcommunity.view.event.EventFragment
import com.goketech.smartcommunity.view.login.home.HomeFragment
import com.goketech.smartcommunity.view.my.MyFragment
import com.goketech.smartcommunity.view.notifications.NotificationsFragment


class MainActivity : AppCompatActivity() {


    //private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { tm ->
        when (tm.itemId) {
            R.id.navigation_home -> {
                //textMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                //textMessage.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_event -> {
                //textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_my -> {
                //textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        initFragment()

    }

    fun initFragment(){
        var homeFragment = HomeFragment()
        var notificationsFragment = NotificationsFragment()
        var eventFragment = EventFragment()
        var myFragment = MyFragment()

        supportFragmentManager.beginTransaction().replace(R.id.layout_page, homeFragment!!).commit()

    }
}
