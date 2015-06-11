package com.himotech.matrialdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.himotech.models.Items;
import com.mopub.nativeads.MoPubAdAdapter;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.mopub.nativeads.MoPubNativeAdRenderer;
import com.mopub.nativeads.RequestParameters;
import com.mopub.nativeads.ViewBinder;

import java.util.ArrayList;

public class AdsListActivity extends AppCompatActivity {


    private ListView mListView;


    private ItemListAdapter mItemListAdapter;

    private ArrayList<Items> mArrayList;


    private MoPubAdAdapter mMoPubAdpter;

    private RequestParameters mRequestParameters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads_list);
        initView();
    }




    private void initView(){

        mArrayList=new ArrayList<>();

        mListView=(ListView)findViewById(R.id.list_ads);


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


        Items mItems9=new Items();

        mItems9.setItemType(Items.ITEM_ROW);

        mItems9.setmDirectoryName("Project Schedule");

        mItems9.setmDate("15 Jan,2014");
        mItems9.setImgeColor(R.drawable.green_round);

        mArrayList.add(mItems9);


        mItemListAdapter=new ItemListAdapter(this,R.layout.custom_list_homesection_row,mArrayList);



        mMoPubAdpter=new MoPubAdAdapter(this,mItemListAdapter);


        // Set up an renderer that knows how to put ad data in an ad view.
        final MoPubNativeAdRenderer adRenderer = new MoPubNativeAdRenderer(
                new ViewBinder.Builder(R.layout.native_ad_list_item)
                        .titleId(R.id.native_title)
                        .textId(R.id.native_text)
                        .mainImageId(R.id.native_main_image)
                        .iconImageId(R.id.native_icon_image)
                        .callToActionId(R.id.native_cta)
                        .build());


        mRequestParameters=new RequestParameters.Builder().build();

        MoPubNativeAdPositioning.MoPubServerPositioning adPositioning =
                MoPubNativeAdPositioning.serverPositioning();

        mMoPubAdpter.registerAdRenderer(adRenderer);


        mListView.setAdapter(mMoPubAdpter);

    }


    @Override
    public void onResume() {

//Example Ads loader
        // Request ads when the user returns to this activity.
        mMoPubAdpter.loadAds("c3d6fa7431fe4a03bdd79715aa869076", mRequestParameters);

        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ads_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
