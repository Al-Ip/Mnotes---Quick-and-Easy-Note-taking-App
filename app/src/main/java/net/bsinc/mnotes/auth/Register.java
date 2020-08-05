package net.bsinc.mnotes.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;

import net.bsinc.mnotes.MainActivity;
import net.bsinc.mnotes.R;
import net.bsinc.mnotes.note.EditNote;

public class Register extends AppCompatActivity {
    EditText rUserName, rUserEmail, rUserPass, rUserConfirmPass;
    Button syncAccount;
    TextView loginAct;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Create New Mnote Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rUserName = findViewById(R.id.userName);
        rUserEmail = findViewById(R.id.userEmail);
        rUserPass = findViewById(R.id.password);
        rUserConfirmPass = findViewById(R.id.passwordConfirm);

        syncAccount = findViewById(R.id.createAccount);
        loginAct = findViewById(R.id.login);
        progressBar = findViewById(R.id.progressBar4);

        firebaseAuth = FirebaseAuth.getInstance();

        syncAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String uUsername = rUserName.getText().toString();
                String uUserEmail = rUserEmail.getText().toString();
                String uUserPass = rUserPass.getText().toString();
                String uConfirmPass = rUserConfirmPass.getText().toString();

                if(uUsername.isEmpty() || uUserEmail.isEmpty() || uUserPass.isEmpty() || uConfirmPass.isEmpty()){
                    Toast.makeText(Register.this, "Cannot Leave any fields empty, try again!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!uUserPass.equals(uConfirmPass))
                    rUserConfirmPass.setError("Passwords Do NOT Match!");

                progressBar.setVisibility(View.VISIBLE);

                // upgrading temp account to new account
                AuthCredential credential = EmailAuthProvider.getCredential(uUserEmail, uUserPass);
                firebaseAuth.getCurrentUser().linkWithCredential(credential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(Register.this, "Successfully Created An Account!", Toast.LENGTH_LONG).show();
//                        Intent i = new Intent(view.getContext(), MainActivity.class);
//                        i.putExtra("username", rUserName.toString());
//                        i.putExtra("email", rUserEmail.toString());
//                        startActivity(i);
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register.this, "ERROR: Creating new Account, Try again!", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });


            }
        });

        loginAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
        return super.onOptionsItemSelected(item);
    }
}