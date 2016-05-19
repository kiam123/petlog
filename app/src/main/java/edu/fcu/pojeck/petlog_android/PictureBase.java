package edu.fcu.pojeck.petlog_android;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fomsing on 2016/5/14.
 */
public class PictureBase {
    private LinkedList database;
    PictureBase(){
        List dafault= getImagesFromSD();
        database=new LinkedList<Picturedata>();
        for (int i=0 ;i<10 ;i++){

        }
    }
    public void newapicture(){

    }
    void addPicture(Picturedata newone){
        database.add(newone);
    }
    Picturedata getPicture(int id){
        for(int i=0;i<database.size(); i++){
            if(((Picturedata)database.get(i)).getid()==id){
                return (Picturedata)database.get(i);
            }
        }
        return null;
    }
    //find picture in SDcard-------------------
    public static List<String> getImagesFromSD() {
        List<String> imagePaths = new ArrayList<String>();
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

