package com.himotech.matrialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class HomeActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;

    private HomeListAdapter mHomeListAdapter;

    private TabLayout mTabLayout;

    private Toolbar mToolBarHome;

    private FloatingActionButton mFloatingAb;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.himotech.matrialdesign.R.layout.activity_home);

        initView();
    }



    private void initView(){


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
