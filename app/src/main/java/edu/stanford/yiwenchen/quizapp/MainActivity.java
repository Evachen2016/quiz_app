package edu.stanford.yiwenchen.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int left;
    private int right;
    private int totalPoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalPoints = 0;
        generateNumbers();
        updatePoints();
    }

    private void generateNumbers(){
        Random ran = new Random();
        left = ran.nextInt(10);
        right = ran.nextInt(10);
        Button leftButton = (Button) findViewById(R.id.left_button);
        Button rightButton = (Button) findViewById(R.id.right_button);
        leftButton.setText(Integer.toString(left));
        rightButton.setText(Integer.toString(right));
    }

    private void updatePoints(){
        TextView points = (TextView) findViewById(R.id.points);
        points.setText(Integer.toString(totalPoints));
    }

    public void leftClick(View view) {
        if (left > right) {
            totalPoints += 10;
        } else {
            totalPoints -= 10;
        }
        generateNumbers();
        updatePoints();
    }

    public void rightClick(View view) {
        if (left > right) {
            totalPoints -= 10;
        } else {
            totalPoints += 10;
        }
        generateNumbers();
        updatePoints();
    }
}
