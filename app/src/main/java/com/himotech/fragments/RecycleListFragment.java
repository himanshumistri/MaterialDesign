package com.himotech.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.himotech.matrialdesign.HomeListAdapter;
import com.himotech.matrialdesign.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecycleListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecycleListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView mRecyclerView;
    private HomeListAdapter mHomeListAdapter;



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecycleListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecycleListFragment newInstance(String param1, String param2) {
        RecycleListFragment fragment = new RecycleListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public RecycleListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView =inflater.inflate(R.layout.fragment_recycle_list, container, false);
        initView(mView);

        return mView;
    }


    private void initView(View mView){

        mRecyclerView=(RecyclerView)mView.findViewById(com.himotech.matrialdesign.R.id.list_recycle);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mHomeListAdapter=new HomeListAdapter();


        mRecyclerView.setAdapter(mHomeListAdapter);

    }


}
