package edu.fcu.pojeck.petlog_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by kiam on 21/05/2016.
 */
public class myBaseAdapter1 extends BaseAdapter {
    LayoutInflater layoutInflater;
    int count=0;

    private class View_TalkLayout{
        ImageView humanhead;

    }

    public myBaseAdapter1(Context context){
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addItem(){  //還沒完成

    }

    @Override
    public int getCount() {
        return count;
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
        View_TalkLayout view_talkLayout;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.lay1listview,null);
            view_talkLayout = new View_TalkLayout();

            convertView.setTag(view_talkLayout);
        }
        else{
            view_talkLayout = (View_TalkLayout)convertView.getTag();
        }
        return convertView;
    }
}
