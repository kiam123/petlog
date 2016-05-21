package edu.fcu.pojeck.petlog_android;

/**
 * Created by fomsing on 2016/5/14.
 */
public class message {
   private String text;
   private int host_atricleId;//the is of which atricle this message is in
   private int id;
    private int leaver_Id;//the id of the user who send it;
    public int getid(){
        return id;
    }

    public message(String text, int host_atricleId, int id, int leave_rId) {
        this.text = text;
        this.host_atricleId = host_atricleId;
        this.id = id;
        this.leaver_Id = leave_rId;
    }
}
