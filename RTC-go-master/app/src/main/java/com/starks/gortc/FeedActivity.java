package com.starks.gortc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FeedActivity extends AppCompatActivity {

    DatabaseReference rootRef,demoRef1,demoRef2,demoRef3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
    //    listViewMethod();
    }
    public void listViewMethod()
    {
        ListView myFiendsView=findViewById(R.id.myFriends);

        final ArrayList<String> arrayList=new ArrayList<String>();
        final String[] route = new String[1];
        final String[] source = new String[1];
        final String[] destin = new String[1];
        String total;
        rootRef = FirebaseDatabase.getInstance().getReference();
        demoRef1.child("route").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                route[0] = dataSnapshot.getValue(String.class);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        demoRef2.child("source").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                source[0] = dataSnapshot.getValue(String.class);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        demoRef3.child("destin").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                destin[0] = dataSnapshot.getValue(String.class);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


        total= route[0] + source[0] + destin[0];
        arrayList.add(total);


        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arrayList);

        myFiendsView.setAdapter(myAdapter);

        myFiendsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String message=arrayList.get(position);

            }
        });
    }
}
