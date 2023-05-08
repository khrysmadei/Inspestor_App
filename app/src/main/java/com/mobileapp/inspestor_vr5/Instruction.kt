package com.mobileapp.inspestor_vr5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mobileapp.inspestor_vr5.databinding.ActivityInstructionBinding

class Instruction : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityInstructionBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.manOne.text =resources.getString(R.string.one)
        binding.manTwo.text =resources.getString(R.string.two)
        binding.manThree.text =resources.getString(R.string.three)
        binding.manFour.text =resources.getString(R.string.four)

        binding.backBtn.setOnClickListener {
            finish()
        }
    }
}