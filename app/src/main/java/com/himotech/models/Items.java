package com.himotech.models;

/**
 * Created by ubbvand2 on 5/6/15.
 */
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
