package com.example.movingball_ipt_group_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;
import android.graphics.PorterDuff;
import android.app.AlertDialog;
import android.widget.ImageView;
import android.content.DialogInterface;
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
        final Button colorButton = findViewById(R.id.colorButton);
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



        colorButton.setOnClickListener(v -> {
            final String[] colors = {"Magenta", "Red", "Green", "Blue", "Yellow"};

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select Color");
            builder.setItems(colors, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    applyColor(colors[which]);
                }

                private void applyColor(String selectedColor) {
                    int colorResId = R.color.defaultColor;

                    switch (selectedColor) {
                        case "Magenta":
                            colorResId = R.color.magentaColor;
                            break;
                        case "Red":
                            colorResId = R.color.redColor;
                            break;
                        case "Green":
                            colorResId = R.color.greenColor;
                            break;
                        case "Blue":
                            colorResId = R.color.blueColor;
                            break;
                        case "Yellow":
                            colorResId = R.color.yellowColor;
                            break;
                    }

                    int color = getResources().getColor(colorResId); // Get the actual color value
                    ball.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                }
            });
            builder.show();
        });
    }


}