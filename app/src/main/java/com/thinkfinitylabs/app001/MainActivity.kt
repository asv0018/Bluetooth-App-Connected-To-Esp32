package com.thinkfinitylabs.app001

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import com.thinkfinitylabs.app001.ui.TabsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title = "Corona Rakshak"
        setSupportActionBar(toolbar)
        // when the activity is launched, these three tabs are made
        tabs!!.addTab(tabs!!.newTab().setText(R.string.tab_text_1))
        tabs!!.addTab(tabs!!.newTab().setText(R.string.tab_text_2))
        tabs!!.addTab(tabs!!.newTab().setText(R.string.tab_text_3))
        tabs!!.tabGravity = TabLayout.GRAVITY_FILL
        tabs!!.bringToFront()
        // adapter is created to connect the tabs and the view pager
        view_pager!!.adapter = TabsAdapter(this,supportFragmentManager,tabs!!.tabCount)

        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs!!.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(view_pager))

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.about_us -> {
                return true
            }
            R.id.exit -> {
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    fun selectFragment(position:Int){
        view_pager.setCurrentItem(position,true)
    }

    }


