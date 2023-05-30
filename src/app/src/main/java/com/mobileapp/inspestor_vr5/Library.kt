package com.mobileapp.inspestor_vr5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mobileapp.inspestor_vr5.databinding.ActivityLibraryBinding

class Library : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityLibraryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLibraryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bphBtn.setOnClickListener(this)
        binding.glfBtn.setOnClickListener(this)
        binding.rbBtn.setOnClickListener(this)
        binding.rbbBtn.setOnClickListener(this)
        binding.rgbBtn.setOnClickListener(this)
        binding.lfBtn.setOnClickListener(this)

        binding.manBtn.setOnClickListener {
            startActivity(Intent(this, Instruction::class.java))
        }

        binding.backBtn.setOnClickListener {
            finish()
        }
    }

    override fun onClick(card: View?) {
        when (card?.id){
            R.id.bph_btn->
                startActivity(Intent(this, LibPestInfo::class.java)
                    .putExtra("card", "bph_card"))

            R.id.glf_btn->
                startActivity(Intent(this, LibPestInfo::class.java)
                    .putExtra("card", "glh_card"))

            R.id.rb_btn->
                startActivity(Intent(this, LibPestInfo::class.java)
                    .putExtra("card", "rb_card"))

            R.id.rbb_btn->
                startActivity(Intent(this, LibPestInfo::class.java)
                    .putExtra("card", "rbb_card"))

            R.id.rgb_btn->
                startActivity(Intent(this, LibPestInfo::class.java)
                    .putExtra("card", "rgb_card"))

            R.id.lf_btn->
                startActivity(Intent(this, LibPestInfo::class.java)
                    .putExtra("card", "lf_card"))
        }
    }
}
