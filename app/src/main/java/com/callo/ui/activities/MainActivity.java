package com.callo.ui.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;

import com.callo.R;
import com.callo.ui.fragments.ContactsListFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by abhishesh.s on 5/6/16.
 */
public class MainActivity extends AppCompatActivity {

    private static final int DEFAULT_NUM_PAGES = 3;

    /**
     * Index of the contact list tab
     */
    public static final int INDEX_CONTACTS_LIST_FRAGMENT = 0;

    /**
     * Index of the group tab
     */
    public static final int INDEX_GROUP_LIST_FRAGMENT = 1;

    /**
     * Index of the conversation tab
     */
    public static final int INDEX_CONVERSATION_LIST_FRAGMENT = 2;

    /**
     * ViewPager which manages the different tabs
     */
    @Bind(R.id.pager)
    ViewPager mViewPager;
    @Bind(R.id.fab_create_account)
    FloatingActionButton mFloatingActionButton;
    @Bind(R.id.coordinatorLayout)
    CoordinatorLayout mCoordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.title_contact));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.title_group));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.title_conversation));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        PagerAdapter mPagerAdapter = new AccountViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * Adapter which provides pages(fragments)to the viewpager
     */
    private class AccountViewPagerAdapter extends FragmentStatePagerAdapter {

        public AccountViewPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int tabPosition) {
            Fragment fragment = new ContactsListFragment();
            return fragment;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case INDEX_CONTACTS_LIST_FRAGMENT:
                    return getString(R.string.title_contact);

                case INDEX_GROUP_LIST_FRAGMENT:
                    return getString(R.string.title_group);

                case INDEX_CONVERSATION_LIST_FRAGMENT:
                default:
                    return getString(R.string.title_conversation);
            }
        }

        @Override
        public int getCount() {
            return DEFAULT_NUM_PAGES;
        }
    }
}
