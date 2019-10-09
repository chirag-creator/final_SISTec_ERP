package com.example.server.sistecerp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class view_profile extends AppCompatActivity {

    private TextView textView,textView1,textView2;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;

        @Override

        protected void onCreate(@Nullable Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_view_profile);
            textView=findViewById(R.id.vname);

            textView1=findViewById(R.id.vmob);

            textView2=findViewById(R.id.vadd);
            firebaseAuth=FirebaseAuth.getInstance();
            firebaseDatabase=FirebaseDatabase.getInstance();
            databaseReference=firebaseDatabase.getReference("Stud Info").child(FirebaseAuth.getInstance().getUid());

                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String name="Name:" +dataSnapshot.child("sname").getValue(String.class);
                                String add="Address :" +dataSnapshot.child("address").getValue(String.class);
                                String mob="Mobile Number:" +dataSnapshot.child("mobnum").getValue(String.class);
                                textView.setText(name);
                                textView1.setText(add);
                                textView2.setText(mob);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.i("dsafsd", "onCancelled: ");
                        }
                    });




        }


    }

