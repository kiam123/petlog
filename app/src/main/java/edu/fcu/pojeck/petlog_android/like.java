package edu.fcu.pojeck.petlog_android;

import java.util.LinkedList;

/**
 * Created by fomsing on 2016/5/14.
 */
public class like {
    int id;
    int host_atricleId;//the id of which atricle own this like
    LinkedList liker;
    like(int articleId,int id){
        liker=new LinkedList();
        host_atricleId=articleId;
        this.id=id;
    }
    public void add(int liker_Id){
        liker.add(liker_Id);
    } //like_Id is rhe id of who click it
    public int getnum(){
        return liker.size();
    }
    public int getid(){
        return id;
    }

}
