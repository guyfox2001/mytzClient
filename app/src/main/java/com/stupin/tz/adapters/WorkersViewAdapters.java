package com.stupin.tz.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stupin.tz.activities.MainActivity;
import com.stupin.tz.R;
import com.stupin.tz.entities.WORKER;

import java.util.ArrayList;

public class WorkersViewAdapters extends RecyclerView.Adapter<WorkersViewAdapters.NonEmptyViewHolder> {
    private LayoutInflater mInflater;
    private ArrayList<WORKER> mData;
    private MainActivity mContext;

    public WorkersViewAdapters( ArrayList<WORKER> mData, MainActivity mContext) {
        this.mData = mData;
        this.mContext = mContext;
        this.mInflater = mContext.getLayoutInflater();
    }

    public void setmData(ArrayList<WORKER> mData) {
        this.mData = mData;
        notifyDataSetChanged();
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
            if(!item.getName().equals("")){
                holder.workerName.setText(item.getName());
            }
            else{
                holder.workerName.setText(R.string.simple_doctor_name);
            }
            if(!item.getPhoto().equals("-1")) {
                byte[] imgArr = Base64.decode(item.getPhoto(), Base64.DEFAULT);
                Bitmap bmp = BitmapFactory.decodeByteArray(imgArr,0, imgArr.length);
                holder.workerPhoto.setImageBitmap(bmp);
            }
            else{
                    holder.workerPhoto.setImageDrawable(mContext.getDrawable(R.drawable.simple_avatar));
            }
            if (!item.getQualification().equals("")){
                holder.workerDegree.setText(item.getQualification());
            }
            else {
                holder.workerDegree.setText(R.string.simple_doctor_deegree);
            }
            if(!item.getSpecialization().equals("")) {
                holder.workerSpecialization.setText(item.getSpecialization());
            }
            else holder.workerSpecialization.setText(R.string.simple_doctor_specialization);
            holder.bind(mContext, mContext, item);

    }

    @Override
    public int getItemCount() {
        return this.mData.size();
    }
    public static class NonEmptyViewHolder extends RecyclerView.ViewHolder {
        final ImageView workerPhoto;
        final TextView workerSpecialization, workerDegree, workerName;
        final Button writeButton, infoButton;
        NonEmptyViewHolder(View view){
            super(view);
            workerPhoto = view.findViewById(R.id.doctor_photo);
            workerName = view.findViewById(R.id.doctor_name);
            workerSpecialization = view.findViewById(R.id.doctor_specialization);
            workerDegree = view.findViewById(R.id.doctor_deegree);
            writeButton = view.findViewById(R.id.write_button);
            infoButton = view.findViewById(R.id.info_button);
        }
        public  void bind(final OnWriteButtonClick wb, final OnInfoButtonClick ib, final WORKER item){
            writeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wb.onWriteButtonClick(item);
                }
            });
            infoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ib.onInfoButtonClick(item);
                }
            });
        }
    }
    public interface OnWriteButtonClick{
        public void onWriteButtonClick(WORKER Item);
    }
    public interface OnInfoButtonClick{
        public void onInfoButtonClick(WORKER Item);
    }
}
