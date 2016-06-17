package edu.fcu.pojeck.petlog_android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class PictureChoose extends AppCompatActivity {//从相机中加入图片的
    GridView mainView;
    Button sure;

    public static final String key="pictureIndex";
    public static final int fine=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_choose);
        final ArrayList bitmaparray=PictureBase.getallpictureinSD();
        final ArrayList chooseint=new ArrayList<Integer>();

        mainView =(GridView)findViewById(R.id.picturegird);
        ArrayList newList=new ArrayList<BitmapInt>();
        for(int i=0;i<bitmaparray.size();i++){
            newList.add(new BitmapInt((Bitmap)bitmaparray.get(i),false));
        }
        final ChooseAdapter adapter=new ChooseAdapter(this , newList);
        mainView.setAdapter(adapter);
        AdapterView.OnItemClickListener onItemClickListener=new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PictureChoose.this,"postion:"+position,Toast.LENGTH_SHORT).show();
                adapter.changecolor(position);
                chooseint.add(new Integer(position));
            }
        };
        mainView.setOnItemClickListener(onItemClickListener);
        sure =(Button)findViewById(R.id.picturesure);


        View.OnClickListener sureback=new  View.OnClickListener(){

            @Override
            public void onClick(View v) {

                /*choose=new Bitmap[chooseint.size()];//用使用者选择的图片的引数(postion)来创建bitmaparray
                for (int i=0; i<chooseint.size(); i++){
                    choose[i]=(Bitmap)bitmaparray.get(i);
                }*/
                Intent back=new Intent();
                back.putExtra(key, chooseint);
                setResult(fine,back);
                finish();
            }
        };
        sure.setOnClickListener(sureback);

    }

}
