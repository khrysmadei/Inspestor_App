package com.mobileapp.inspestor_vr5.onboarding

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.mobileapp.inspestor_vr5.MainActivity
import com.mobileapp.inspestor_vr5.R
import com.mobileapp.inspestor_vr5.databinding.ActivityOnboardMainBinding

class OnboardMain : AppCompatActivity() {

    private lateinit var onViewPager : ViewPager2
    private lateinit var btnPrev: AppCompatButton
    private lateinit var btnNext: AppCompatButton

    private lateinit var preference: SharedPreferences
    private val pref_show_onboard= "Onboard"

    private lateinit var binding: ActivityOnboardMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        preference = getSharedPreferences("OnBoardScreen", Context.MODE_PRIVATE)

        if(!preference.getBoolean(pref_show_onboard,true)){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        onViewPager = binding.viewPager
        onViewPager.adapter=ViewPagerAdapter(this, this)
        onViewPager.offscreenPageLimit = 1
        btnPrev = binding.btnPreviousStep
        btnNext = binding.btnNextStep
        onViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                    if (position == 2) {
                        btnNext.text=getText(R.string.finish_text)

                    }else{
                        btnNext.text = getText(R.string.next_text)
                    }
                }

                override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
                override fun onPageScrollStateChanged(arg0: Int) {}
             })
            TabLayoutMediator(binding.pageIndicator, onViewPager){_, _ ->}.attach()

            btnNext.setOnClickListener{
                if (getItem() > onViewPager.childCount){
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                    val editor = preference.edit()
                    editor.putBoolean(pref_show_onboard, false)
                    editor.apply()
                }else{
                    onViewPager.setCurrentItem(getItem()+1, true)
                }
            }

            btnPrev.setOnClickListener {
                if (getItem()==0){
                    finish()
                }else{
                    onViewPager.setCurrentItem(getItem()-1, true)
                }
            }
        }
        /**private fun launchMainActivity(){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                val editor = preference.edit()
                editor.putBoolean(pref_show_onboard, false)
                editor.apply()
            }**/

       private fun getItem(): Int{
           return onViewPager.currentItem
       }
}