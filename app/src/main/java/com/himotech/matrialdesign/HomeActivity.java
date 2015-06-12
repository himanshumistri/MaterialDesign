package com.himotech.matrialdesign;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.himotech.fragments.RecycleListFragment;
import com.himotech.fragments.SiugnupFragment;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;

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
public class HomeActivity extends AppCompatActivity implements SiugnupFragment.OnFragmentInteractionListener {


    private RecyclerView mRecyclerView;

    private HomeListAdapter mHomeListAdapter;

    private TabLayout mTabLayout;

    private Toolbar mToolBarHome;

    private FloatingActionButton mFloatingAb;

    private MoPubView mMopubView;

    private AppCompatButton mAppCampatBtn;

    private ViewPager mViewPager;

    private PagerAdapter mPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.himotech.matrialdesign.R.layout.activity_home);

        initView();
    }



    private void initView(){

        mMopubView=(MoPubView)findViewById(R.id.adview);

        mMopubView.setAdUnitId("a24d46a1b7434c6bba803e6b53ce55a0");

        mMopubView.setAutorefreshEnabled(true);


        mPagerAdapter=new PagerAdapter(getSupportFragmentManager(),this);

        mViewPager=(ViewPager)findViewById(R.id.viewpager);

        mViewPager.setAdapter(mPagerAdapter);

        mMopubView.setBannerAdListener(new MoPubView.BannerAdListener() {
            @Override
            public void onBannerLoaded(MoPubView banner) {

                Toast.makeText(getApplicationContext(),
                        "Banner successfully loaded.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBannerFailed(MoPubView banner, MoPubErrorCode errorCode) {

            }

            @Override
            public void onBannerClicked(MoPubView banner) {

            }

            @Override
            public void onBannerExpanded(MoPubView banner) {

            }

            @Override
            public void onBannerCollapsed(MoPubView banner) {

            }
        });



        mMopubView.loadAd();

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

        //mRecyclerView=(RecyclerView)findViewById(com.himotech.matrialdesign.R.id.list_recycle);

        mFloatingAb=(FloatingActionButton)findViewById(com.himotech.matrialdesign.R.id.floatin_ab_home);


        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        mTabLayout=(TabLayout)findViewById(com.himotech.matrialdesign.R.id.tab_layout);



        /*mTabLayout.addTab(mTabLayout.newTab().setCustomView(R.layout.custom_tab_layout));

        mTabLayout.addTab(mTabLayout.newTab().setCustomView(R.layout.custom_tab_layout));

        mTabLayout.addTab(mTabLayout.newTab().setCustomView(R.layout.custom_tab_layout));*/

        mTabLayout.addTab(mTabLayout.newTab().setText("Tab One"));

        mTabLayout.addTab(mTabLayout.newTab().setText("Tab Two"));

        mTabLayout.addTab(mTabLayout.newTab().setText("Tab Third"));



       // mTabLayout.setTabsFromPagerAdapter(mPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);

        mHomeListAdapter=new HomeListAdapter();


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //mTabLayout.setScrollPosition(position,positionOffset,true);
            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //mRecyclerView.setAdapter(mHomeListAdapter);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            mAppCampatBtn.setSupportBackgroundTintList(myList);
        }else{
            mAppCampatBtn.setSupportBackgroundTintList(myList);
            ViewCompat.setBackgroundTintList(mAppCampatBtn,myList);
        }






    }


    public void onClickSignup(View mView){

        Intent mImIntent=new Intent(this,AdsListActivity.class);
        startActivity(mImIntent);

    }


    public void startNextScreen(View mView){


        Intent mStartNext=new Intent(this,CollapseToolBarActivity.class);

        startActivity(mStartNext);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public static class PagerAdapter extends FragmentPagerAdapter{

        private String tabTitles[] = new String[] { "Tab One", "Tab Two", "Tab Three" };

        private HomeActivity mHomeActivity;

        public PagerAdapter(FragmentManager fm,HomeActivity mHomeActivity) {
            super(fm);
            this.mHomeActivity=mHomeActivity;
        }

        @Override
        public Fragment getItem(int position) {

            switch(position){
                case 0:
                    return new RecycleListFragment();
                case 1:
                    return new SiugnupFragment();
                case 2:
                    return new SiugnupFragment();
            }

            return new SiugnupFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }
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



    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMopubView.destroy();
    }
}
