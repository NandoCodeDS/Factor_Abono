package com.pm.factor_abono;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

public class SignUpActivity extends AppCompatActivity {

    EditText editTextUsername;
    EditText editTextEmail;
    EditText editTextConfirmEmail;
    EditText editTextPassword;
    EditText editTextConfirmPassword;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextUsername =(EditText)findViewById(R.id.edTxtUserFicha);
        editTextEmail =(EditText)findViewById(R.id.edTxtEmail);
        editTextConfirmEmail =(EditText)findViewById(R.id.edTxtConfirmEmail);
        editTextPassword =(EditText)findViewById(R.id.edTxtPassword);
        editTextConfirmPassword =(EditText)findViewById(R.id.edTxtConfirmPassword);
        progressBar  =(ProgressBar) findViewById(R.id.progressBar);

    }

    public void SignUpBtnClicked(View view) {
        String txtUsername = editTextUsername.getText().toString().trim();
        String txtEmail = editTextEmail.getText().toString().trim();
        String txtConfirmEmail = editTextConfirmEmail.getText().toString().trim();
        String txtPassword = editTextPassword.getText().toString().trim();
        String txtConfirmPassword = editTextConfirmPassword.getText().toString().trim();

        if(txtUsername.isEmpty()){
            editTextUsername.setError("Por favor ingrese un nombre de Usuario");
            editTextUsername.requestFocus();
        }
        if (txtEmail.isEmpty()){
            editTextEmail.setError("Por favor ingrese un correo electrónico");
            editTextEmail.requestFocus();
        }
        if (txtConfirmEmail.isEmpty()){
            editTextConfirmEmail.setError("Por favor confirme el correo electrónico");
            editTextConfirmEmail.requestFocus();
        }
        if (!(txtEmail.equals(txtConfirmEmail))){
            editTextConfirmEmail.setError("Por favor revisar los correos, no son iguales");
            editTextConfirmEmail.requestFocus();
        }
        if (txtPassword.isEmpty() || txtPassword.length()<6){
            editTextPassword.setError("Por favor ingrese una conrtaseña, con al menos 6 caracteres");
            editTextPassword.requestFocus();
        }
        if (txtConfirmPassword.isEmpty()){
            editTextConfirmPassword.setError("Por favor confirme la contraseña");
            editTextConfirmPassword.requestFocus();
        }
        if (!(txtPassword.equals(txtConfirmPassword))){
            editTextConfirmPassword.setError("Por favor revisar las contraseñas, no son iguales");
            editTextConfirmPassword.requestFocus();
        }

        progressBar.setVisibility(View.VISIBLE);

        //Aqui asignar la funcion para POST
        //Adicionar condicional y colocar: progressBar.setVisibility(View.GONE); para if y else

    }
}