package edu.fcu.pojeck.petlog_android;

import java.io.File;

/**
 * Created by fomsing on 2016/5/14.
 */
public class Picturedata {
    private File[] icon;
    private String word;
    private int ownerid;
    private int id;//the id of itself
    private int likeid;//match the like  this  atricle gets in like database
    private int messageid[];//match the leavemessage in leavemessage database
    private String date;

    public int getLikeid() {
        return likeid;
    }

    public File[] getIcon() {
        return icon;
    }

    public int getId() {
        return id;
    }

    public int[] getMessageid() {
        return messageid;
    }

    public String getDate() {
        return date;
    }

    public int getid(){
        return id;

    }
    Picturedata(File[] icon, String word, int ownerid, String date,PictureBase PB,messageBase MB,likeBase LB){
        this.icon=icon;
        this.word=word;
        this.ownerid=ownerid;
        this.date=date;
        PB.newapicture();
        this.likeid=LB.newalike(this.id);

    }

    public String getWord() {
        return word;
    }

    public int getOwnerid() {
        return ownerid;
    }
}
