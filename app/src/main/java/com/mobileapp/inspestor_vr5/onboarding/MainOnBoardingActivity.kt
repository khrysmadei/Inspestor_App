package com.mobileapp.inspestor_vr5.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.mobileapp.inspestor_vr5.MainActivity
import com.mobileapp.inspestor_vr5.R
import com.mobileapp.inspestor_vr5.databinding.ActivityMainOnBoardingBinding


class MainOnBoardingActivity : AppCompatActivity() {

    private lateinit var pViewPager: ViewPager2
    private lateinit var btnPrev: Button
    private lateinit var btnNext: Button

    private lateinit var binding: ActivityMainOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainOnBoardingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        pViewPager = binding.viewPager
        pViewPager.adapter = ViewPagerAdapter(this, this)
        pViewPager.offscreenPageLimit = 1
        btnPrev = binding.btnPrevious
        btnNext = binding.btnNextStep
        pViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                if (position == 2){
                    btnNext.text=getText(R.string.finish_text)
                }else{
                    btnNext.text=getText(R.string.next_text)
                }
            }
            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(arg0: Int){}
        })
        TabLayoutMediator(binding.pageIndicator, pViewPager){_, _ -> }.attach()
        btnNext.setOnClickListener{
            if(getItem() > pViewPager.childCount){
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                pViewPager.setCurrentItem(getItem() + 1, true)
            }
        }

        btnPrev.setOnClickListener{
            if (getItem() == 0){
                finish()
            }else {
                pViewPager.setCurrentItem(getItem() - 1, true)
            }
        }
    }
    private fun getItem(): Int {
        return pViewPager.currentItem
    }
}