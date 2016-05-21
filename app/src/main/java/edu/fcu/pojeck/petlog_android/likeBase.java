package edu.fcu.pojeck.petlog_android;

import java.util.LinkedList;

/**
 * Created by fomsing on 2016/5/14.
 */
public class likeBase {
    private LinkedList database;
   likeBase(){
        database=new LinkedList<like>();

    }

    like getlike(int id){
        for(int i=0;i<database.size(); i++){
            if(((like)database.get(i)).getid()==id){
                return (like)database.get(i);
            }
        }
        return null;
    }
    public int newalike(int atricleid){
        int newid=database.size();//becouse we always use next number to becone new id,such as when we have 9 messages in database then when we create a new id,it must be9
        like newone=new like(atricleid,newid);
        database.add(newone);
        return newone.getid();
    }
}
