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

public class CollapseToolBarActivity extends AppCompatActivity {



    private CollapsingToolbarLayout mCollapsTbar;

    private AppBarLayout mAppBarLayout;

    private RecyclerView mRecycleList;

    private Toolbar mToolBarHome;

    private HomeListAdapter mHomeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.himotech.matrialdesign.R.layout.activity_collapse_tool_bar);

        initView();
    }



    private void  initView(){

        mRecycleList=(RecyclerView)findViewById(com.himotech.matrialdesign.R.id.list_recycle_collapse);

        mRecycleList.setLayoutManager(new LinearLayoutManager(this));

        mCollapsTbar=(CollapsingToolbarLayout)findViewById(com.himotech.matrialdesign.R.id.collpse_toolbar_layout);

        mToolBarHome=(Toolbar)findViewById(com.himotech.matrialdesign.R.id.toolbar_collapse);


        mCollapsTbar.setTitle("Collapse Toolbar");

        mHomeListAdapter=new HomeListAdapter();

        setSupportActionBar(mToolBarHome);


        mRecycleList.setAdapter(mHomeListAdapter);
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
