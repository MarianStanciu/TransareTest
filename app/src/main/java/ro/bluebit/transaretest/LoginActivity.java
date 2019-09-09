package ro.bluebit.transaretest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ro.bluebit.transaretest.database.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    EditText mTextUsername, mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myDb = new DatabaseHelper(this);

        mTextUsername=findViewById(R.id.edittext_username);
        mTextPassword=findViewById(R.id.editext_password);
        mButtonLogin=findViewById(R.id.button_login);
        mTextViewRegister=findViewById(R.id.textview_register);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String password = mTextPassword.getText().toString().trim();
                Boolean res = myDb.checkUser(user, password);
                if (res==true){
                    Toast.makeText(LoginActivity.this, " Succesfully loggeg in", Toast.LENGTH_SHORT).show();
                    Intent selectieTransare = new Intent(LoginActivity.this, SelectieFacturaMateriePrimaActivity.class);
                    startActivity(selectieTransare);

                }
                else{
                    Toast.makeText(LoginActivity.this, " LOGIN ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
