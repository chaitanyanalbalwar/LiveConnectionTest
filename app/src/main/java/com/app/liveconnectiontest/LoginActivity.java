package com.app.liveconnectiontest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.liveconnectiontest.databinding.ActivityLoginBinding;
import com.app.liveconnectiontest.models.LoginModel;

public class LoginActivity extends AppCompatActivity {

    private LoginModel loginMOdel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_login);

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.edtEmail.getText().toString().isEmpty()){
                    binding.edtEmail.setError("Enter Email Address");
                    binding.edtEmail.requestFocus();
                }
                else if (binding.edtPass.getText().toString().isEmpty()){
                    binding.edtPass.setError("Enter Password ");
                    binding.edtPass.requestFocus();
                } else if (binding.edtPass.getText().toString().length()<6){
                    binding.edtPass.setError("Password Length is too short");
                    binding.edtPass.requestFocus();
                }else if (!isValidEmail(binding.edtEmail.getText().toString())){
                    binding.edtEmail.setError("invalid Email Address");
                    binding.edtEmail.requestFocus();
                }else {
                    Log.d("Email",binding.edtEmail.getText().toString());
                    Log.d("Pass",binding.edtPass.getText().toString());

                    loginMOdel=new LoginModel();
                    loginMOdel.setEmail(binding.edtEmail.getText().toString());
                    loginMOdel.setPassword(binding.edtPass.getText().toString());
                    binding.setUser(loginMOdel);

                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }
            }
        });
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}