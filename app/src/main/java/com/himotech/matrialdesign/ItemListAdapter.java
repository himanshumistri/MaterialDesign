package com.himotech.matrialdesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.himotech.models.Items;

import java.util.ArrayList;

/**
 * Created by ubbvand2 on 11/6/15.
 */
public class ItemListAdapter extends ArrayAdapter<Items>{


    private LayoutInflater mLayoutInflater;

    private Context _Context;

    private ArrayList<Items> mArrayData;


    public ItemListAdapter(Context context, int resource, ArrayList<Items> objects) {
        super(context, resource, objects);
        this._Context=context;
        this.mArrayData=objects;
        mLayoutInflater=(LayoutInflater)_Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewItemHolder mViewItemHolder;


        if(convertView==null){

            convertView= mLayoutInflater.inflate(R.layout.custom_list_homesection_row,parent,false);
            mViewItemHolder=new ViewItemHolder();

            mViewItemHolder.mTxtDirectoryName=(TextView)convertView.findViewById(R.id.txt_directory_name);
            mViewItemHolder.mTxtDate=(TextView)convertView.findViewById(R.id.txt_created_date);
            mViewItemHolder.mImgBtn=(ImageButton)convertView.findViewById(R.id.img_btn);

            convertView.setTag(mViewItemHolder);

        }else{

            mViewItemHolder=(ViewItemHolder)convertView.getTag();
        }


        Items mItems=getItem(position);


        mViewItemHolder.mTxtDirectoryName.setText(mItems.getmDirectoryName());

        mViewItemHolder.mTxtDate.setText(mItems.getmDate());

        mViewItemHolder.mImgBtn.setBackgroundResource(mItems.getImgeColor());

        return convertView;
    }



    public class ViewItemHolder{

        private TextView mTxtTitle;

        private TextView mTxtDirectoryName;

        private TextView mTxtDate;

        private ImageButton mImgBtn;

    }

}
