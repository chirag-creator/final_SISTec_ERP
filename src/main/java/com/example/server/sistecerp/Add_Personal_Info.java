package com.example.server.sistecerp;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Add_Personal_Info extends AppCompatActivity {

    private EditText editText1,editText2,editText3;
    private Button button;
    private String stud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__personal__info);
        editText1=findViewById(R.id.sname);
        editText2=findViewById(R.id.mobnum);
        editText3=findViewById(R.id.address);
        button=findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object> map= new HashMap<>();
                map.put("sname",editText1.getText().toString());
                map.put("mobnum",editText2.getText().toString());
                map.put("address",editText3.getText().toString());
                FirebaseDatabase.getInstance().getReference().child("Stud Info").child(FirebaseAuth.getInstance().getUid())
                        .setValue(map)

                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Log.i("asdf", "onComplete: ");
                                Toast.makeText(Add_Personal_Info.this, "Data Updated",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("sdf", "onFailure: "+e.toString());
                    }
                });
            }
        });
    }

}
