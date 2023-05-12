package com.example.module3projectscompilation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class task2 extends AppCompatActivity {

    private TextView coordinates;
    private String sDown;
    private String sMove;
    private String sUp;

    public task2() {
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task2);
        coordinates = findViewById(R.id.field);
        coordinates.setOnTouchListener(listener);
    }
    View.OnTouchListener listener = new View.OnTouchListener() {
        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();

            int xCat = 500;
            int yCat = 500;
            int deltaCat = 50;
            switch (motionEvent.getAction()){
                case MotionEvent.ACTION_DOWN:
                    sDown = "Нажата координата X " + x + " Нажата координата У " + y;
                    sMove = "";
                    sUp = "";
                    break;
                case MotionEvent.ACTION_MOVE:
                    sMove = "Движение: координата X " + x + " Y " + y;
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    sUp = "Отпускание координата x " + x + " y " + y;
                    sMove = "";
                    if (x < (xCat + deltaCat) && x > (xCat - deltaCat) && y < (yCat + deltaCat) && y > (yCat - deltaCat)){
                        Toast toast = Toast.makeText(getApplicationContext(), R.string.success, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.LEFT, xCat, yCat);
                        LinearLayout toastContainer = (LinearLayout) toast.getView();
                        ImageView cat = new ImageView(getApplicationContext());
                        cat.setImageResource(R.drawable.cat);
                        toastContainer.addView(cat, 1);
                        toast.show();
                    }
                    break;
            }
            coordinates.setText(sDown + "\n" + sMove + "\n" + sUp);
            return true;
        }
    };
}
