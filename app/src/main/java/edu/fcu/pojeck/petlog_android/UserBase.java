package edu.fcu.pojeck.petlog_android;

import android.os.Environment;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by fomsing on 2016/5/21.
 */
public class UserBase {
    LinkedList database;
    public void newaUser(File head, String name, String account, String password, boolean sex){
        database.add(new User(head ,name ,account ,password ,sex ,database.size()));
    }
    public User getuser(int id){
        for (int i=0;i<database.size();i++ ){
            if(((User)database.get(i)).getId()==id)
                return ((User)database.get(i));
        }
        return null;
    }
    public static File getdefaultImage(){//測試用method,從sd卡內獲得預設頭像
        String path = Environment.getExternalStorageDirectory().getPath();
        File defaulthead=new File(path+"/default1.jpg");
        return defaulthead;

    }
}
