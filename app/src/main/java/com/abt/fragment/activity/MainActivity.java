package com.abt.fragment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.abt.fragment.pager.ChatFragment;
import com.abt.fragment.pager.FindFragment;
import com.abt.fragment.pager.FriendFragment;
import com.abt.fragment.R;
import com.abt.fragment.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private static final String TAG = "MainActivity";
    private TextView titleTextView;
    private LinearLayout firstLinearLayout;
    private LinearLayout secondLinearLayout;
    private LinearLayout threeLinearLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerFragmentAdapter;
    private FragmentManager mFragmentManager;

    private String[] titleName = new String[] { "微信", "朋友", "发现" };
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragmentList();
        initView();
        initViewPager();
        mFragmentManager = getSupportFragmentManager();
        mViewPagerFragmentAdapter = new ViewPagerAdapter(mFragmentManager, mFragmentList);
    }

    public void initViewPager() {
        mViewPager.addOnPageChangeListener(this);
        mViewPager.setAdapter(mViewPagerFragmentAdapter);
        mViewPager.setCurrentItem(0);
        titleTextView.setText(titleName[0]);
        updateBottomLinearLayoutSelect(true, false, false);
    }

    public void initFragmentList() {
        Fragment chat = new ChatFragment();
        Fragment friend = new FriendFragment();
        Fragment find = new FindFragment();
        mFragmentList.add(chat);
        mFragmentList.add(friend);
        mFragmentList.add(find);
    }

    public void initView() {
        titleTextView = (TextView) findViewById(R.id.ViewTitle);
        mViewPager = (ViewPager) findViewById(R.id.ViewPagerLayout);
        firstLinearLayout = (LinearLayout) findViewById(R.id.firstLinearLayout);
        firstLinearLayout.setOnClickListener(this);
        secondLinearLayout = (LinearLayout) findViewById(R.id.secondLinearLayout);
        secondLinearLayout.setOnClickListener(this);
        threeLinearLayout = (LinearLayout) findViewById(R.id.threeLinearLayout);
        threeLinearLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.firstLinearLayout:
                mViewPager.setCurrentItem(0);
                updateBottomLinearLayoutSelect(true, false, false);
                break;
            case R.id.secondLinearLayout:
                mViewPager.setCurrentItem(1);
                updateBottomLinearLayoutSelect(false, true, false);
                break;
            case R.id.threeLinearLayout:
                mViewPager.setCurrentItem(2);
                updateBottomLinearLayoutSelect(false, false, true);
                break;
            default:
                break;
        }
    }

    private void updateBottomLinearLayoutSelect(boolean f, boolean s, boolean t) {
        firstLinearLayout.setSelected(f);
        secondLinearLayout.setSelected(s);
        threeLinearLayout.setSelected(t);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        boolean[] state = new boolean[titleName.length];
        state[position] = true;
        titleTextView.setText(titleName[position]);
        updateBottomLinearLayoutSelect(state[0], state[1], state[2]);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.d(TAG, "onPageScrollStateChanged");
    }
}
