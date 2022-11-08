package com.mobileapp.inspestor_vr5.onboarding

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mobileapp.inspestor_vr5.R

class ViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val context : Context
) :
        FragmentStateAdapter(fragmentActivity){

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnboardFragment.newInstance(
                context.resources.getString(R.string.onboard_title1),
                context.resources.getString(R.string.onboard_desc1),
                R.raw.welcome
            )
            1 -> OnboardFragment.newInstance(
                context.resources.getString(R.string.onboard_title2),
                context.resources.getString(R.string.onboard_desc2),
                R.raw.zoom
            )
            /** 2 -> OnboardFragment.newInstance(
                context.resources.getString(R.string.onboard_title3),
                context.resources.getString(R.string.onboard_desc3),
                R.raw.focus
            )**/
           /** 3 -> OnboardFragment.newInstance(
                context.resources.getString(R.string.onboard_title4),
                context.resources.getString(R.string.onboard_desc4),
                R.raw.light
            )**/
            else -> OnboardFragment.newInstance(
                context.resources.getString(R.string.onboard_title3),
                context.resources.getString(R.string.onboard_desc3),
                R.raw.focus
            )
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}
