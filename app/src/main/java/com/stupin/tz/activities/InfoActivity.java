package com.stupin.tz.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stupin.tz.R;
import com.stupin.tz.entities.WORKER;

import java.util.Objects;

public class InfoActivity extends AppCompatActivity {
    public WORKER Input;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Input = WORKER.getmInstance();
        LinearLayout layout = findViewById(R.id.main_layout);
        ImageView doctor_photo = findViewById(R.id.doctor_photo_on_activity);
        TextView docName = findViewById(R.id.doctor_name);
        TextView docDeegree = findViewById(R.id.doctor_deegree);
        TextView docDec = findViewById(R.id.doctor_descr);
        TextView docSpec = findViewById(R.id.doctor_specialization);
        TextView expText = findViewById(R.id.exp_work_text);
        TextView specText = findViewById(R.id.text_specialization);
        if(!Input.getPhoto().equals("-1")) {
            byte[] imgArr = Base64.decode(Input.getPhoto(), Base64.DEFAULT);
            Bitmap bmp = BitmapFactory.decodeByteArray(imgArr,0, imgArr.length);
            doctor_photo.setImageBitmap(bmp);
        }
        else{
            doctor_photo.setImageDrawable(this.getDrawable(R.drawable.simple_avatar));
        }
        if (!Input.getName().equals("")){
            docName.setText(Input.getName());
        }
        else {
            layout.removeView(docName);
        }

        if (!Input.getQualification().equals("")&& !Input.getQualification().equals("-1")){
            docDeegree.setText(Input.getQualification());
        }
        else {
            layout.removeView(docDeegree);
        }

        if (!Input.getDesc().equals("") && !Input.getDesc().equals("-1")){

            docDec.setText(Input.getDesc());
        } else {
            layout.removeView(docDec);
            layout.removeView(expText);
        }
        if (!Input.getServices().equals("") && !Input.getServices().equals("-1")){
            docSpec.setText(Input.getServices());
        } else {
            layout.removeView(specText);
            layout.removeView(docSpec);
        }

    }
}