package com.starks.gortc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SelectActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
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
        }
        return super.onOptionsItemSelected(item);
    }


    public void scientists(View view) {
        Intent intent1 = new Intent(this,ScientistsLogin.class);
        startActivity(intent1);
    }


}
