package com.example.kaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.startButton);
        startBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startButton:
                Log.i("on click", "onClick: HERE");
                startActivity(new Intent(this, MainActivity2.class));
                break;
        }
    }
}