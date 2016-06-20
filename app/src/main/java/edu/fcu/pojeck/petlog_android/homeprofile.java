package edu.fcu.pojeck.petlog_android;

/**
 * Created by pinyan on 2016/6/20.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class homeprofile extends Activity {
    Button b;
    EditText name,pet1,pet2,pet3,profile;
    /*key*/
    public final static String NAME ="name";
    public final static String PETNAME="petname";
    public final static String PETSEX="petsex";
    public final static String PETYEAR="petyear";
    public final static String PROFILE="profile";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_profile);

        b=(Button)findViewById(R.id.bt_save);
        name=(EditText)findViewById(R.id.et_name);
        pet1=(EditText)findViewById(R.id.et_petname);
        pet2=(EditText)findViewById(R.id.et_sex);
        pet3=(EditText)findViewById(R.id.et_petyear);
        profile=(EditText)findViewById(R.id.et_say);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n1=name.getText().toString();
                String p1=pet1.getText().toString();
                String p2=pet2.getText().toString();
                String p3=pet3.getText().toString();
                String pro=profile.getText().toString();

                /*把值丟進*/
                Intent i=new Intent(homeprofile.this,HomeActivity.class);
                i.putExtra(NAME,n1);
                i.putExtra(PETNAME,p1);
                i.putExtra(PETSEX,p2);
                i.putExtra(PETYEAR,p3);
                i.putExtra(PROFILE,pro);

                startActivity(i); //切換Activity
            }
        });
    }

}