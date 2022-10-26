package com.pm.factor_abono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    EditText editTextUserNameEmail;
    EditText editTextPassWord;
    TextView textViewForgotPassword;
    TextView textViewRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editTextUserNameEmail = (EditText) findViewById(R.id.edTxtUser_Ficha);
        editTextPassWord = (EditText) findViewById(R.id.edTxtInPassword);

        textViewForgotPassword = (TextView) findViewById(R.id.txtForgotPass);
        textViewRegister = (TextView) findViewById(R.id.txtRegister);
    }

    public void SignInBtnClicked(View view) {
        String userNM = editTextUserNameEmail.getText().toString().trim();
        String password = editTextPassWord.getText().toString().trim();

        if(userNM.isEmpty() || !userNM.contains("@")){
            editTextUserNameEmail.setError("Por favor ingrese un correo electrónico");
            editTextUserNameEmail.requestFocus();
        }
        if(password.isEmpty()){
            editTextPassWord.setError("Por favor ingrese una contraseña");
            editTextPassWord.requestFocus();
        }
        Intent intent = new Intent(SignInActivity.this,DashboardActivity.class);
        startActivity(intent);

    }

    public void txtSignInForgotPass(View view) {
    }

    public void txtSignInRegister(View view) {
    }
}