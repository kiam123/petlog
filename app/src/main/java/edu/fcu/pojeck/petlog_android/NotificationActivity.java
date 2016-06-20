package edu.fcu.pojeck.petlog_android;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.readystatesoftware.viewbadger.BadgeView;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        /*listView = (ListView)findViewById(R.id.listView);
        item = new MyBaseAdapter(this);
        listView.setAdapter(item);

        item.addItem(new NotificationItem(R.drawable.settings, "winky_swl like your photo", R.drawable.home));*/
        ArrayList<NotificationItem> item = new ArrayList<NotificationItem>();

        item.add(new NotificationItem(R.drawable.u1, "alanwong like your photo", "1 day ago.", R.drawable.p2));
        item.add(new NotificationItem(R.drawable.u2, "samleung like your photo", "2 day ago.", R.drawable.p1));
        item.add(new NotificationItem(R.drawable.u3, "maychan like your photo", "2 day ago.", R.drawable.p1));
        item.add(new NotificationItem(R.drawable.u2, "mike7263 like your photo", "4 day ago.", R.drawable.p1));


        NotificationArrayAdapter adapter = new NotificationArrayAdapter(this, item);

        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    class NotificationArrayAdapter extends ArrayAdapter<NotificationItem> {

        Context context;

        public NotificationArrayAdapter(Context context, ArrayList<NotificationItem> items) {
            super(context, 0, items);
            this.context = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(context);

            LinearLayout itemlayout = null;
            if (convertView == null) {
                itemlayout = (LinearLayout) inflater.inflate(R.layout.notification_listview, null);
            } else {
                itemlayout = (LinearLayout) convertView;
            }



            NotificationItem item = (NotificationItem) getItem(position);

            TextView textView = (TextView)itemlayout.findViewById(R.id.state);
            textView.setText(item.textView);

            TextView time = (TextView)itemlayout.findViewById(R.id.time);
            time.setText(item.time);

            ImageView user = (ImageView)itemlayout.findViewById(R.id.userPic);
            user.setImageResource(item.userP);

            ImageView up = (ImageView)itemlayout.findViewById(R.id.uploadPic);
            up.setImageResource(item.uploadP);

            return itemlayout;
        }
    }

}
