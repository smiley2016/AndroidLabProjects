package com.example.firstlabapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.first_name_text_view)
    TextView firstNameText;

    @BindView(R.id.last_name_text_view)
    TextView lastNameText;

    @BindView(R.id.department)
    TextView department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setResult(Constant.RESULT_CODE_PROFILE);
        initViews();
    }

    private void initViews() {
        ButterKnife.bind(this);

        firstNameText.setText(getIntent().getStringExtra(getString(R.string.firstName)));
        lastNameText.setText(getIntent().getStringExtra(getString(R.string.lastName)));

        if (getIntent().getStringExtra(getString(R.string.department)) != null) {
            department.setVisibility(View.VISIBLE);
            department.setText(getIntent().getStringExtra(getString(R.string.department)));
        }else{
            department.setVisibility(View.GONE);
        }


    }

}
