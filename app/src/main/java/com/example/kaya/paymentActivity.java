package com.example.kaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class paymentActivity extends AppCompatActivity implements View.OnClickListener {
     Button ButtonPaid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButtonPaid = (Button) findViewById(R.id.buttonPaid);
        ButtonPaid.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonPaid:
                startActivity(new Intent(this, bagWeightActivity.class));
                break;

        }
    }
}