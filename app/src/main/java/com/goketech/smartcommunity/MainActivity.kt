package com.goketech.smartcommunity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.goketech.smartcommunity.view.event.EventFragment
import com.goketech.smartcommunity.view.login.home.HomeFragment
import com.goketech.smartcommunity.view.my.MyFragment
import com.goketech.smartcommunity.view.notifications.NotificationsFragment


class MainActivity : AppCompatActivity() {
//    private var
    private var homeFragment: HomeFragment? = null
    private var notificationsFragment: NotificationsFragment? = null
    private var eventFragment: EventFragment? = null
    private var myFragment: MyFragment? = null

    //private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { tm ->

        val bt = supportFragmentManager.beginTransaction()
        when (tm.itemId) {
            R.id.navigation_home -> {
                //textMessage.setText(R.string.title_home)
                bt.replace(R.id.layout_page,homeFragment!!).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                bt.replace(R.id.layout_page,notificationsFragment!!).commit()
                //textMessage.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_event -> {
                bt.replace(R.id.layout_page,eventFragment!!).commit()
                //textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_my -> {
                bt.replace(R.id.layout_page,myFragment!!).commit()
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
         homeFragment = HomeFragment()
         notificationsFragment = NotificationsFragment()
         eventFragment = EventFragment()
         myFragment = MyFragment()

        supportFragmentManager.beginTransaction().replace(R.id.layout_page, homeFragment!!).commit()

    }
}
