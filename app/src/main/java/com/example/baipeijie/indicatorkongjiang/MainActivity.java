package com.example.baipeijie.indicatorkongjiang;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<View> mViews = new ArrayList<>();//容器
    private Indicator mIndicator;
    //Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

       ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPagerAdapter());
        viewPager.setOnPageChangeListener(new MyPagerListner());
        mIndicator = (Indicator) findViewById(R.id.indicator);

//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        },3000);

    }

    private  void initData(){
        for (int i=0;i<4;i++){
            View inflate = getLayoutInflater().inflate(R.layout.pager_item,null);//
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv);
            imageView.setImageResource(R.mipmap.ic_launcher);
            mViews.add(inflate);
        }



    }

    class MyPagerListner implements  ViewPager.OnPageChangeListener{
        @Override
        //ViewPager的滚动的方法
        /**position//
         * positionOffset//偏移百分比
         *positionOffsetPixels//偏移量
         * */
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            mIndicator.setOffset(position,positionOffset);

        }

        @Override
        //ViewPager选中
        public void onPageSelected(int position) {

        }

        @Override
        //ViewPager滑动状态的改变
        public void onPageScrollStateChanged(int state) {

        }
    }

    class MyPagerAdapter extends PagerAdapter{

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
         //   super.destroyItem(container, position, object);
            position %=4;//要%上viewpage的数量不然viePage数组越界
            container.removeView(mViews.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            position %=4;//要%上viewpage的数量不然viePage数组越界
            View view = mViews.get(position);//
            container.addView(view);
           return view;
        }
        @Override
        public int getCount() {
              return Integer.MAX_VALUE;//要到Indicator那里控制值
            //  return mViews.size();

        }
        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view==object;
        }


    }
}
