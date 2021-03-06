package edu.fcu.pojeck.petlog_android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by fomsing on 2016/5/29.
 */
public class ChooseAdapter extends ArrayAdapter{
    Context context;
    View convertV;
    ViewGroup par;
    public ChooseAdapter(Context context, List objects) {
        super(context, 0, objects);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertV=convertView;
        par=parent;
        LayoutInflater inflater = LayoutInflater.from(context);


        LinearLayout layout = null;
        if (convertView == null) {
            layout = (LinearLayout) inflater.inflate(R.layout.picturechooseitem, null);
        } else {
            layout = (LinearLayout) convertView;
        }
        ImageView picture=(ImageView)layout.findViewById(R.id.itempicture);
        TextView colorview=(TextView) layout.findViewById(R.id.chooseornot);
        Bitmap oldbit=((BitmapInt) getItem(position)).picture;

       int oldW=oldbit.getWidth();
        int oldH=oldbit.getHeight();
        float scaleWidth =  (float)500 / (float)oldW;
        float scaleHeight = (float)700/ (float)oldH;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        //Toast.makeText(context,"scW:"+scaleWidth+" scH:"+scaleHeight,Toast.LENGTH_SHORT).show();
        Bitmap newbit=Bitmap.createBitmap(oldbit, 0, 0, oldW, oldH, matrix, true);
        picture.setImageBitmap(newbit);
        if(((BitmapInt) getItem(position)).chosen){
            colorview.setBackgroundColor(android.graphics.Color.RED);
        }
        else{

        }
       // picture.setImageBitmap(scaleImage((Bitmap) getItem(position), 400, 500));
        return layout;
    }
    public  Bitmap scaleImage(Bitmap bm, int newWidth, int newHeight)
    {
        if (bm == null)
        {
            return null;
        }
        int width = bm.getWidth();
        int height = bm.getHeight();
        Toast.makeText(context,"stage1",Toast.LENGTH_SHORT).show();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Toast.makeText(context,"stage2",Toast.LENGTH_SHORT).show();
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Toast.makeText(context,"stage3",Toast.LENGTH_SHORT).show();
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix,
                true);
        Toast.makeText(context,"stage4",Toast.LENGTH_SHORT).show();
        if (bm != null & !bm.isRecycled())
        {
            bm.recycle();
            bm = null;
        }
        return newbm;
    }
    public boolean changecolor(int position){
        if(((BitmapInt) getItem(position)).chosen==false) {
            ((BitmapInt) getItem(position)).chosen = true;
            // View layout=getView(position,convertV,par);
            //TextView colorview=(TextView) layout.findViewById(R.id.chooseornot);
            //colorview.setBackgroundColor(android.graphics.Color.RED);
            this.notifyDataSetChanged();
            return true;
        }
        else {
            ((BitmapInt) getItem(position)).chosen = false;
            Log.v("position",""+((BitmapInt) getItem(position)).chosen);
            this.notifyDataSetChanged();
            return  false;
        }
    }

 }
