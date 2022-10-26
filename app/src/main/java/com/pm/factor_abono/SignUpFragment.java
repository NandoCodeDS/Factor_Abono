package com.pm.factor_abono;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class SignUpFragment extends Fragment {

    View vista;
    Button btnSignUp;
    EditText editTextUsername;
    EditText editTextEmail;
    EditText editTextConfirmEmail;
    EditText editTextPassword;
    EditText editTextConfirmPassword;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SignUpFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SignUpFragment newInstance(String param1, String param2) {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_sign_up, container, false);

        editTextUsername =(EditText) vista.findViewById(R.id.edTxtUserFicha);
        editTextEmail =(EditText) vista.findViewById(R.id.edTxtEmail);
        editTextConfirmEmail =(EditText) vista.findViewById(R.id.edTxtConfirmEmail);
        editTextPassword =(EditText) vista.findViewById(R.id.edTxtPassword);
        editTextConfirmPassword =(EditText) vista.findViewById(R.id.edTxtConfirmPassword);

        btnSignUp = (Button) vista.findViewById(R.id.signUpBtn);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

                //Hacer la validación para enviar Metodo POST a la API
                //Validar primero si el usuario existe
                if (!txtUsername.isEmpty() && !txtEmail.isEmpty() && !txtConfirmEmail.isEmpty() && !txtPassword.isEmpty() && !txtConfirmPassword.isEmpty()){
                    Intent intent = new Intent(SignUpFragment.this.getActivity(),WelcomeActivity.class);
                    startActivity(intent);
                }
            }
        });
        return vista;
    }
}