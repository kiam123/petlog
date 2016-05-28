package edu.fcu.pojeck.petlog_android;


import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PetlogActivity extends Activity {

    private ViewPager viewPager;//頁面內容
    private ImageView imageView;// 動畫圖片
    private TextView textView1,textView2,textView3;
    private ArrayList<View> views;// Tab頁面列表
    private int offset = 0;// 動畫圖片偏移量
    private int currIndex = 0;// 當前頁卡編號
    private int bmpW;// 動畫圖片寬度
    private View view1,view2,view3;//各個頁卡
    private LinearLayout speaker,home,settings;
    private ArrayList PicturePath;//用来存放sd卡内的所有图片路径,在onCreate内使用
    private likeBase likeBase;
    private PictureBase pictureBase;
    private messageBase messageBase;
    private UserBase userBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//關閉狀態列
        setContentView(R.layout.petlogactivity);
        InitImageView();
        InitTextView();
        InitViewPager();
        InitLinearLayout();
        PicturePath=PictureBase.getImagesFromSD();//现在Picture内存放着你放在SD卡目录内的所有图片路径(SD卡内文件夹内的不算)
        likeBase=new likeBase();
        pictureBase=new PictureBase();
        messageBase=new messageBase();
        userBase=new UserBase();
       /* File[] taskfile=new File[1];
       taskfile[0]=new File((String)PicturePath.get(0));
        pictureBase.newapicture(taskfile,"this is my first task",0,"2016.5.28", messageBase,likeBase);*/
    }

    private void InitViewPager() {
        viewPager=(ViewPager) findViewById(R.id.vPager);
        views=new ArrayList<View>();
        LayoutInflater inflater=getLayoutInflater();
        view1=inflater.inflate(R.layout.lay1, null);
        view2=inflater.inflate(R.layout.lay2, null);
        view3=inflater.inflate(R.layout.lay3, null);

        views.add(view1);
        views.add(view2);
        views.add(view3);
        viewPager.setAdapter(new MyViewPagerAdapter(views));
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }
    /**
     *  初始化头标
     */

    private void InitTextView() {
        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        textView3 = (TextView) findViewById(R.id.text3);

        textView1.setOnClickListener(new MyOnClickListener(0));
        textView2.setOnClickListener(new MyOnClickListener(1));
        textView3.setOnClickListener(new MyOnClickListener(2));
    }

    private void InitLinearLayout(){
        speaker = (LinearLayout)findViewById(R.id.speaker);
        home = (LinearLayout)findViewById(R.id.home);
        settings = (LinearLayout)findViewById(R.id.settings);

        speaker.setOnClickListener(MySpeakerListener);
        home.setOnClickListener(MyHomeListener);
        settings.setOnClickListener(MySettingListener);
    }
    /**
     2      * 初始化动画
     3 */

    private void InitImageView() {
        imageView= (ImageView) findViewById(R.id.cursor);
        bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.a).getWidth();// 獲取圖片寬度
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;// 獲取分辨率寬度
        offset = (screenW / 3 - bmpW) / 2;// 計算偏移量
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        imageView.setImageMatrix(matrix);// 設置動畫初始位置
    }

    /**
     *
     * 头标点击监听 3 */
    private class MyOnClickListener implements View.OnClickListener {
        private int index=0;
        public MyOnClickListener(int i){
            index=i;
        }
        public void onClick(View v) {
            viewPager.setCurrentItem(index);
        }

    }

    private View.OnClickListener MyHomeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(PetlogActivity.this,HomeActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener MySettingListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(PetlogActivity.this,SettingActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener MySpeakerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(PetlogActivity.this,NotificationActivity.class);
            startActivity(intent);
        }
    };

    public class MyViewPagerAdapter extends PagerAdapter {
        private List<View> mListViews;

        public MyViewPagerAdapter(List<View> mListViews) {
            this.mListViews = mListViews;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) 	{
            container.removeView(mListViews.get(position));
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {  //設計viewpager的地方
            container.addView(mListViews.get(position), 0);


            switch(position){
                case 0:
//
                    break;
                case 1:

                    break;
                case 2:

                    break;
            }

            return mListViews.get(position);
        }

        @Override
        public int getCount() {
            return  mListViews.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;
        }
    }

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        int one = offset * 2 + bmpW;// 頁卡1 -> 頁卡2 偏移量
        int two = one * 2;// 頁卡1 -> 頁卡3 偏移量
        public void onPageScrollStateChanged(int arg0) {

        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        public void onPageSelected(int arg0) {
            Animation animation = new TranslateAnimation(one*currIndex, one*arg0, 0, 0);
            currIndex = arg0;
            animation.setFillAfter(true);// True:圖片停在動畫結束位置
            animation.setDuration(300);
            imageView.startAnimation(animation);
        }

    }
}
