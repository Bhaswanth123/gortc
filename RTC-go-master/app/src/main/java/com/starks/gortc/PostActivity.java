package com.starks.gortc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostActivity extends AppCompatActivity {

    EditText editText1,editText2,editText3;
    Button submit;


    DatabaseReference rootRef,demoRef1,demoRef2,demoRef3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        editText1 = (EditText) findViewById(R.id.route);
        editText2 = (EditText) findViewById(R.id.source);
        editText3 = (EditText) findViewById(R.id.destination);
        submit = (Button) findViewById(R.id.submit);
        //database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();
        //database reference pointing to demo node
        demoRef1 = rootRef.child("route");
        demoRef2 = rootRef.child("source");
        demoRef3 = rootRef.child("destin");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String route = editText1.getText().toString();
                String source = editText2.getText().toString();
                String destin = editText3.getText().toString();
                //push creates a unique id in database
                demoRef1.push().setValue(route);
                demoRef2.push().setValue(source);
                demoRef3.push().setValue(destin);
            }
        });
    }
}
