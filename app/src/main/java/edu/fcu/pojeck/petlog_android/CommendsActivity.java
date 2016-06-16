package edu.fcu.pojeck.petlog_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CommendsActivity extends AppCompatActivity {
    private Button determine,choose_Picture;
    private EditText et_msg;
    private static final int  KEY_PICTURE = 1;
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
    // -------------------       ↑設定監聽器↑       -------------------//


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
