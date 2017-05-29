package com.move2soft.android.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.move2soft.android.Fragmnet.Books;
import com.move2soft.android.Fragmnet.Note;
import com.move2soft.android.Fragmnet.Syllabus;
import com.move2soft.android.R;
import com.move2soft.android.utils.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class BranchTab extends BaseActivity {

    ViewPager viewPagertab;
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_tab);
        ButterKnife.bind(this);
        bindToolbar();
        setTitle("Mathematics");
        showEmptyOnly();
        showBack();

        viewPagertab= (ViewPager) findViewById(R.id.viewPagertab);
        tab= (TabLayout) findViewById(R.id.tabs);

        setupViewPager(viewPagertab);
        tab.setupWithViewPager(viewPagertab);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Syllabus(),"SYLLABUS");
        adapter.addFragment(new Books(),"BOOKS");
        adapter.addFragment(new Note(),"NOTES");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);

        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
