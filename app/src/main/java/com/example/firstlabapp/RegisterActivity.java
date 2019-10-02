package com.example.firstlabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.first_name_register_edit_text)
    EditText firstNameEditText;

    @BindView(R.id.last_name_register_edit_text)
    EditText lastNameEditText;

    @BindView(R.id.department_register)
    EditText department;

    @BindView(R.id.register_button)
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setResult(Constant.RESULT_CODE_REGISTER);
        initViews();


    }

    private void initViews() {

        ButterKnife.bind(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, ProfileActivity.class);
                intent.putExtra(getString(R.string.firstName), firstNameEditText.getText().toString());
                intent.putExtra(getString(R.string.lastName), lastNameEditText.getText().toString());
                intent.putExtra(getString(R.string.department), department.getText().toString());
                startActivity(intent);
            }
        });
    }
}
