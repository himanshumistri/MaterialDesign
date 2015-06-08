package com.himotech.matrialdesign;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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
public class HomeActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;

    private HomeListAdapter mHomeListAdapter;

    private TabLayout mTabLayout;

    private Toolbar mToolBarHome;

    private FloatingActionButton mFloatingAb;

private AppCompatButton mAppCampatBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.himotech.matrialdesign.R.layout.activity_home);

        initView();
    }



    private void initView(){

        int[][] states = new int[][] {
                new int[] { android.R.attr.state_enabled}, // enabled
                new int[] {-android.R.attr.state_enabled}, // disabled
                new int[] {-android.R.attr.state_checked}, // unchecked
                new int[] { android.R.attr.state_pressed}  // pressed
        };

        int[] colors = new int[] {
               getResources().getColor(R.color.tab_bg),
                getResources().getColor(R.color.tab_bg),
                Color.GREEN,
                Color.BLUE
        };

        ColorStateList myList = new ColorStateList(states, colors);

        mAppCampatBtn=(AppCompatButton)findViewById(R.id.btn_next_screen);

        mToolBarHome=(Toolbar)findViewById(com.himotech.matrialdesign.R.id.toolbar_home);


        mToolBarHome.setTitle(com.himotech.matrialdesign.R.string.app_name);

        mRecyclerView=(RecyclerView)findViewById(com.himotech.matrialdesign.R.id.list_recycle);

        mFloatingAb=(FloatingActionButton)findViewById(com.himotech.matrialdesign.R.id.floatin_ab_home);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        mTabLayout=(TabLayout)findViewById(com.himotech.matrialdesign.R.id.tab_layout);



        mTabLayout.addTab(mTabLayout.newTab().setText("Tab One"));

        mTabLayout.addTab(mTabLayout.newTab().setText("Tab Two"));

        mTabLayout.addTab(mTabLayout.newTab().setText("Tab Three"));



        mHomeListAdapter=new HomeListAdapter();


        mRecyclerView.setAdapter(mHomeListAdapter);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            mAppCampatBtn.setSupportBackgroundTintList(myList);
        }else{
            mAppCampatBtn.setSupportBackgroundTintList(myList);
            ViewCompat.setBackgroundTintList(mAppCampatBtn,myList);
        }






    }




    public void startNextScreen(View mView){


        Intent mStartNext=new Intent(this,CollapseToolBarActivity.class);

        startActivity(mStartNext);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.himotech.matrialdesign.R.menu.menu_home, menu);
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
