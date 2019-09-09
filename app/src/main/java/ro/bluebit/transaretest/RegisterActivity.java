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

public class RegisterActivity extends AppCompatActivity {
    EditText mTextUsername, mTextPassword, mTextConfirmPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myDb=new DatabaseHelper(this);
        mTextUsername=findViewById(R.id.edittext_username);
        mTextPassword=findViewById(R.id.editext_password);
        mTextConfirmPassword=findViewById(R.id.editext_confirm_password);
        mButtonRegister=findViewById(R.id.button_register);
        mTextViewLogin=findViewById(R.id.textview_login);

        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String password = mTextPassword.getText().toString().trim();
                String confirm_password = mTextConfirmPassword.getText().toString().trim();

                if (password.equals(confirm_password))
                {
                    long val = myDb.addUser(user,password);
                    if (val > 0) {
                        Toast.makeText(RegisterActivity.this, " REGISTER IS SUCCESFULL", Toast.LENGTH_LONG).show();
                        Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(loginIntent);
                    }

                }
                else{
                    Toast.makeText(RegisterActivity.this, " PASSWORD DOESN'T MATCH", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
