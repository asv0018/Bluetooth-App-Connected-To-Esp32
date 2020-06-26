package com.thinkfinitylabs.app001

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager.widget.PagerAdapter
import com.thinkfinitylabs.app001.ui.TabsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                    }
                }

                override fun onTabUnselected(p0: TabLayout.Tab?) {

                }

                override fun onTabSelected(p0: TabLayout.Tab?) {

                }

            }
        )
    }
}