package com.mobileapp.inspestor_vr5.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.mobileapp.inspestor_vr5.databinding.FragmentOnBoardBinding

class OnBoardFragment : Fragment() {
    private lateinit var title: String
    private lateinit var desc: String
    private var imageResource = 0
    private lateinit var titleView: AppCompatTextView
    private lateinit var descView: AppCompatTextView
    private lateinit var image: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            title = requireArguments().getString(ARG_PARAM1)!!
            desc = requireArguments().getString(ARG_PARAM2)!!
            imageResource = requireArguments().getInt(ARG_PARAM3)
        }
    }

    private var fBinding: FragmentOnBoardBinding? =null

    private val binding get() = fBinding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fBinding = FragmentOnBoardBinding.inflate(inflater, container, false)
        val view = binding.root
        titleView= binding.titleOnboard
        descView = binding.descOnboard
        image = binding.lottieImg
        titleView.text = title
        descView.text = desc
        image.setAnimation(imageResource)
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fBinding = null
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        private const val ARG_PARAM3 = "param3"

        fun newInstance(
            title: String?,
            desc: String?,
        imageResource: Int
        ): OnBoardFragment{
            val fragment = OnBoardFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, title)
            args.putString(ARG_PARAM2, desc)
            args.putInt(ARG_PARAM3, imageResource)
            fragment.arguments = args
            return fragment
        }
    }
}