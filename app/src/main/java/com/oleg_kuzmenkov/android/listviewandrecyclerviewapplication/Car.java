package com.oleg_kuzmenkov.android.listviewandrecyclerviewapplication;

import android.graphics.drawable.Drawable;

public class Car {
    private String mIdCar;
    private String mModelCar;
    private String mDateOfCreationCar;
    private String mTopSpeedCar;
    private String mPriceCar;
    private Drawable mDrawableCar;

    public Car() {
    }

    public String getIdCar() {
        return mIdCar;
    }

    public void setIdCar(String idCar) {
        mIdCar = idCar;
    }

    public String getModelCar() {
        return mModelCar;
    }

    public void setModelCar(String modelCar) {
        mModelCar = modelCar;
    }

    public String getDateOfCreationCar() {
        return mDateOfCreationCar;
    }

    public void setDateOfCreationCar(String dateOfCreationCar) {
        mDateOfCreationCar = dateOfCreationCar;
    }

    public String getTopSpeedCar() {
        return mTopSpeedCar;
    }

    public void setTopSpeedCar(String topSpeedCar) {
        mTopSpeedCar = topSpeedCar;
    }

    public String getPriceCar() {
        return mPriceCar;
    }

    public void setPriceCar(String priceCar) {
        mPriceCar = priceCar;
    }

    public Drawable getDrawableCar() {
        return mDrawableCar;
    }

    public void setDrawableCar(Drawable drawableCar) {
        mDrawableCar = drawableCar;
    }
}
