package com.pm.factor_abono;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInFragment extends Fragment {

    View vista;
    Button btnSignIn;
    EditText editTextUserNameEmail;
    EditText editTextPassWord;
    TextView textViewForgotPassword;
    TextView textViewRegister;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SignInFragment() {
    }


    // TODO: Rename and change types and number of parameters
    public static SignInFragment newInstance(String param1, String param2) {
        SignInFragment fragment = new SignInFragment();
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

        vista = inflater.inflate(R.layout.fragment_sign_in, container, false);

        editTextUserNameEmail = (EditText) vista.findViewById(R.id.edTxtUser_Ficha);
        editTextPassWord = (EditText) vista.findViewById(R.id.edTxtInPassword);

        textViewForgotPassword = (TextView) vista.findViewById(R.id.txtForgotPass);
        textViewRegister = (TextView) vista.findViewById(R.id.txtRegister);

        btnSignIn = (Button) vista.findViewById(R.id.signInBtn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                //Conexión con API para validar login
                if(!userNM.isEmpty() && !password.isEmpty()){
                    Intent intent = new Intent(SignInFragment.this.getActivity(),DashboardActivity.class);
                    startActivity(intent);
                }
            }
        });
        return vista;
    }
}