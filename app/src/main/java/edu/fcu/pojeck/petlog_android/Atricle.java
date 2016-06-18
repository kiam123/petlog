package edu.fcu.pojeck.petlog_android;

import android.graphics.Bitmap;

import java.io.File;


public class Atricle {//the data struct of article
    private Bitmap[] icon;
    private String word;
    private int ownerid;
    private int id;//the id of itself
    private int likeid;//match the like  this  atricle gets in like database
    private int messageid[];//match the leavemessage in leavemessage database
    private int messagenum;//配合messageid使用,記錄當前有幾個messageid
    private String date;
    public final static int MAXMESSAGE=100;//how much message it can contain

    Atricle(Bitmap[] icon, String word, int ownerid, String date,messageBase MB,likeBase LB,int newid){
        this.icon=icon;
        this.word=word;
        this.ownerid=ownerid;
        this.date=date;
        this.id=newid;
        this.likeid=LB.newalike(this.id);
        this.messageid=new int[MAXMESSAGE];//message設計為單個儲存與messagebase裏,picture或atritcle生成留言時,用此陣列保存其id,然後將物件存入留言資料庫
        this.messagenum=0;
    }

    public int getLikeid() {
        return likeid;
    }

    public Bitmap[] getIcon() {
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

    public String getWord() {
        return word;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setId(int id){this.id=id;}

    public void leavemessage(messageBase MB,String text,int leaver_id){
        int newmesgid=MB.newamessage(text,this.id,leaver_id);
        messageid[messagenum ++]=newmesgid;
    }

    public void clicklike(likeBase LB,int user_id){
        like likeobject=LB.getlike(this.likeid);
        likeobject.add(user_id);
    }
    public message getmessage(messageBase MB,int index){//when you want to read no.index message,call this function
        return MB.getmessage(messageid[index]);
    }
    public like getlike(likeBase LB){
        return LB.getlike(this.likeid);
    }
}
