package com.mobileapp.inspestor_vr5

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.SurfaceControlViewHost
import android.view.SurfaceHolder
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.mobileapp.inspestor_vr5.databinding.ActivityMainBinding
import com.mobileapp.inspestor_vr5.ml.*
import org.tensorflow.lite.support.image.TensorImage
import java.lang.reflect.Modifier

class MainActivity : AppCompatActivity() {

//    companion object{
//        fun newInstance() = MainActivity()
//
//        const val DESIRED_WIDTH_CROP_PERCENTAGE = 20
//        const val DESIRED_HEIGHT_CROP_PERCENTAGE = 20
//
//        private const val RATIO_16_9_VALUE = 16.0 / 9.0
//        private const val RATIO_12_6_VALUE = 12.0 / 6.0
//        private const val TAG = "MainActivity"
//    }


    private lateinit var binding: ActivityMainBinding
    private lateinit var captured_Image: ImageView
    private lateinit var result_insect: TextView
    private lateinit var rec_act_ing_list: TextView
    private lateinit var brand_name: TextView

    private val GALLERY_REQUEST_CODE= 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//Main app functions and buttons activation
        captured_Image = binding.capturedImage
        result_insect=binding.resultInsect
        rec_act_ing_list=binding.recActIngList
        brand_name=binding.brandName



        binding.cameraBtn.setOnClickListener{
            takePicturePreview.launch(null)

        }

        binding.galleryBtn.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type= "image/*"
            val mimeTypes = arrayOf("image/jpeg", "image/png", "image/jpg")
            intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
            intent.flags= Intent.FLAG_GRANT_READ_URI_PERMISSION
            onResult.launch(intent)

        }

        binding.libBtn.setOnClickListener {
            startActivity(Intent(this, Library::class.java))

        }
        binding.manBtn.setOnClickListener {
            startActivity(Intent(this, Instruction::class.java))

        }

//           overlay.apply{
//           setZOrderOntTop(true)
//            holder.setFormat
//             }
    }


//    private fun drawOverlay(
//        holder: SurfaceHolder,
//        heightCropPercentage: Int,
//        widthCropPercentage: Int
//    ){
//        val canvas = holder.lockCanvas()
//        val bgPaint = Paint().apply{
//            alpha = 140
//        }
//        canvas.drawPaint(bgPaint)
//        val rectPaint = Paint()
//        rectPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
//        rectPaint.style = Paint.Style.FILL
//        rectPaint.color = Color.WHITE
//        val outlinePaint = Paint()
//        outlinePaint.style= Paint.Style.STROKE
//        outlinePaint.color = Color.WHITE
//        outlinePaint.strokeWidth = 4f
//        val surfaceWidth = holder.surfaceFrame.width()
//        val surfaceHeight = holder.surfaceFrame.height()
//
//        val cornerRadius = 25f
//    //set rect centered in frame
//        val rectTop = surfaceHeight * heightCropPercentage / 2 / 100f
//        val rectLeft = surfaceWidth * widthCropPercentage / 2 / 100f
//        val rectRight = surfaceWidth * (1 - widthCropPercentage / 2 / 100f)
//        val rectBottom = surfaceHeight * (1 - heightCropPercentage / 2 / 100f)
//        val rect = RectF(rectLeft, rectTop, rectRight, rectBottom)
//        canvas.drawRoundRect(
//            rect, cornerRadius, cornerRadius, rectPaint )
//        canvas.drawRoundRect(
//            rect, cornerRadius, cornerRadius, outlinePaint )
//
//        val textPaint = Paint()
//        textPaint.color = Color.WHITE
//        textPaint.textSize = 50f
//
//        val overlayText = getString(R.string.overlay_text)
//        val textBounds = Rect()
//        textPaint.getTextBounds(overlayText, 0, overlayText.length, textBounds)
//        val textX = (surfaceWidth - textBounds.width()) / 2f
//        val textY = rectBottom + textBounds.height() + 15f // text overlay below the box
//        canvas.drawText(getString(R.string.overlay_text), textX, textY, textPaint)
//        holder.unlockCanvasAndPost(canvas)
//    }

    private val takePicturePreview = registerForActivityResult (ActivityResultContracts.TakePicturePreview()) { bitmap ->

        if(bitmap != null){
            captured_Image.setImageBitmap(bitmap)
            outputGenerator(bitmap)
        }
    }


    private val onResult= registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->
        Log.i("TAG", "this is the result: ${result.data} ${result.resultCode}")
        onResultReceived(GALLERY_REQUEST_CODE, result)
    }

    private fun onResultReceived(requestCode:Int, result: ActivityResult?){
        when(requestCode){
            GALLERY_REQUEST_CODE->{
                if(result?.resultCode== Activity.RESULT_OK){
                    result.data?.data?.let{uri->
                        Log.i("Tag", "onResultReceived: $uri")
                        val bitmap= BitmapFactory.decodeStream(contentResolver.openInputStream(uri))
                        captured_Image.setImageBitmap(bitmap)
                        outputGenerator(bitmap)
                    }
                }
                else{
                    Log.e("Tag", "onActivityResult:error in selecting image")
                }
            }
        }
    }
    @SuppressLint("SetTextI18n")
    private fun outputGenerator(bitmap: Bitmap){
        val TestTrainModel = Testtrainmetadata640x640WbgPbg.newInstance(this)

        //Creates inputs for reference.
        val newBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true)
        val tfImage= TensorImage.fromBitmap(newBitmap)

        //Runs model inference and gets result
        val outputs=TestTrainModel.process(tfImage).detectionResultList.apply {
            sortByDescending {
                it.scoreAsFloat
            }
        }
        val detectionResult=outputs[0]
        if(detectionResult.scoreAsFloat <= .25){
            result_insect.text="No pest detected"
            rec_act_ing_list.text=" "
            brand_name.text=" "
           // prob_score.text=" "
        }else{
            result_insect.text = detectionResult.categoryAsString + " " + detectionResult.scoreAsFloat
            //prob_score.text= detectionResult.scoreAsFloat + ""
            Log.i("Tag", "outputGenerator: $detectionResult")

            when (detectionResult.categoryAsString) {
                "Rice Grain Bug" -> {
                    binding.recActIngList.text=resources.getString(R.string.rgb_activeI)
                    binding.brandName.text=resources.getString(R.string.rgb_pesticide)

                    binding.cardResult.setOnClickListener {
                    startActivity(Intent(this, LibPestInfo::class.java)
                        .putExtra("card", "rgb_card" ))
                     }
                }

                "Rice Bug" -> {
                    binding.recActIngList.text=resources.getString(R.string.rb_activeI)
                    binding.brandName.text=resources.getString(R.string.rb_pesticide)

                    binding.cardResult.setOnClickListener {
                        startActivity(Intent(this, LibPestInfo::class.java)
                            .putExtra("card", "rb_card" ))
                    }
                }

                "Brown Planthopper" -> {
                    binding.recActIngList.text=resources.getString(R.string.bph_activeI)
                    binding.brandName.text=resources.getString(R.string.bph_pesticide)

                    binding.cardResult.setOnClickListener {
                        startActivity(Intent(this, LibPestInfo::class.java)
                            .putExtra("card", "bph_card" ))
                    }
                }

                "Leaf Folder" ->{
                    binding.recActIngList.text=resources.getString(R.string.lf_activeI)
                    binding.brandName.text=resources.getString(R.string.lf_pesticide)

                    binding.cardResult.setOnClickListener {
                        startActivity(Intent(this, LibPestInfo::class.java)
                            .putExtra("card", "lf_card" ))
                    }
                }

                "Green Planthopper" -> {
                    binding.recActIngList.text=resources.getString(R.string.glh_activeI)
                    binding.brandName.text=resources.getString(R.string.glh_pesticide)

                    binding.cardResult.setOnClickListener {
                        startActivity(Intent(this, LibPestInfo::class.java)
                            .putExtra("card", "glh_card" ))
                    }
                }

                "Rice Black Bug" -> {
                    binding.recActIngList.text=resources.getString(R.string.rbb_activeI)
                    binding.brandName.text=resources.getString(R.string.rbb_pesticide)

                    binding.cardResult.setOnClickListener {
                        startActivity(Intent(this, LibPestInfo::class.java)
                            .putExtra("card", "rbb_card" ))
                    }
                }

            /*if (detectionResult.categoryAsString == "Rice Grain Bug"){
                rec_act_ing_list.text = "LAMBDA-CYHALOTHRIN 25 g/L" + "\n" + "N CYPERMETHRIN 50g/L" + "\n" + "DIAZINON 600 g/L"
                brand_name.text = "LAMDAXIN 2.5 EC " + "\n" + "AGRO CYPERMETHRIN 5 EC " + "\n" + "TRUGOLD 60 EC"
            }
            else if (detectionResult.categoryAsString == "Rice Bug"){
                rec_act_ing_list.text = "LAMBDA-CYHALOTHRIN 25 g/L" + "\n" + "DIAZINON 600 g/L" + "\n" + "N CYPERMETHRIN 50g/L"
                brand_name.text = "LAMDAXIN 2.5 EC" + "\n" + "SUPERSMAK 50 EC" + "\n" + "TRUGOLD 60 EC"
            }
            else if (detectionResult.categoryAsString == "Brown Planthopper"){
                rec_act_ing_list.text = "PHENTHOATE 500 g/L" + "\n" + "PHENTHOATE+BPMC 250 g/L" + "\n" + "CYPERMETHRIN 50g/L"
                brand_name.text = "PHENOM 50 EC " + "\n" + "PHENDEX 350 EC " + "\n" + "DISCOVERY 5 EC"
            }
            else if (detectionResult.categoryAsString == "Leaf Folder"){
                rec_act_ing_list.text = "ETOFENPROX 25 g/L" + "\n" + "CYPERMETHRIN 55 g/L" + "\n" + "DIAZINON 600g/L"
                brand_name.text = "TREBON 10 EC " + "\n" + "SUNO CYPERMETHRIN 5 EC" + "\n" + "TRUGOLD 60 EC"
            }
            else if (detectionResult.categoryAsString == "Green Planthopper"){
                rec_act_ing_list.text = "LAMBDA-CYHALOTHRIN 25 g/L" + "\n" + "CYPERMETHRIN 50 g/L" + "\n" + "PHENTOATE 500g/L"
                brand_name.text = "LAMDAXIN 2.5 EC " + "\n" + "AGRO CYPERMETHRIN 5 EC " + "\n" + "PHENOM 50 EC"
            }
            else if (detectionResult.categoryAsString == "Rice Black Bug"){
                rec_act_ing_list.text = "DELTAMETHRIN 25 g/L" + "\n" + "BETA-CYPHERMETRIN 25 g/L" + "\n" + "AZADIRACHTIN 3g/L"
                brand_name.text = "DECIS 2.5 EC " + "\n" + "CHIX 2.5 EC" + "\n" + "NIMBECIDINE"
            }
            else {
                rec_act_ing_list.text = " "
                brand_name.text = " "
            }*/
        }

        TestTrainModel.close()

      }
    }
    override fun onResume() {
        super.onResume()
    }

}

