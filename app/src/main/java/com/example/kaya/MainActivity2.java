package com.example.kaya;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity2 extends AppCompatActivity  implements  View.OnClickListener {
    Button bagEstimatorButton;
    Button vrService;

    ArFragment arFragment;
    private ModelRenderable modelRenderable;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bagEstimatorButton = (Button) findViewById(R.id.bagEstimator);
        bagEstimatorButton.setOnClickListener(this);
        ImageView bag;

        vrService = (Button) findViewById(R.id.vrAsssitant);
        vrService.setOnClickListener(this);

        arFragment = (ArFragment)getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);
        setUpModel();
        setUpPlane();

    }

    public void setUpPlane(){
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                // When user tap the plane, we will add model

                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);

                anchorNode.setParent(arFragment.getArSceneView().getScene());

                createModel(anchorNode);

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setUpModel(){

        ModelRenderable.builder()
                .setSource(this, R.raw.model)
                .build().thenAccept( renderable -> modelRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this, "Unable to load Model", Toast.LENGTH_SHORT).show();
                    return null;
                }
         );
    }
    private void createModel(AnchorNode anchorNode){
        TransformableNode bag = new TransformableNode(arFragment.getTransformationSystem());
        bag.setParent(anchorNode);
        bag.setRenderable(modelRenderable);
        bag.select();

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