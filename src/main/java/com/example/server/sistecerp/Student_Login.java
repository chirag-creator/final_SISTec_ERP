package com.example.server.sistecerp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.time.Instant;

public class Student_Login extends AppCompatActivity {

    private DrawerLayout dl;

    private ActionBarDrawerToggle t;

    private NavigationView nv;

    private TextView view_P,Add_info;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_student__login);

        view_P=findViewById(R.id.View_profile);
        Add_info =findViewById(R.id.Add_info);
        dl = findViewById(R.id.draw);

        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);


        view_P.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Student_Login.this,view_profile.class);
                startActivity(intent);
            }
        });
        Add_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Student_Login.this,Add_Personal_Info.class);
                startActivity(intent);
            }
        });

        dl.addDrawerListener(t);

        t.syncState();



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        nv = (NavigationView)findViewById(R.id.nav_view);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                switch(id)

                {

//                    case R.id.view: {
//                        Toast.makeText(Student_Login.this, "My Account", Toast.LENGTH_SHORT).show();
////                       // Intent intent = new Intent(Student_Login.this, view_profile.class);
////                        finish();
////                        startActivity(intent);
//
//                    }
//                    case R.id.settings: {
//
//                        Toast.makeText(Student_Login.this, "Reset Password", Toast.LENGTH_SHORT).show();
////                        Intent intent2 = new Intent(Student_Login.this, PasswordAct.class);
////                        finish();
////                        startActivity(intent2);
//   }
                    case R.id.logout: {
                        Toast.makeText(Student_Login.this, "Logout", Toast.LENGTH_SHORT).show();
                      finish();
                        Intent intent3 = new Intent(Student_Login.this, Login.class);

                        startActivity(intent3);
                    }
                        default:

                        return true;

                }









            }

        });





    }



    @Override

    public boolean onOptionsItemSelected(MenuItem item) {



        if(t.onOptionsItemSelected(item))

            return true;



        return super.onOptionsItemSelected(item);

    }


}
