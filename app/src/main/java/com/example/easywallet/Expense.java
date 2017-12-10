package com.example.easywallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Expense extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = Income.class.getName();

    private EditText mDetail, mMoney;
    private Button mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        mDetail = findViewById(R.id.d2_textView);
        mMoney = findViewById(R.id.m2_textView);
    }

    @Override
    public void onClick(View view) {

    }
}
