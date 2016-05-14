package edu.fcu.pojeck.petlog_android;

import java.util.LinkedList;

/**
 * Created by fomsing on 2016/5/14.
 */
public class messageBase {
    private LinkedList database;
    messageBase(){
        database=new LinkedList<message>();

    }
    void addmessage(message newone){
        database.add(newone);
    }
    message getmessage(int id){
        for(int i=0;i<database.size(); i++){
            if(((message)database.get(i)).getid()==id){
                return (message)database.get(i);
            }
        }
        return null;
    }
    public int newamessage(String text,int atricle_id,int leaver_id){
        int id=database.size();//becouse we always use next number to becone new id,such as when we have 9 messages in database then when we create a new id,it must be9
        message newone=new message(text,atricle_id,id,leaver_id);
        database.add(newone);
        return newone.getid();
    }
}
