package edu.fcu.pojeck.petlog_android;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by kiam on 18/06/2016.
 */
public class gridViewAdapter1 extends BaseAdapter {
    LayoutInflater layoutInflater;
    ArrayList<Integer> list;
    int count=0;

    public gridViewAdapter1(Context context,ArrayList<Integer> list){
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;  //可能要修改，因為圖片參數要放其他的東西
        Log.d("kaim", "con ");
    }

    private class View_TalkLayout{
        ImageView image;
    }

    /*public void addItem(){

        count++;
    }*/

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View_TalkLayout view_talkLayout = null;
        Log.d("kaim", "getView ");
        if (convertView == null) {
            convertView = (LinearLayout) layoutInflater.inflate(R.layout.gripview1, null);
            view_talkLayout = new View_TalkLayout();
            view_talkLayout.image=(ImageView)convertView.findViewById(R.id.singlepicture);
            convertView.setTag(view_talkLayout);
        } else {
            view_talkLayout = (View_TalkLayout)convertView.getTag();
        }

        ArrayList picturearray = PictureBase.getallpictureinSD();
        view_talkLayout.image.setImageBitmap((Bitmap)picturearray.get(((Integer)list.get(position)).intValue()));
        Log.d("kaim", "getView "+(Integer)list.get(position));
        return convertView;
    }
}
