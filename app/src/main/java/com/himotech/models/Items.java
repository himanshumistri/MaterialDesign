package com.himotech.models;

/**
 * Created by ubbvand2 on 5/6/15.
 */
public class Items {


    public static final int ITEM_ROW=0;

    public static final int ITEM_SECTION=1;

    public int mItemType;

    private String mSectionTitle;

    private String mDirectoryName;

    private String mDate;

    private int mImgeColor;

    public int getImgeColor() {
        return mImgeColor;
    }

    public void setImgeColor(int mImgeColor) {
        this.mImgeColor = mImgeColor;
    }

    public String getmSectionTitle() {
        return mSectionTitle;
    }

    public void setmSectionTitle(String mSectionTitle) {
        this.mSectionTitle = mSectionTitle;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmDirectoryName() {
        return mDirectoryName;
    }

    public void setmDirectoryName(String mDirectoryName) {
        this.mDirectoryName = mDirectoryName;
    }

    public int getItemType() {
        return mItemType;
    }

    public void setItemType(int mItemType) {
        this.mItemType = mItemType;
    }
}
