package com.example.kaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity  implements  View.OnClickListener {
    Button bagEstimatorButton;
    Button vrService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bagEstimatorButton = (Button) findViewById(R.id.bagEstimator);
        bagEstimatorButton.setOnClickListener(this);

        vrService = (Button) findViewById(R.id.vrAsssitant);
        vrService.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bagEstimator:
                startActivity(new Intent(this, paymentActivity.class));
                break;
            case R.id.vrAsssitant:
                startActivity(new Intent(this, MainActivity2.class));
                break;
        }
    }
}