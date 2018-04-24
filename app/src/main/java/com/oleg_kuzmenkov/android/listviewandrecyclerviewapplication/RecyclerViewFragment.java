package com.oleg_kuzmenkov.android.listviewandrecyclerviewapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.List;

public class RecyclerViewFragment extends Fragment {

    private static final String BUNDLE_CONTENT = "bundle_content";
    private static final String TAG = "Message";

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;

    public static RecyclerViewFragment newInstance(List<Car> content) {
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable(BUNDLE_CONTENT, (Serializable) content);
        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        final View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        v.findViewById(R.id.floating_action_button).setVisibility(View.INVISIBLE);
        mRecyclerView = v.findViewById(R.id.note_recycler_view);
        
        if (getArguments() != null && getArguments().containsKey(BUNDLE_CONTENT)) {
            init((List<Car>) getArguments().getSerializable(BUNDLE_CONTENT));
        }
        else {
            throw new IllegalArgumentException("Must be created through newInstance(...)");
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    Log.i(TAG,"Scrolling up");
                    v.findViewById(R.id.floating_action_button).setVisibility(View.VISIBLE);
                    // Scrolling up
                } else {
                    Log.i(TAG,"Scrolling down");
                    v.findViewById(R.id.floating_action_button).setVisibility(View.INVISIBLE);
                    // Scrolling down
                }
            }
        });

        return v;
    }

    /**
     * Initialize the RecyclerView
     */
    private void init(List<Car> cars){
        if(mAdapter == null)
            mAdapter = new RecyclerViewAdapter(getActivity(),cars);

        mRecyclerView.setAdapter(mAdapter);
        //  mAdapter.notifyDataSetChanged();
    }
}
