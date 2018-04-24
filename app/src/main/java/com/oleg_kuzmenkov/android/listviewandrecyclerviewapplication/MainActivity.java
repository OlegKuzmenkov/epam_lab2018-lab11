package com.oleg_kuzmenkov.android.listviewandrecyclerviewapplication;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private final String RECYCLER_VIEW_FRAGMENT = "class com.oleg_kuzmenkov.android.listviewandrecyclerviewapplication.RecyclerViewFragment";

    private List<Car> mCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        final FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = RecyclerViewFragment.newInstance(mCars);
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }

        Button change_button = findViewById(R.id.change_fragment_button);
        change_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = fm.findFragmentById(R.id.fragment_container);
                Button change_button = findViewById(R.id.change_fragment_button);

                if(RECYCLER_VIEW_FRAGMENT.equalsIgnoreCase(fragment.getClass().toString())){
                    fragment = ListViewFragment.newInstance(mCars);
                    change_button.setText("Go to RecyclerView");
                }
                else {
                    fragment = RecyclerViewFragment.newInstance(mCars);
                    change_button.setText("Go to ListView");
                }

                fm.beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });
    }

    /**
     * Initialize the list of cars
     */
    private void init(){
        mCars = new ArrayList<>();
        Resources res = getResources();

        Car car = new Car();
        car.setIdCar("Car #1");
        car.setModelCar("Acura NSX");
        car.setDateOfCreationCar("Year: 2010 ");
        car.setTopSpeedCar("Top speed: 306 km/h");
        car.setPriceCar("Price: 33 700$");
        car.setDrawableCar(res.getDrawable(R.drawable.acura_nsx));
        mCars.add(car);

        car = new Car();
        car.setIdCar("Car #2");
        car.setModelCar("BMV M6");
        car.setDateOfCreationCar("Year: 2011 ");
        car.setTopSpeedCar("Top speed: 300 km/h");
        car.setPriceCar("Price: 29 400$");
        car.setDrawableCar(res.getDrawable(R.drawable.bmv_m6));
        mCars.add(car);

        car = new Car();
        car.setIdCar("Car #3");
        car.setModelCar("Honda Accord");
        car.setDateOfCreationCar("Year: 2014 ");
        car.setTopSpeedCar("Top speed: 250 km/h");
        car.setPriceCar("Price: 18 500$");
        car.setDrawableCar(res.getDrawable(R.drawable.honda_accord));
        mCars.add(car);

        car = new Car();
        car.setIdCar("Car #4");
        car.setModelCar("Lamborgini Aventador");
        car.setDateOfCreationCar("Year: 2017 ");
        car.setTopSpeedCar("Top speed: 350 km/h");
        car.setPriceCar("Price: 230 000$");
        car.setDrawableCar(res.getDrawable(R.drawable.lambo_aventador));
        mCars.add(car);

        car = new Car();
        car.setIdCar("Car #5");
        car.setModelCar("Audi SQ5");
        car.setDateOfCreationCar("Year: 2016 ");
        car.setTopSpeedCar("Top speed: 260 km/h");
        car.setPriceCar("Price: 40 000$");
        car.setDrawableCar(res.getDrawable(R.drawable.audi_sq5));
        mCars.add(car);

        car = new Car();
        car.setIdCar("Car #6");
        car.setModelCar("Mercedez E");
        car.setDateOfCreationCar("Year: 2014 ");
        car.setTopSpeedCar("Top speed: 239 km/h");
        car.setPriceCar("Price: 14 000$");
        car.setDrawableCar(res.getDrawable(R.drawable.mercedez_e));
        mCars.add(car);

        car = new Car();
        car.setIdCar("Car #7");
        car.setModelCar("Volkswagen Passat");
        car.setDateOfCreationCar("Year: 2016 ");
        car.setTopSpeedCar("Top speed: 232 km/h");
        car.setPriceCar("Price: 22 000$");
        car.setDrawableCar(res.getDrawable(R.drawable.vw_passat));
        mCars.add(car);

        car = new Car();
        car.setIdCar("Car #8");
        car.setModelCar("Ferrari California");
        car.setDateOfCreationCar("Year: 2014 ");
        car.setTopSpeedCar("Top speed: 315 km/h");
        car.setPriceCar("Price: 144 000$");
        car.setDrawableCar(res.getDrawable(R.drawable.ferrary_california));
        mCars.add(car);

        car = new Car();
        car.setIdCar("Car #9");
        car.setModelCar("Ford Escape");
        car.setDateOfCreationCar("Year: 2012 ");
        car.setTopSpeedCar("Top speed: 160 km/h");
        car.setPriceCar("Price: 12 400$");
        car.setDrawableCar(res.getDrawable(R.drawable.ford_escape));
        mCars.add(car);

        car = new Car();
        car.setIdCar("Car #10");
        car.setModelCar("Mitsubishi Lancer");
        car.setDateOfCreationCar("Year: 2015 ");
        car.setTopSpeedCar("Top speed: 230 km/h");
        car.setPriceCar("Price: 19 000$");
        car.setDrawableCar(res.getDrawable(R.drawable.mitsubishi_lancer));
        mCars.add(car);
    }
}
