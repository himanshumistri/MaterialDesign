package com.himotech.matrialdesign;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ubbvand2 on 2/6/15.
 */
public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.HomeViewHolder> {


    public HomeListAdapter(){

        super();
    }


    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View mView= LayoutInflater.from(parent.getContext()).inflate(com.himotech.matrialdesign.R.layout.custom_list_home_row,parent,false);

        return new HomeViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {

                holder.setData("List Item"+ position);

    }

    @Override
    public int getItemCount() {
        return 20;
    }


    public class HomeViewHolder extends RecyclerView.ViewHolder{

        private TextView mTxtTitle;


        public HomeViewHolder(View itemView) {
            super(itemView);

            mTxtTitle=(TextView)itemView.findViewById(com.himotech.matrialdesign.R.id.textView);
        }


        public void setData(String mTxtData){

            mTxtTitle.setText(mTxtData);

        }
    }
}
