package com.oleg_kuzmenkov.android.listviewandrecyclerviewapplication;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewArrayAdapter extends ArrayAdapter<Car> {
    private final Context context;
    private List<Car> mCars;
    private TextView mIdCarTextView;
    private TextView mModelCarTextView;
    private TextView mDateOfCreationCarView;
    private TextView mTopSpeedCarView;
    private TextView mPriceCarView;
    private ImageView mImageView;

    public ListViewArrayAdapter(Context context, List<Car> cars) {
        super(context, R.layout.car_view,cars);
        this.context = context;
        mCars = cars;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.car_view, parent, false);

        mIdCarTextView = v.findViewById(R.id.car_id);
        mModelCarTextView = v.findViewById(R.id.car_model);
        mDateOfCreationCarView = v.findViewById(R.id.car_date_of_creation);
        mTopSpeedCarView = v.findViewById(R.id.car_top_speed);
        mPriceCarView = v.findViewById(R.id.car_price);
        mImageView = v.findViewById(R.id.car_image);

        mIdCarTextView.setText(mCars.get(position).getIdCar());
        mIdCarTextView.setBackgroundColor(Color.RED);
        mModelCarTextView.setText(mCars.get(position).getModelCar());
        mDateOfCreationCarView.setText(mCars.get(position).getDateOfCreationCar());
        mTopSpeedCarView.setText(mCars.get(position).getTopSpeedCar());
        mPriceCarView.setText(mCars.get(position).getPriceCar());
        mImageView.setImageDrawable(mCars.get(position).getDrawableCar());

        return v;
    }
}
