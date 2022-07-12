package com.mobileapp.inspestor_vr5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mobileapp.inspestor_vr5.databinding.ActivityLibraryBinding

class Library : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =ActivityLibraryBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        //binding.libTitle.text=resources.getString(R.string.lib_title)

        //set opacity of cardBar
        //val topBar=binding.navBar
        //val textBar=binding.libTitle
        //topBar.alpha=0f
       // textBar.alpha=0f

        //for scrolling, opacity increases if scroll up
        //binding.scrollView.viewTreeObserver.addOnScrollChangedListener {
          //  val maxDistance = binding.bphBtn.height
          //  val movement=binding.scrollView.scrollY
          //  val alphaFactor:Float = ((movement*1.0f)/(maxDistance-topBar.height))
           // if(movement in 0..maxDistance){
          //      topBar.alpha=alphaFactor
           //     textBar.alpha=alphaFactor
          //  }
       // }

        binding.bphBtn.setOnClickListener(this)
        binding.gphBtn.setOnClickListener(this)
        binding.rbBtn.setOnClickListener(this)
        binding.rbbBtn.setOnClickListener(this)
        binding.rgbBtn.setOnClickListener(this)
        binding.lfBtn.setOnClickListener(this)

        binding.backBtn.setOnClickListener {
            finish()
        }
    }

    override fun onClick(card: View?) {
        when (card?.id){
            R.id.bph_btn->
                startActivity(Intent(this, LibPestInfo::class.java)
                    .putExtra(" card", "bph_card"))

            R.id.gph_btn->
                startActivity(Intent(this, LibPestInfo::class.java)
                    .putExtra(" card", "gph_card"))

            R.id.rb_btn->
                startActivity(Intent(this, LibPestInfo::class.java)
                    .putExtra(" card", "rb_card"))

            R.id.rbb_btn->
                startActivity(Intent(this, LibPestInfo::class.java)
                    .putExtra(" card", "rbb_card"))

            R.id.rgb_btn->
                startActivity(Intent(this, LibPestInfo::class.java)
                    .putExtra(" card", "rgb_card"))

            R.id.lf_btn->
                startActivity(Intent(this, LibPestInfo::class.java)
                    .putExtra(" card", "lf_card"))
        }
    }
}