package edu.fcu.pojeck.petlog_android;

import android.graphics.Bitmap;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by fomsing on 2016/6/18.
 */
public class AtricleBase {

    private LinkedList database;
    AtricleBase(){
        database=new LinkedList<Atricle>();

    }
    public int newaatricle(Bitmap[] icon, String word, int ownerid, String date,messageBase MB,likeBase LB){
        int newid=database.size();
        Atricle adata=new Atricle(icon,word,ownerid,date,MB,LB,newid);
        database.add(adata);
        return adata.getId();
    }
    void addatricle(Atricle newone){
        database.add(newone);
    }
    public Atricle getAtricle(int id){
        for(int i=0;i<database.size(); i++){
            if(((Atricle)database.get(i)).getId()==id){
                return (Atricle)database.get(i);
            }
        }
        return null;
    }
}
