package com.example.home19_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.viewpager.widget.ViewPager
import com.example.home19_2.databinding.ActivityMainBinding
import com.example.home19_2.fragments.ChanceFragment
import com.example.home19_2.fragments.ClickFramgent
import com.example.home19_2.fragments.RatesFragment
import com.example.home19_2.fragments.StatisticsFragment
import dev.abdujabbor.homework191.MyAdapter

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = MyAdapter(supportFragmentManager)
        adapter.addFragment(ClickFramgent())
        adapter.addFragment(StatisticsFragment())
        adapter.addFragment(RatesFragment())
        adapter.addFragment(ChanceFragment())
        binding.myViewPager.adapter =adapter
        binding.next.setOnClickListener {
            binding.myViewPager.setCurrentItem(binding.myViewPager.currentItem + 1, true)
        }
        binding.myViewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                when(position){
                    2->{
                        binding.next.isVisible = true
                    }
                    3->{
                        binding.next.isVisible = false
                    }
                }
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        binding.myCircleIndicatior.setViewPager(binding.myViewPager)

        setContentView(binding.root)
    }
}
