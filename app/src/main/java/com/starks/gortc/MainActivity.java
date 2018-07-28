package com.starks.gortc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {


    DatabaseReference rootRef,demoRef1,demoRef2,demoRef3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                       */
                Intent mapIntent = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(mapIntent);
                //Intent intent = getIntent();
                //String address=intent.getStringExtra("location");
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){


        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){

        switch (item.getItemId()){
            case R.id.first:
                Toast.makeText(this,"First",Toast.LENGTH_LONG).show();
                return true;
            case R.id.second:
                Toast.makeText(this,"Second",Toast.LENGTH_LONG).show();
                return true;
            case R.id.third:
                Toast.makeText(this,"Third",Toast.LENGTH_LONG).show();
                return true;
            case R.id.h:
                Intent intent = new Intent(MainActivity.this,PostActivity.class);
                startActivity(intent);
                return true;
            case R.id.h2:
                //listViewMethod();
               Intent intent2 = new Intent(MainActivity.this,TrackerActivity.class);
                startActivity(intent2);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }


}

