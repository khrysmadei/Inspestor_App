package com.mobileapp.inspestor_vr5.onboarding

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mobileapp.inspestor_vr5.R


class ViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val context : Context
): FragmentStateAdapter(fragmentActivity){

    override fun createFragment(position: Int): OnBoardFragment {
        return when (position){
           0 -> OnBoardFragment.newInstance(
                context.resources.getString(R.string.onboard_title1),
                context.resources.getString(R.string.onboard_desc1),
                R.raw.welcomenew
                )
            1 -> OnBoardFragment.newInstance(
                context.resources.getString(R.string.onboard_title2),
                context.resources.getString(R.string.onboard_desc2),
                R.raw.zoomnew
                )
            else -> OnBoardFragment.newInstance(
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