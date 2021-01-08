package com.stupin.tz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stupin.tz.adapters.DoctorListAdapter
import com.stupin.tz.adapters.WorkersViewAdapters
import com.stupin.tz.app_service.MainService
import com.stupin.tz.entities.DOCTOR
import com.stupin.tz.entities.WORKER
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var ChoicedId:Int = -1;
    val mainService:MainService = MainService(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun get_ChoicedId() : Int{
        return this.ChoicedId;
    }
    override fun onResume() {
        super.onResume()
        mainService.updAllDoctorArrayList()
        mainService.updWorkersArrayList()
    }
    fun initSpinner(){
        val adpter = DoctorListAdapter(
            this,
            R.layout.spinner_layout,
            mainService.doctorArrayList);
        this.spinner.adapter =adpter;
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected( parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val item = spinner.selectedItem as DOCTOR;
                ChoicedId = item.id;
                initRecyclerView();
            }
            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }
    fun initRecyclerView(){
        var item:ArrayList<WORKER> = mainService.onFilterWorkers(this.ChoicedId)
        if (item.size != 0){
            val adapter= WorkersViewAdapters(item, this);
            this.recyclerView.layoutManager = LinearLayoutManager(this);
            this.recyclerView.adapter = adapter;
        }
        else {
            showMessage(getString(R.string.empty_filter))
            val adapter= WorkersViewAdapters(item, this);
            this.recyclerView.layoutManager = LinearLayoutManager(this);
            this.recyclerView.adapter = adapter;
        }
    }
    fun showMessage(StringMessage: String){
        Toast.makeText(this, StringMessage, Toast.LENGTH_SHORT).show();
    }
}