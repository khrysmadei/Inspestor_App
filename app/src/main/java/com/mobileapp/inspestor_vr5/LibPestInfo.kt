package com.mobileapp.inspestor_vr5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.limerse.slider.model.CarouselItem
import com.mobileapp.inspestor_vr5.databinding.ActivityLibPestInfoBinding
import java.util.ArrayList

class LibPestInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLibPestInfoBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        //val topBar = binding.navBar
        //val textBar = binding.topBarText
        //topBar.alpha = 0f
        //textBar.alpha = 0f

        //binding.scroller.viewTreeObserver.addOnScrollChangedListener {
         //   val maxDistance = binding.carouselView.height
           // val movement = binding.scroller.scrollY
           // val alphaFactor: Float = ((movement * 1.0f) / (maxDistance - topBar.height))
           // if (movement in 0..maxDistance) {
           //     topBar.alpha = alphaFactor
             //   textBar.alpha = alphaFactor
           // }
       // }
        val card = intent.getStringExtra(" card")

        binding.desTitle.text = "Description"
        binding.pestTreat.text = " Pest Treatment"

        when (card) {
            "bph_card" -> {
                binding.topBarText.text = "Brown Planthopper"
                binding.pestLabel.text = binding.topBarText.text
                binding.sciPest.text = resources.getString(R.string.bph_sci)
                binding.pestDesc.text = resources.getString(R.string.bph_des)
                binding.pestreatName.text = resources.getString(R.string.bph_pesticide)

                val carouselView = binding.carouselView
                carouselView.registerLifecycle(lifecycle)
                val list = mutableListOf<CarouselItem>()
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.bph
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.bph1
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.bph2
                    )
                )
                carouselView.setData(list)
            }

            "gph_card" -> {
                binding.topBarText.text = "Green Planthopper"
                binding.pestLabel.text = binding.topBarText.text
                binding.sciPest.text = resources.getString(R.string.gph_sci)
                binding.pestDesc.text = resources.getString(R.string.gph_des)
                binding.pestreatName.text = resources.getString(R.string.gph_pesticide)

                val carouselView = binding.carouselView
                carouselView.registerLifecycle(lifecycle)
                val list = mutableListOf<CarouselItem>()
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.gph
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.gph1
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.gph2
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.gph3
                    )
                )
                carouselView.setData(list)
            }

            "rb_card" -> {
                binding.topBarText.text = "Rice Bug"
                binding.pestLabel.text = binding.topBarText.text
                binding.sciPest.text = resources.getString(R.string.rb_sci)
                binding.pestDesc.text = resources.getString(R.string.rb_des)
                binding.pestreatName.text = resources.getString(R.string.rb_pesticide)

                val carouselView = binding.carouselView
                carouselView.registerLifecycle(lifecycle)
                val list = mutableListOf<CarouselItem>()
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rb
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rb1
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rb2
                    )
                )
                carouselView.setData(list)
            }

            "rbb_card" -> {
                binding.topBarText.text = "Rice Black Bug"
                binding.pestLabel.text = binding.topBarText.text
                binding.sciPest.text = resources.getString(R.string.rbb_sci)
                binding.pestDesc.text = resources.getString(R.string.rbb_des)
                binding.pestreatName.text = resources.getString(R.string.rbb_pesticide)

                val carouselView = binding.carouselView
                carouselView.registerLifecycle(lifecycle)
                val list = mutableListOf<CarouselItem>()
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rbb
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rbb1
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rbb2
                    )
                )
                carouselView.setData(list)
            }

            "rgb_card" -> {
                binding.topBarText.text = "Rice Grain Bug"
                binding.pestLabel.text = binding.topBarText.text
                binding.sciPest.text = resources.getString(R.string.rgb_sci)
                binding.pestDesc.text = resources.getString(R.string.rgb_des)
                binding.pestreatName.text = resources.getString(R.string.rgb_pesticide)

                val carouselView = binding.carouselView
                carouselView.registerLifecycle(lifecycle)
                val list = mutableListOf<CarouselItem>()
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rgb
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rgb1
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rgb2
                    )
                )
                carouselView.setData(list)
            }

            "lf_card" -> {
                binding.topBarText.text = "Leaf Folder"
                binding.pestLabel.text = binding.topBarText.text
                binding.sciPest.text = resources.getString(R.string.lf_sci)
                binding.pestDesc.text = resources.getString(R.string.lf_des)
                binding.pestreatName.text = resources.getString(R.string.lf_pesticide)

                val carouselView = binding.carouselView
                carouselView.registerLifecycle(lifecycle)
                val list = mutableListOf<CarouselItem>()
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.lf
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.lf1
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.lf2
                    )
                )
                carouselView.setData(list)
            }
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}