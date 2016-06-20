package edu.fcu.pojeck.petlog_android;

/**
 * Created by kiam on 20/06/2016.
 */
public class comment_data2 {
    int image;
    String name,time;

    public comment_data2(int image, String name, String time) {
        this.image = image;
        this.name = name;
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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
