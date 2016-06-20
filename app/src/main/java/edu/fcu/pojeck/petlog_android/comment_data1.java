package edu.fcu.pojeck.petlog_android;

/**
 * Created by kiam on 18/06/2016.
 */
public class comment_data1 {
    int humanhead;
    String comment,name,time;

    public comment_data1(int humanhead, String comment, String name, String time) {
        this.humanhead = humanhead;
        this.comment = comment;
        this.name = name;
        this.time = time;
    }

    public int getHumanhead() {
        return humanhead;
    }

    public void setHumanhead(int humanhead) {
        this.humanhead = humanhead;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
