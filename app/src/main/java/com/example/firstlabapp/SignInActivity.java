package com.example.firstlabapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignInActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button signButton;

    @BindView(R.id.first_name_edit_text)
    EditText firstNameEditText;

    @BindView(R.id.last_name_edit_text)
    EditText lastNameEditText;

    @BindView(R.id.register_button)
    Button registerButton;

    @BindView(R.id.callsFromProfile)
    TextView callsFromProfileTextView;

    @BindView(R.id.callsFromRegister)
    TextView callsFromRegisterTextView;


    private int profileActivityCounter = 0;
    private int registerActivityCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        
        initViews();
    }

    private void initViews() {
        ButterKnife.bind(this);

        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, ProfileActivity.class);
                intent.putExtra(getString(R.string.firstName), firstNameEditText.getText().toString());
                intent.putExtra(getString(R.string.lastName), lastNameEditText.getText().toString());
                startActivity(intent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, RegisterActivity.class);
                startActivityForResult(intent, Constant.REQUEST_CODE);
            }
        });

        callsFromProfileTextView.setText(String.format(Locale.ENGLISH, "%s %d", getString(R.string.calls_from_profile_activity), profileActivityCounter));
        callsFromRegisterTextView.setText(String.format(Locale.ENGLISH, "%s %d", getString(R.string.calls_from_register_activity), registerActivityCounter));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constant.RESULT_CODE_PROFILE){
            profileActivityCounter++;
        }else if (requestCode == Constant.RESULT_CODE_REGISTER){
            registerActivityCounter++;
        }
    }
}
