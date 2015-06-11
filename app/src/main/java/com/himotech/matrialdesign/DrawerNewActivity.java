package com.himotech.matrialdesign;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.himotech.fragments.SiugnupFragment;

public class DrawerNewActivity extends AppCompatActivity implements SiugnupFragment.OnFragmentInteractionListener {


    private DrawerLayout mDrawerLayout;

    //This is from V7 previously we are using from v4
    private ActionBarDrawerToggle mActionBarDrawerToggle;


    private Toolbar mToolbar;


    private NavigationView mNavigationView;


    private FragmentManager mFrgFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_new);

        initView();
    }


    private void initView(){

        mNavigationView=(NavigationView)findViewById(R.id.navigation_view);

        mToolbar=(Toolbar)findViewById(R.id.toolbar_drawer_new);

        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);

        mFrgFragmentManager=getSupportFragmentManager();



        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked()) {
                    menuItem.setChecked(false);
                }
                else {
                    menuItem.setChecked(true);
                }

                //Closing drawer on item click
                mDrawerLayout.closeDrawers();

                switch(menuItem.getItemId()){


                }

                return false;
            }
        });

        mActionBarDrawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }


            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };


        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);


        initFragment();

    }


    private void initFragment(){

        SiugnupFragment mSiugnupFragment=new SiugnupFragment();

        mFrgFragmentManager.beginTransaction().replace(R.id.id_fragment_holder,mSiugnupFragment,"SignupFragment").commit();



    }


    public void onClickSignup(View mView){

        Intent mImIntent=new Intent(this,AdsListActivity.class);
        startActivity(mImIntent);

    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        //calling sync state is necessay or else your hamburger icon wont show up
        mActionBarDrawerToggle.syncState();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id ==) {
            return true;
        }*/

        switch (item.getItemId()) {

            case  R.id.action_settings:

                return true;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
