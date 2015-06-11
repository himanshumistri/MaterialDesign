package com.himotech.matrialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.himotech.models.Items;

import java.util.ArrayList;

/**
 *
 * /*Copyright 2015 Himanshu Mistri
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 * Created by ubbvand2 on 5/6/15.
 */
public  class HomeSectionAdapter extends RecyclerView.Adapter<HomeSectionAdapter.HomeSectionViewHolder>{


    private Context _Context;

    private LayoutInflater mLayoutInflater;


    private ArrayList<Items> mArrayList;

    public HomeSectionAdapter(Context _context,ArrayList<Items> mList){

        this._Context=_context;

        this.mArrayList=mList;

        mLayoutInflater=(LayoutInflater)_Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }



    @Override
    public HomeSectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        HomeSectionViewHolder mHomeSectionViewHolder=null;

        if(viewType==Items.ITEM_SECTION){

            View mView=mLayoutInflater.inflate(R.layout.custom_list_section_row,parent,false);

            mHomeSectionViewHolder=new HomeSectionViewHolder(mView,viewType);
        }else{

            View mView=mLayoutInflater.inflate(R.layout.custom_list_homesection_row,parent,false);

            mHomeSectionViewHolder=new HomeSectionViewHolder(mView,viewType);

        }
        return mHomeSectionViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeSectionViewHolder holder, int position) {

        Items mItem=mArrayList.get(position);

        holder.setData(mItem);

    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mArrayList.get(position).getItemType();
    }

    public class HomeSectionViewHolder extends RecyclerView.ViewHolder{

        private TextView mTxtTitle;


        private TextView mTxtDirectoryName;

        private TextView mTxtDate;

        private ImageButton mImgBtn;



        public HomeSectionViewHolder(View itemView,int mViewType) {
            super(itemView);

            if(mViewType==Items.ITEM_ROW){

                mTxtDirectoryName=(TextView)itemView.findViewById(R.id.txt_directory_name);
                mTxtDate=(TextView)itemView.findViewById(R.id.txt_created_date);
                mImgBtn=(ImageButton)itemView.findViewById(R.id.img_btn);


                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent mStartDrawer=new Intent(_Context,DrawerNewActivity.class);
                        _Context.startActivity(mStartDrawer);
                    }
                });
            }else{
                mTxtTitle=(TextView)itemView.findViewById(R.id.txt_title_section);
            }


        }


        public void setData(Items mItems){

            if(mItems.getItemType()==Items.ITEM_ROW){

                mTxtDirectoryName.setText(mItems.getmDirectoryName());

                mTxtDate.setText(mItems.getmDate());

                mImgBtn.setBackgroundResource(mItems.getImgeColor());

            }else{

                mTxtTitle.setText(mItems.getmSectionTitle());

            }


        }
    }

}


