//2. Develop an app that includes a dropdown menu, offering a variety of animation effects such as
//        **Scale**, **Rotate** (both half and full rotations), **Bounce**, **Fade**, **Slide**,
//        **Flip**, **Zoom In/Out**. The user can choose an animation effect from the dropdown,
//        which will then be applied to an image. After the animation is applied, if the user selects
//        a different effect from the dropdown, the image will update to show the new animation,
//        allowing for dynamic and interactive transitions between multiple animation types.


package com.example.practice_2;

import android.os.Bundle;
import android.view.View;
import android.view.animation.*;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        Spinner animationSpinner = findViewById(R.id.animationSpinner);

        animationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                applyAnimation(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void applyAnimation(int animationType) {
        imageView.clearAnimation(); // Clear previous animations
        Animation animation = null;

        switch (animationType) {
            case 0: // Scale
                animation = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(500);
                break;

            case 1: // Rotate Half
                animation = new RotateAnimation(0, 180,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(500);
                break;

            case 2: // Rotate Full
                animation = new RotateAnimation(0, 360,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(500);
                break;

            case 3: // Bounce
                animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
                break;

            case 4: // Fade
                animation = new AlphaAnimation(1.0f, 0.0f);
                animation.setDuration(500);
                break;

            case 5: // Slide
                animation = AnimationUtils.loadAnimation(this, R.anim.slide);
                break;

            case 6: // Flip
                animation = AnimationUtils.loadAnimation(this, R.anim.flip);
                break;

            case 7: // Zoom In
                animation = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(500);
                break;

            case 8: // Zoom Out
                animation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(500);
                break;
        }

        if (animation != null) {
            animation.setFillAfter(true); // Retain animation end state
            imageView.startAnimation(animation);
        }
    }
}