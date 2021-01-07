package com.stupin.tz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.stupin.tz.app_service.MainService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mainService:MainService = MainService(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        mainService.updAllDoctorArrayList()
    }
    fun initSpinner(){
        val adpter = DoctorListAdapter(this, R.layout.spinner_layout, mainService.doctorArrayList);
        this.spinner.adapter =adpter;
    }
    fun showMessage(StringMessage: String){
        Toast.makeText(this, StringMessage, Toast.LENGTH_SHORT).show();
    }
}