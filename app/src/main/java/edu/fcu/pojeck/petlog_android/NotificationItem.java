package edu.fcu.pojeck.petlog_android;

import android.graphics.drawable.Drawable;

/**
 * Created by winky_swl on 24/5/2016.
 */
public class NotificationItem {

    public int userP;
    public String textView;
    public int uploadP;
    public String time;

    public NotificationItem(int userP, String textView, String time, int uploadP){
        this.userP=userP;
        this.textView=textView;
        this.time=time;
        this.uploadP=uploadP;
    }

}
