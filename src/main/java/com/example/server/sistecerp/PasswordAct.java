package com.example.server.sistecerp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordAct extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        editText=findViewById(R.id.Forget_pas_email);
        firebaseAuth=FirebaseAuth.getInstance();
        button=findViewById(R.id.Confirm_forgetpas);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String usermail=editText.getText().toString().trim();
                if(usermail.equals("")) {
                    Toast.makeText(PasswordAct.this,"Please Enter Email",Toast.LENGTH_LONG).show();
                }
                else {

                    firebaseAuth.sendPasswordResetEmail(usermail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(PasswordAct.this,"Password Reset Email sent!",Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(new Intent(PasswordAct.this,Login.class));
                            }
                            else{

                                Toast.makeText(PasswordAct.this,"Error",Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                }
                }

        });
    }
}
