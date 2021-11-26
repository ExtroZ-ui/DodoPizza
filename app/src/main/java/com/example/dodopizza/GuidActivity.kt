package com.example.dodopizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.dodopizza.Adapter.VpAdapter
import com.example.dodopizza.Adapter.VpData
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class GuidActivity : AppCompatActivity() {
    lateinit var swap:Button
    lateinit var tab:TabLayout
    lateinit var viewpager:ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guid)
        swap = findViewById(R.id.guid_swap)
        tab = findViewById(R.id.guid_tab)
        viewpager = findViewById(R.id.guid_vp)

        viewpager.adapter = VpAdapter(this, VpData.List.list)
        TabLayoutMediator(tab,viewpager){_,_->}.attach()

        viewpager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                when(position){
                    2->{
                        swap.visibility = View.VISIBLE
                    }
                    else->{
                        swap.visibility = View.INVISIBLE
                    }
                }
            }
        })
    }

    fun swp(view: android.view.View) {
        startActivity(Intent(this@GuidActivity, LoginInActivity::class.java))
        finish()
    }
}