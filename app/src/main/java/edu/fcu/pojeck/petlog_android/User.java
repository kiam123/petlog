package edu.fcu.pojeck.petlog_android;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by fomsing on 2016/5/21.
 */
public class User {
    File head;//頭像
    String name;
    String account;//帳號
    String password;//密碼
    LinkedList Atricle_id;//暫時沒用到
    LinkedList Picture_id;//暫時沒用到
    LinkedList fans_id;//追蹤你的人的id
    LinkedList trace_id;//你追蹤的人的id
    LinkedList Atriclepoor;//按順序儲存發過的文章
    LinkedList Picturepoor;//按順序存儲發過的圖片
    LinkedList notice;//
    boolean sex;//性別true為男性,false為女性

    public User(File head, String name, String account, String password, boolean sex) {
        this.head = head;
        this.name = name;
        this.account = account;
        this.password = password;
        this.sex = sex;
        Atricle_id= new LinkedList();
        Picture_id= new LinkedList();
        fans_id= new LinkedList();
        trace_id= new LinkedList();
        Atriclepoor= new LinkedList();
        Picturepoor=  new LinkedList();
    }

    public File getHead() {
        return head;
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSex() {
        return sex;
    }
    public void fansAdd(int fansid){//增加一個被追蹤者
        this.fans_id.add(fansid);
    }

    public void trace(int traceid){
        this.trace_id.add(traceid);
    }

}
