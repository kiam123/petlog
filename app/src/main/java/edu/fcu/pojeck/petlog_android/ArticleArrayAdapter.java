package edu.fcu.pojeck.petlog_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by winky_swl on 19/6/2016.
 */
public class ArticleArrayAdapter extends ArrayAdapter<ArticleItem> {//

    Context context;

    public ArticleArrayAdapter(Context context, ArrayList<ArticleItem> items) {
        super(context, 0, items);
        this.context = context;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        LinearLayout itemlayout = null;
        if (convertView == null) {
            itemlayout = (LinearLayout) inflater.inflate(R.layout.lay3listview, null);
        } else {
            itemlayout = (LinearLayout) convertView;
        }

        ArticleItem item = (ArticleItem) getItem(position);

        ImageView userPic = (ImageView) itemlayout.findViewById(R.id.Article_userP);
        userPic.setImageResource(item.userPic);

        TextView title = (TextView) itemlayout.findViewById(R.id.title);
        title.setText(item.title);

        TextView username = (TextView) itemlayout.findViewById(R.id.A_username);
        username.setText(item.userName);

        TextView comment = (TextView) itemlayout.findViewById(R.id.commrnt_num);
        comment.setText(item.comment);

        return itemlayout;
    }
}

class ArticleItem{
    int userPic;//
    String title;
    String userName;
    String comment;

    public ArticleItem(int userPic, String title, String userName, String comment){
        this.userPic=userPic;
        this.title=title;
        this.userName=userName;
        this.comment=comment;
    }

}

