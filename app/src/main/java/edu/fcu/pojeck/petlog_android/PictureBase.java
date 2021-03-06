package edu.fcu.pojeck.petlog_android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fomsing on 2016/5/14.
 */
public class PictureBase {
    public static int nowindex=0;//记录getdefaultbitmapfromSD的所引致
    private LinkedList database;
    PictureBase(){
        List dafault= getImagesPathFromSD();
        database=new LinkedList<Picturedata>();

    }
    public int newapicture(Bitmap[] icon, String word, int ownerid, String date,messageBase MB,likeBase LB){
        int newid=database.size();
        Picturedata pdata=new Picturedata(icon,word,ownerid,date,MB,LB,newid);
        database.add(pdata);
        return pdata.getId();
    }
    void addPicture(Picturedata newone){
        database.add(newone);//
    }
    public Picturedata getPicture(int id){
        for(int i=0;i<database.size(); i++){
            if(((Picturedata)database.get(i)).getId()==id){
                return (Picturedata)database.get(i);
            }
        }
        return null;
    }

    //find picture in SDcard-------------------
    public static ArrayList<String> getImagesPathFromSD() {
        ArrayList<String> imagePaths = new ArrayList<String>();
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)
                || Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED_READ_ONLY)) {
            File file = Environment.getExternalStorageDirectory();
            //这里只做了单级目录，多级目录做一个简单的判断递归就ok了
            if(file !=null){
                File[] files = file.listFiles();
                for (File f : files)
                {
                    if(isImageFile(f.getPath())){
                        imagePaths.add(f.getPath());
                    }
                }
            }
        }
        return imagePaths;
    }
   public static Bitmap getdefaultbitmapfromSD(){
        ArrayList list=getImagesPathFromSD();
       Bitmap map=null;
       if(nowindex<list.size()){
           map= BitmapFactory.decodeFile((String)list.get(nowindex++));
       }
       if (nowindex>=list.size()){
           nowindex=0;
       }
       return map;
    }
    public static Bitmap getfirstbitmapfromSD(){
        ArrayList list=getImagesPathFromSD();
        if(list.size() <= 0){
            return  null;
        }
        Bitmap map=null;

            map= BitmapFactory.decodeFile((String)list.get(0));

        return map;
    }
    public  static ArrayList getallpictureinSD(){
        ArrayList list=getImagesPathFromSD();
        ArrayList bitmaplist=new ArrayList();
        for (int i=0;i<list.size();i++) {
            bitmaplist.add(BitmapFactory.decodeFile((String) list.get(i)));
        }
        return bitmaplist;
    }

    private static String[] imageFormatSet = new String[]{"jpg","png","gif"};
    private static boolean isImageFile(String path) {

        for(String format : imageFormatSet){
            if(path.contains(format)){
                return true;
            }
        }
        return false;
    }

}

