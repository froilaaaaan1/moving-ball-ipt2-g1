package com.example.movingball_ipt_group_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MovingBallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView ball = findViewById(R.id.ball);
        final SeekBar seekBarOpacity = findViewById(R.id.seekbar);
        final Button up = findViewById(R.id.upButton);
        final Button down = findViewById(R.id.downButton);
        final Button left = findViewById(R.id.leftButton);
        final Button right = findViewById(R.id.rightButton);
        final Button reset = findViewById(R.id.resetButton);
        final Button color = findViewById(R.id.colorButton);
        final TextView coordinates = findViewById(R.id.coordinatesTextView);
        ConstraintLayout.LayoutParams layoutParameters = (ConstraintLayout.LayoutParams) ball.getLayoutParams();
        coordinates.setText("X: " + ball.getX() + " Y: " + ball.getY());
        up.setOnClickListener(v -> {
            float yPos = ball.getY();
            ball.setY(yPos - 10);
            coordinates.setText("X: " + ball.getX() + " Y: " + ball.getY());
        });

        down.setOnClickListener(v -> {
            float yPos = ball.getY();
            ball.setY(yPos + 10);
            coordinates.setText("X: " + ball.getX() + " Y: " + ball.getY());
        });

        left.setOnClickListener(v -> {
            float xPos = ball.getX();
            ball.setX(xPos - 10);
            coordinates.setText("X: " + ball.getX() + " Y: " + ball.getY());
        });

        right.setOnClickListener(v -> {
            float xPos = ball.getX();
            ball.setX(xPos + 10);
            coordinates.setText("X: " + ball.getX() + " Y: " + ball.getY());
        });

        reset.setOnClickListener(v -> {
            float centerX = ball.getWidth() / 0.13f;
            float centerY = ball.getHeight() / 0.08f;
            ball.setX(coordinates.getLeft() + centerX);
            ball.setY(coordinates.getTop() + centerY);
            coordinates.setText("X: " + ball.getX() + " Y: " + ball.getY());
        });

        seekBarOpacity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ball.setAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        color.setOnClickListener(v -> {
            // color changing function goes here
        });


    }
}
