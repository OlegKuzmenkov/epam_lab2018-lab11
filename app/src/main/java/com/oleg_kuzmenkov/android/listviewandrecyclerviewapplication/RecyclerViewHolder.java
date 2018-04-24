package com.oleg_kuzmenkov.android.listviewandrecyclerviewapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView mIdCarTextView;
    private TextView mModelCarTextView;
    private TextView mDateOfCreationCarView;
    private TextView mTopSpeedCarView;
    private TextView mPriceCarView;
    private ImageView mImageView;
    private Car mCar;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);

        mIdCarTextView = itemView.findViewById(R.id.car_id);
        mModelCarTextView = itemView.findViewById(R.id.car_model);
        mDateOfCreationCarView = itemView.findViewById(R.id.car_date_of_creation);
        mTopSpeedCarView = itemView.findViewById(R.id.car_top_speed);
        mPriceCarView = itemView.findViewById(R.id.car_price);
        mImageView = itemView.findViewById(R.id.car_image);
    }

    /**
     * Bind car's content
     */
    public void bindCar(Car car) {
        mCar = car;
        mIdCarTextView.setText(mCar.getIdCar());
        mModelCarTextView.setText(mCar.getModelCar());
        mDateOfCreationCarView.setText(mCar.getDateOfCreationCar());
        mTopSpeedCarView.setText(mCar.getTopSpeedCar());
        mPriceCarView.setText(mCar.getPriceCar());
        mImageView.setImageDrawable(mCar.getDrawableCar());
    }

    @Override
    public void onClick(View view) {
    }
}
