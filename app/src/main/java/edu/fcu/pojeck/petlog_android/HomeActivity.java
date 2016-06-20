package edu.fcu.pojeck.petlog_android;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private static final int SELECTED_PIC=100;
    ImageView iv;
    Button bt1;
    Uri ImageUri;
    //
    TextView tv_n,tv_p,tv_pro;
    Button b;
    public final static String NAME ="name";
    public final static String PETNAME="petname";
    public final static String PETSEX="petsex";
    public final static String PETYEAR="petyear";
    public final static String PROFILE="profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        iv=(ImageView)findViewById(R.id.headicon);
        bt1=(Button)findViewById(R.id.changebt);
        b=(Button)findViewById(R.id.edit_button);
        tv_n=(TextView)findViewById(R.id.back_name);
        tv_p=(TextView)findViewById(R.id.backtv_pet);
        tv_pro=(TextView)findViewById(R.id.backtv_say);

        iv.setImageBitmap(PetlogActivity.header);
        /*換大頭貼的button*/
        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openGallery();
            }
        });

        /*編輯個人頁面的button*/
        b.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(HomeActivity.this,homeprofile.class);
                startActivity(i);
            }
        });
        Intent i2=getIntent();
        String n1=i2.getStringExtra(NAME);
        String petn=i2.getStringExtra(PETNAME);
        String pets=i2.getStringExtra(PETSEX);
        String pety=i2.getStringExtra(PETYEAR);
        String pro1=i2.getStringExtra(PROFILE);

        /*輸出text內容*/
        tv_n.setText(n1);
        if (petn!=null && pets!=null && pety!=null) tv_p.setText("[寵物簡介]"+"名:"+petn+" / 性別:"+pets+" / 年齡:"+pety);
        if (pro1!=null) tv_pro.setText("簡介:"+pro1);
    }

    /*開啟相片集*/
    private void openGallery(){
        Intent gallery= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, SELECTED_PIC);
    }

    protected void onActivityResult (int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode==SELECTED_PIC){
            /*如果有選圖片 預設圖片就會設定為透明*/
            iv.setBackgroundColor(android.graphics.Color.parseColor("#00000000"));

            /*把大頭貼圖片換成選取的圖片*/
            ImageUri = data.getData();
            iv.setImageURI(ImageUri);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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