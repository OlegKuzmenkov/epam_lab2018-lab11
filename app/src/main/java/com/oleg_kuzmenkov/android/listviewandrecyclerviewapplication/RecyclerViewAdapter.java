package com.oleg_kuzmenkov.android.listviewandrecyclerviewapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private final Context context;
    private List<Car> mCars;

    public RecyclerViewAdapter(Context context, List<Car> cars) {
        this.context = context;
        mCars = cars;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.car_view, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Car car = mCars.get(position);
        holder.bindCar(car);
    }

    @Override
    public int getItemCount() {
        return  mCars.size();
    }
}
