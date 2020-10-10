package com.example.kaya;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;

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
//                startActivity(new Intent(this, bagWeightActivity.class));
                final EditText flightSource = (EditText) findViewById(R.id.editTextSource);
                String flightSourceName = flightSource.getText().toString();

                final EditText flightDestination = (EditText) findViewById(R.id.editTextDestination);
                String flightDestinationName = flightDestination.getText().toString();

                final EditText flightDate = (EditText) findViewById(R.id.editTextDate);
                String flightDateName = flightDate.getText().toString();

                System.out.println(flightDateName + flightDestinationName + flightSourceName);

                String url = "https://kayobe.herokuapp.com/flights?date=" + flightDateName;


                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(this);

// Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
//                                textView.setText("Response is: "+ response.substring(0,500));
                                System.out.println("flight data: " + response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        textView.setText("That didn't work!");
                        System.out.println("did not work");
                    }
                });

// Add the request to the RequestQueue.
                queue.add(stringRequest);

                break;

        }
    }
}
