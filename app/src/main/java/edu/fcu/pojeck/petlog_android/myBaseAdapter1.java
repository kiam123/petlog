package edu.fcu.pojeck.petlog_android;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by kiam on 21/05/2016.
 */
public class myBaseAdapter1 extends BaseAdapter {
    LayoutInflater layoutInflater;
    private Context mContext;
    int count=0;
    private ArrayList<comment_data1> commentData1 = new ArrayList<comment_data1>();
    ArrayList<Map<String, Object>> mDatas;//可能要修改，因為圖片參數要放其他的東西

    private class View_TalkLayout{
        ImageView humanhead;
        TextView comment,name,time;
        GridView gridView;
    }

    public myBaseAdapter1(Context context){//要加多一個ArrayList，因為要加圖片
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContext = context;
    }

    public void addItem(comment_data1 Item,ArrayList<Map<String, Object>> data){
        commentData1.add(Item);
        mDatas = data;
        count++;
        this.notifyDataSetChanged();
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
            view_talkLayout.humanhead = (ImageView)convertView.findViewById(R.id.humanhead);
            view_talkLayout.name = (TextView)convertView.findViewById(R.id.name);
            view_talkLayout.time = (TextView)convertView.findViewById(R.id.time);
            view_talkLayout.comment = (TextView)convertView.findViewById(R.id.commed);
            view_talkLayout.gridView = (GridView)convertView.findViewById(R.id.gridView);
            convertView.setTag(view_talkLayout);
        }
        else{
            view_talkLayout = (View_TalkLayout)convertView.getTag();
        }

        view_talkLayout.humanhead.setImageBitmap(PictureBase.getfirstbitmapfromSD());
        view_talkLayout.name.setText(commentData1.get(position).getName());
        view_talkLayout.time.setText(commentData1.get(position).getTime());
        view_talkLayout.comment.setText(commentData1.get(position).getComment());
        Log.v("kk",""+commentData1.get(position).getComment());
        ArrayList<Integer> list;

        list = (ArrayList<Integer>) mDatas.get(position).get("urls");
        Log.v("list", "" + list.size());
        if (list.size() == 0) {
            view_talkLayout.gridView.setVisibility(convertView.GONE);
        } else {
            Log.d("PromotionalMaterialActi", "" + list.size());
            view_talkLayout.gridView.setVisibility(convertView.VISIBLE);
            view_talkLayout.gridView.setAdapter(new gridViewAdapter1(mContext, list));
        }

        return convertView;
    }
}
