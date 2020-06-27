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

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.apply {
            setLogo(R.mipmap.ic_launcher_round)
            setDisplayHomeAsUpEnabled(true)
        }
        // when the activity is launched, these three tabs are made
        tabs!!.addTab(tabs!!.newTab().setText(R.string.tab_text_1))
        tabs!!.addTab(tabs!!.newTab().setText(R.string.tab_text_2))
        tabs!!.addTab(tabs!!.newTab().setText(R.string.tab_text_3))
        tabs!!.tabGravity = TabLayout.GRAVITY_FILL

        // adapter is created to connect the tabs and the view pager
        view_pager!!.adapter = TabsAdapter(this,supportFragmentManager,tabs!!.tabCount)

        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))

        tabs!!.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener{
                override fun onTabReselected(p0: TabLayout.Tab?) {
                    if (p0 != null) {
                        view_pager!!.currentItem = p0.position
                        Log.d("CHECK HERE","TAB CHANGED")
                    }
                }

                override fun onTabUnselected(p0: TabLayout.Tab?) {
                    Log.d("CHECK HERE","TAB CHANGED")
                }

                override fun onTabSelected(p0: TabLayout.Tab?) {
                    Log.d("CHECK HERE","TAB CHANGED")
                }

            }
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        Log.d("CHECK THIS","I M HERE")
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
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

    }


