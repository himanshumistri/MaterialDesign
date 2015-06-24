package com.himotech.matrialdesign;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.himotech.models.Items;

import java.util.ArrayList;

/*Copyright 2015 Himanshu Mistri

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.*/
public class CollapseToolBarActivity extends AppCompatActivity {



    private CollapsingToolbarLayout mCollapsTbar;

    private AppBarLayout mAppBarLayout;

    private RecyclerView mRecycleList;

    private Toolbar mToolBarHome;

    //private HomeListAdapter mHomeListAdapter;

    private HomeSectionAdapter mHomeSectionAdapter;


    private ArrayList<Items> mArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.himotech.matrialdesign.R.layout.activity_collapse_tool_bar);

        initView();
    }



    private void  initView(){


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mArrayList=new ArrayList<>();

        mRecycleList=(RecyclerView)findViewById(com.himotech.matrialdesign.R.id.list_recycle_collapse);

        mRecycleList.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        mRecycleList.addItemDecoration(itemDecoration);

        // allows for optimizations if all item views are of the same size:
       // mRecycleList.setHasFixedSize(true);

        mCollapsTbar=(CollapsingToolbarLayout)findViewById(com.himotech.matrialdesign.R.id.collpse_toolbar_layout);

        mToolBarHome=(Toolbar)findViewById(com.himotech.matrialdesign.R.id.toolbar_collapse);


        mCollapsTbar.setTitle("Collapse Toolbar");

       // mHomeListAdapter=new HomeListAdapter();

        Items mItems1=new Items();

        mItems1.setItemType(Items.ITEM_SECTION);

        mItems1.setmSectionTitle("Folders");

        mArrayList.add(mItems1);




        Items mItems2=new Items();

        mItems2.setItemType(Items.ITEM_ROW);

        mItems2.setmDirectoryName("Photos");

        mItems2.setmDate("19 Jan,2015");
        mItems2.setImgeColor(R.drawable.gray_round);

        mArrayList.add(mItems2);


        Items mItems3=new Items();

        mItems3.setItemType(Items.ITEM_ROW);

        mItems3.setmDirectoryName("Recipes");

        mItems3.setmDate("20 Jan,2015");
        mItems3.setImgeColor(R.drawable.gray_round);

        mArrayList.add(mItems3);


        Items mItems4=new Items();

        mItems4.setItemType(Items.ITEM_ROW);

        mItems4.setmDirectoryName("Work");

        mItems4.setmDate("28 Jan,2015");
        mItems4.setImgeColor(R.drawable.gray_round);

        mArrayList.add(mItems4);


        Items mItems5=new Items();

        mItems5.setItemType(Items.ITEM_SECTION);

        mItems5.setmSectionTitle("Files");

        mArrayList.add(mItems5);

        Items mItems6=new Items();

        mItems6.setItemType(Items.ITEM_ROW);

        mItems6.setmDirectoryName("Vacation Itinerary");

        mItems6.setmDate("20 Jan,2014");
        mItems6.setImgeColor(R.drawable.green_round);

        mArrayList.add(mItems6);


        Items mItems7=new Items();

        mItems7.setItemType(Items.ITEM_ROW);

        mItems7.setmDirectoryName("Kiten Remodel");

        mItems7.setmDate("10 Jan,2014");

        mItems7.setImgeColor(R.drawable.blue_round);

        mArrayList.add(mItems7);

        Items mItems8=new Items();

        mItems8.setItemType(Items.ITEM_ROW);

        mItems8.setmDirectoryName("Project Schedule");

        mItems8.setmDate("15 Jan,2014");
        mItems8.setImgeColor(R.drawable.green_round);

        mArrayList.add(mItems8);



        setSupportActionBar(mToolBarHome);



        mHomeSectionAdapter=new HomeSectionAdapter(this,mArrayList);

        mRecycleList.setAdapter(mHomeSectionAdapter);




       // mRecycleList.setAdapter(mHomeListAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.himotech.matrialdesign.R.menu.menu_collapse_tool_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.himotech.matrialdesign.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
