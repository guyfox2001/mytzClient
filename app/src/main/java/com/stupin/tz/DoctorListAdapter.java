package com.stupin.tz;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.stupin.tz.entities.DOCTOR;

import java.util.ArrayList;
import java.util.List;

public class DoctorListAdapter extends ArrayAdapter<DOCTOR> {

    public Activity mActivity;
    public LayoutInflater mInflater;
    public ArrayList<DOCTOR> mData;

    public DoctorListAdapter(@NonNull Activity context, int resource, ArrayList<DOCTOR> mData) {
        super(context, resource, mData);
        this.mData = mData;
        this.mActivity = context;
        this.mInflater = context.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Nullable
    @Override
    public DOCTOR getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getPosition(@Nullable DOCTOR item) {
        return mData.indexOf(item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View row = convertView;
        if (row == null) {
            row = mInflater.inflate(R.layout.spinner_layout, parent, false);
        }

        if(mData != null && mData.size() != 0) { // парсим данные с каждого объекта

            TextView myDoctors = (TextView) row.findViewById(R.id.spiner_textView);

            if (myDoctors != null)
                myDoctors.setText(mData.get(position).getName());
        }
        return row;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = mInflater.inflate(R.layout.spinner_dropdown_layount, parent, false);
        }

        if(mData != null && mData.size() != 0) { // парсим данные с каждого объекта

            TextView myDoctors = (TextView) row.findViewById(R.id.spiner_dropdown_textView);

            if (myDoctors != null)
                myDoctors.setText(mData.get(position).getName());
        }
        return row;
    }
}
