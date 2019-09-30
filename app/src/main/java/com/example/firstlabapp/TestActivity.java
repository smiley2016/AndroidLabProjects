package com.example.firstlabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.text_view)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        initViews();
    }

    private void initViews() {
        ButterKnife.bind(this);
        String text = getIntent().getStringExtra("String");
        textView.setText(String.format("%s Test", text));
    }
}
