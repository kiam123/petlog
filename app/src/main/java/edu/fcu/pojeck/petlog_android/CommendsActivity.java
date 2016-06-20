package edu.fcu.pojeck.petlog_android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class CommendsActivity extends AppCompatActivity {
    private Button determine,choose_Picture;
    private EditText et_msg;
    ImageView taskView;
    private static final int  KEY_PICTURE = 1;
    public static final String KEY_PICTUREINDEX="PICTUREINDEX",KEY_COMMENTS="COMMENT";
    public static final int fine=1;
    ArrayList indexarray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commends);

        InitView();
    }

    public void InitView(){
        determine = (Button)findViewById(R.id.determine);
        choose_Picture = (Button)findViewById(R.id.choose_Picture);
        et_msg = (EditText)findViewById(R.id.et_msg);


        determine.setOnClickListener(determineListener);
        choose_Picture.setOnClickListener(choosePictureListener);
    }


    // -------------------       ↓設定監聽器↓       -------------------//
    private View.OnClickListener choosePictureListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(CommendsActivity.this,PictureChoose.class);
            startActivityForResult(intent,KEY_PICTURE);
        }
    };

    private View.OnClickListener determineListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            Log.v("comment",""+et_msg.getText().toString());
            if(!et_msg.getText().toString().equals("")){
                if(indexarray != null) {
                    intent.putExtra(KEY_PICTUREINDEX, indexarray);
                    intent.putExtra(KEY_COMMENTS,et_msg.getText().toString());
                }
                else {
                    indexarray = new ArrayList();
                    intent.putExtra(KEY_PICTUREINDEX,indexarray);
                    intent.putExtra(KEY_COMMENTS,et_msg.getText().toString());
                }
                setResult(fine,intent);
                finish();
            }
            else{
                Toast.makeText(CommendsActivity.this,"輸入不能為空",Toast.LENGTH_SHORT).show();
            }
        }
    };
    // -------------------       ↑設定監聽器↑       -------------------//

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this,"code"+requestCode,Toast.LENGTH_SHORT).show();
        if (requestCode == KEY_PICTURE){
            indexarray = data.getIntegerArrayListExtra(PictureChoose.KEY_PICTUREINDEX);

            //Toast.makeText(this,"result size:"+indexarray.size(),Toast.LENGTH_SHORT).show();
            ArrayList picturearray = PictureBase.getallpictureinSD();
            //Log.d("logggg", "arraysize "+picturearray.size());
            ArrayList resultArray = new ArrayList();
            for (int i=0; i<indexarray.size(); i++){
                resultArray.add((Bitmap)picturearray.get(((Integer)indexarray.get(i)).intValue()));
                Log.d("logggg", "index is " + ((Integer) indexarray.get(i)).intValue());
                Log.d("logggg", "bitmsp "+(Bitmap)picturearray.get(((Integer)indexarray.get(i)).intValue()));
            }
            Log.d("logggg", "size after" + resultArray.size());
            taskView=(ImageView)findViewById(R.id.taskimg);
            taskView.setImageBitmap((Bitmap)resultArray.get(0));
            //Toast.makeText(CommendsActivity.this,resultArray.size(),Toast.LENGTH_SHORT).show();
            //reaultArray就是選擇出來的圖片組
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_commends, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
