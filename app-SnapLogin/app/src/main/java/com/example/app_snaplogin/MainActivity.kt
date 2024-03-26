package com.example.app_snaplogin

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //VARIABLES
    private lateinit var tvTitle: TextView
    private lateinit var imgViewCamera: ImageView
    private lateinit var btnTakePic : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //TYPECASTING
        tvTitle = findViewById(R.id.textView)
        imgViewCamera = findViewById(R.id.imageView)
        btnTakePic = findViewById(R.id.btnCapture)


    }

    // CTRL 0 -> See all methods

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        try{
            val bm = data?.extras?.get("data") as Bitmap
            //send the data --> imageview
            imgViewCamera.setImageBitmap(bm)
        } catch(ex:Exception)
        {
            Toast.makeText(
                this@MainActivity, "tk 4 da...", Toast.LENGTH_SHORT).show()
        }


    }//methods ends
    fun CaptureImage(View: View)
    {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 0)
    }

}



/* CAMERA FEATURE RULES

-- Mediastore -- capture --> type of image
-- works with intent service
-- startActivityForResult -- images
    -- excepts a image result to be returned
    1 -- request code -- handles which activity
    2 -- result code -- whether it worked or not
    3 -- data -- is the actual picture
Bitmap -- image type and factory

 */
