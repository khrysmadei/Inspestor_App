package com.mobileapp.inspestor_vr5

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.limerse.slider.model.CarouselItem
import com.mobileapp.inspestor_vr5.databinding.ActivityLibPestInfoBinding

class LibPestInfo : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLibPestInfoBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        val card = intent.getStringExtra("card")

        binding.pestSciTitle.text = "Scientific Name"
        binding.pestDoesTitle.text="What it does"
        binding.pestImpTitle.text = "Pest Importance"
        binding.pestWhyWhere.text = "Why and Where does  it occurs"
        binding.pestMngmntTitle.text= "Management Recommendation"
        binding.pestRecTitle.text= "Recommended Pesticide List"
        binding.pestActiList.text="Active Ingredient"
        when (card) {
            "bph_card" -> {
                binding.pestLabel.text = "Brown Planthopper"
                binding.pestSciDesc.text = resources.getString(R.string.bph_sci_name)
                binding.pestDoesDesc.text = resources.getString(R.string.bph_does)
                binding.pestIdentifyDesc.text= resources.getString(R.string.bph_identify)
                binding.pestImpDesc.text = resources.getString(R.string.bph_important)
                binding.pestWwDesc.text = resources.getString(R.string.bph_why_where)
                binding.pestMngmntDesc.text=resources.getString(R.string.bph_mngmnt)
                binding.pestRecList.text = resources.getString(R.string.bph_pesticide)
                binding.pestActiList.text = resources.getString(R.string.bph_active_ing)
               //binding.link.text= resources.getString(R.string.bph_hyperlink)

                val carouselView = binding.carouselView
                carouselView.registerLifecycle(lifecycle)
                val list = mutableListOf<CarouselItem>()
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.bph4
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.bph3
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.bph2
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.bph1
                    )
                )
                carouselView.setData(list)
            }

            "glh_card" -> {
                binding.pestLabel.text = "Green Leafhopper "
                binding.pestSciDesc.text = resources.getString(R.string.glh_sci_name)
                binding.pestDoesDesc.text = resources.getString(R.string.glh_does)
                binding.pestIdentifyDesc.text= resources.getString(R.string.glh_identify)
                binding.pestImpDesc.text = resources.getString(R.string.glh_important)
                binding.pestWwDesc.text = resources.getString(R.string.glh_why_where)
                binding.pestMngmntDesc.text=resources.getString(R.string.glh_mngmnt)
                binding.pestRecList.text = resources.getString(R.string.glh_pesticide)
                binding.pestActiList.text = resources.getString(R.string.glh_active_ing)
                //binding.link.text= resources.getString(R.string.glh_hyperlink)


                val carouselView = binding.carouselView
                carouselView.registerLifecycle(lifecycle)
                val list = mutableListOf<CarouselItem>()
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.glh3
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.glh2
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.glh4
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.glh1
                    )
                )
                carouselView.setData(list)
            }

            "rb_card" -> {
                binding.pestLabel.text = "Rice Bug"
                binding.pestSciDesc.text = resources.getString(R.string.rb_sci_name)
                binding.pestDoesDesc.text = resources.getString(R.string.rb_does)
                binding.pestIdentifyDesc.text= resources.getString(R.string.rb_identify)
                binding.pestImpDesc.text = resources.getString(R.string.rb_important)
                binding.pestWwDesc.text = resources.getString(R.string.rb_why_where)
                binding.pestMngmntDesc.text=resources.getString(R.string.rb_mngmnt)
                binding.pestRecList.text = resources.getString(R.string.rb_pesticide)
                binding.pestActiList.text = resources.getString(R.string.rb_active_ing)
                //binding.link.text= resources.getString(R.string.rb_hyperlink)


                val carouselView = binding.carouselView
                carouselView.registerLifecycle(lifecycle)
                val list = mutableListOf<CarouselItem>()
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rb1
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rb3
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rb2
                    )

                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rb4
                    )

                )
                carouselView.setData(list)
            }

            "rbb_card" -> {
                binding.pestLabel.text = "Rice Black Bug"
                binding.pestSciDesc.text = resources.getString(R.string.rbb_sci_name)
                binding.pestDoesDesc.text = resources.getString(R.string.rbb_does)
                binding.pestIdentifyDesc.text= resources.getString(R.string.rbb_identify)
                binding.pestImpDesc.text = resources.getString(R.string.rbb_important)
                binding.pestWwDesc.text = resources.getString(R.string.rbb_why_where)
                binding.pestMngmntDesc.text=resources.getString(R.string.rbb_mngmnt)
                binding.pestRecList.text = resources.getString(R.string.rbb_pesticide)
                binding.pestActiList.text = resources.getString(R.string.rbb_active_ing)
                //binding.link.text= resources.getString(R.string.rbb_hyperlink)


                val carouselView = binding.carouselView
                carouselView.registerLifecycle(lifecycle)
                val list = mutableListOf<CarouselItem>()
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
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rbb3
                    )
                )
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rbb4
                    )
                )
                carouselView.setData(list)
            }

            "rgb_card" -> {
                binding.pestLabel.text = "Rice Grain Bug"
                binding.pestSciDesc.text = resources.getString(R.string.rgb_sci_name)
                binding.pestDoesDesc.text = resources.getString(R.string.rgb_does)
                binding.pestIdentifyDesc.text= resources.getString(R.string.rgb_identify)
                binding.pestImpDesc.text = resources.getString(R.string.rgb_important)
                binding.pestWwDesc.text = resources.getString(R.string.rgb_why_where)
                binding.pestMngmntDesc.text=resources.getString(R.string.rgb_mngmnt)
                binding.pestRecList.text = resources.getString(R.string.rgb_pesticide)
                binding.pestActiList.text = resources.getString(R.string.rgb_active_ing)
                //binding.link.text= resources.getString(R.string.rgb_hyperlink)


                val carouselView = binding.carouselView
                carouselView.registerLifecycle(lifecycle)
                val list = mutableListOf<CarouselItem>()
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rgb4
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
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.rgb3
                    )
                )
                carouselView.setData(list)
            }

            "lf_card" -> {
                binding.pestLabel.text = "Leaf Folder"
                binding.pestSciDesc.text = resources.getString(R.string.lf_sci_name)
                binding.pestDoesDesc.text = resources.getString(R.string.lf_does)
                binding.pestIdentifyDesc.text= resources.getString(R.string.lf_identify)
                binding.pestImpDesc.text = resources.getString(R.string.lf_important)
                binding.pestWwDesc.text = resources.getString(R.string.lf_why_where)
                binding.pestMngmntDesc.text=resources.getString(R.string.lf_mngmnt)
                binding.pestRecList.text = resources.getString(R.string.lf_pesticide)
                binding.pestActiList.text = resources.getString(R.string.lf_active_ing)
                //binding.link.text= resources.getString(R.string.lf_hyperlink)


                val carouselView = binding.carouselView
                carouselView.registerLifecycle(lifecycle)
                val list = mutableListOf<CarouselItem>()
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.lf4
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
                list.add(
                    CarouselItem(
                        imageDrawable = R.drawable.lf3
                    )
                )
                carouselView.setData(list)
            }
        }

        binding.backBtn.setOnClickListener {
            finish()
        }
    }
}