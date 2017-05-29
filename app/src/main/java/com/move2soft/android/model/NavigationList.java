package com.move2soft.android.model;


import com.move2soft.android.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by UV on 29-Nov-16.
 */
public class NavigationList {
    public static NavigationList _naviNavigationList;
    public static List<Integer> imageList;
    public static List<String> titleList;
    public static String location = "Surat,Magob";
    public static String cartCount;

    public static NavigationList getInstance() {
        if (_naviNavigationList == null) {
            _naviNavigationList = new NavigationList();
        }
        imageList = Arrays.asList(R.drawable.ic_back_navi, R.drawable.ic_back_navi
                , R.drawable.ic_back_navi, R.drawable.ic_back_navi, R.drawable.ic_back_navi,
                R.drawable.ic_share, R.drawable.ic_rate, R.drawable.ic_about_us);
        titleList = Arrays.asList("Branch", "Executive Wing", "Wardens", "Student Chapters", "Online Bech","Share Us", "Rate Us", "About Us");
        return _naviNavigationList;
    }

    public static List<Integer> getImageList() {
        return imageList;
    }

    public static List<String> getTitleList() {
        return titleList;
    }

    public static void changeLocation(String mylocation) {
        location = mylocation;
        titleList.set(0, mylocation);
    }
}
