package com.thinkfinitylabs.app001.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.thinkfinitylabs.app001.fragments.Auto_setting
import com.thinkfinitylabs.app001.fragments.Bluetooth_connectivity
import com.thinkfinitylabs.app001.fragments.Manual_setting

class TabsAdapter(private val context:Context,fm:FragmentManager,internal var totalTabs:Int):FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        when(position){
            0->{
                return Bluetooth_connectivity()
            }
            1->{
                return Auto_setting()
            }
            2->{
                return Manual_setting()
            }
            else-> return Auto_setting()
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }

}