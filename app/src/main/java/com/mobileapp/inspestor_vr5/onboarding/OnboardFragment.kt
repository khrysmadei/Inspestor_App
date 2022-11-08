package com.mobileapp.inspestor_vr5.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.mobileapp.inspestor_vr5.databinding.FragmentOnboardBinding

class OnboardFragment : Fragment(){
    private var title: String? = null
    private var description: String? = null
    private var imageResource = 0

    private lateinit var tTtile: androidx.appcompat.widget.AppCompatTextView
    private lateinit var tDescription: androidx.appcompat.widget.AppCompatTextView
    private lateinit var image: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null){
            title=requireArguments().getString(ARG_PARAM1)
            description=requireArguments().getString(ARG_PARAM2)
            imageResource=requireArguments().getInt(ARG_PARAM3)
        }
    }

    private var _binding: FragmentOnboardBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardBinding.inflate(inflater, container, false)
        val view = binding.root

        tTtile = binding.onboardingTitle
        tDescription = binding.onboardingDescription
        image = binding.imageBoarding1
        tTtile.text = title
        tDescription.text = description
        image.setAnimation(imageResource)
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object{
        private  const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        private const val ARG_PARAM3 = "param3"

        fun newInstance(
            title:String?,
            description:String?,
            imageResource:Int
        ): OnboardFragment {
            val fragment = OnboardFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, title)
            args.putString(ARG_PARAM2, description)
            args.putInt(ARG_PARAM3, imageResource)
            fragment.arguments = args
            return fragment
        }
    }

}
