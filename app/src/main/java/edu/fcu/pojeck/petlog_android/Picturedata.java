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
    public final static int MAXMESSAGE=100;//how much message it can contain

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
    public void setId(int id){
        this.id=id;
    }

    Picturedata(File[] icon, String word, int ownerid, String date,messageBase MB,likeBase LB,int newid){
        this.icon=icon;
        this.word=word;
        this.ownerid=ownerid;
        this.date=date;
        this.id=newid;
        this.likeid=LB.newalike(this.id);
        this.messageid=new int[MAXMESSAGE];
    }

    public String getWord() {
        return word;
    }

    public int getOwnerid() {
        return ownerid;
    }
}
