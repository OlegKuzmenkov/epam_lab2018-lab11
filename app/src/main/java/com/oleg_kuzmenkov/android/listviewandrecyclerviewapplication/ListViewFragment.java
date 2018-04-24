package com.oleg_kuzmenkov.android.listviewandrecyclerviewapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.List;

public class ListViewFragment extends Fragment {

    private static final String BUNDLE_CONTENT = "bundle_content";
    private static final String TAG = "Message";

    private ListView mListView;
    private ListViewArrayAdapter mAdapter;

    public static ListViewFragment newInstance(List<Car> content) {
        ListViewFragment fragment = new ListViewFragment();
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
        final View v = inflater.inflate(R.layout.fragment_list_view, container, false);
        mListView = v.findViewById(R.id.list_view);
        v.findViewById(R.id.floating_action_button).setVisibility(View.INVISIBLE);

        if (getArguments() != null && getArguments().containsKey(BUNDLE_CONTENT)) {
            init((List<Car>) getArguments().getSerializable(BUNDLE_CONTENT));
        }
        else {
            throw new IllegalArgumentException("Must be created through newInstance(...)");
        }

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int prevVisibleItem = 0;

            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(prevVisibleItem != firstVisibleItem) {
                    if (prevVisibleItem < firstVisibleItem) {
                        //ScrollUp
                        Log.i(TAG, "SCROLLING UP");
                        v.findViewById(R.id.floating_action_button).setVisibility(View.VISIBLE);
                    } else {
                        //ScrollDown
                        Log.i(TAG, "SCROLLING DOWN");
                        v.findViewById(R.id.floating_action_button).setVisibility(View.INVISIBLE);
                    }
                    prevVisibleItem = firstVisibleItem;
                }
            }
        });
        return v;
    }

    /**
     * Initialize the ListView
     */
    private void init(List<Car> cars){
        if(mAdapter == null)
            mAdapter = new ListViewArrayAdapter(getContext(),cars);

        mListView.setAdapter(mAdapter);
        //  mAdapter.notifyDataSetChanged();
    }
}
