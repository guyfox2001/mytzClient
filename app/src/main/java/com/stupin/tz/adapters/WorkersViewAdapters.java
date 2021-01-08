package com.stupin.tz.adapters;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stupin.tz.R;
import com.stupin.tz.entities.WORKER;

import java.util.ArrayList;

public class WorkersViewAdapters extends RecyclerView.Adapter<WorkersViewAdapters.NonEmptyViewHolder> {
    private LayoutInflater mInflater;
    private ArrayList<WORKER> mData;
    private Activity mContext;

    public WorkersViewAdapters( ArrayList<WORKER> mData, Activity mContext) {
        this.mData = mData;
        this.mContext = mContext;
        this.mInflater = mContext.getLayoutInflater();
    }

    @NonNull
    @Override
    public NonEmptyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_view_layout, parent, false);
        return new NonEmptyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NonEmptyViewHolder holder, int position) {
            WORKER item = mData.get(position);
            if(!item.getPhoto().contains("-1")) {
                byte[] imgArr = Base64.decode(item.getPhoto(), Base64.DEFAULT);
                Bitmap bmp = BitmapFactory.decodeByteArray(imgArr,0, imgArr.length);
                holder.workerPhoto.setImageBitmap(bmp);
            }
            if (item.getQualification() != ""){
                holder.workerDegree.setText(item.getQualification());
            }
            else {
                holder.workerDegree.setText(R.string.simple_doctor_deegree);
            }
            if(item.getSpecialization() != "") {
                holder.workerSpecialization.setText(item.getSpecialization());
            }
            else holder.workerSpecialization.setText(R.string.simple_doctor_specialization);

    }

    @Override
    public int getItemCount() {
        return this.mData.size();
    }

    public static class NonEmptyViewHolder extends RecyclerView.ViewHolder {
        final ImageView workerPhoto;
        final TextView workerSpecialization, workerDegree, workerName;
        NonEmptyViewHolder(View view){
            super(view);
            workerPhoto = (ImageView)view.findViewById(R.id.doctor_photo);
            workerName = (TextView) view.findViewById(R.id.doctor_name);
            workerSpecialization = (TextView) view.findViewById(R.id.doctor_specialization);
            workerDegree = (TextView) view.findViewById(R.id.doctor_deegree);
        }
    }
}
