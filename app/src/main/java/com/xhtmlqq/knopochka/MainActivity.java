package com.xhtmlqq.knopochka;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Integer counter = 0;
    private View color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter", 0);
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        Toast.makeText(this, "onStart()", Toast.LENGTH_LONG).show();
    }

    public void onClick(View view) {
        counter++;
        color = findViewById(R.id.main);
        if (counter <= 10) {
            color.setBackgroundColor(Color.rgb(10, 0, 0));
        } else if (counter <= 20) {
            color.setBackgroundColor(Color.rgb(0, 20, 0));
        } else if (counter <= 30) {
            color.setBackgroundColor(Color.rgb(0, 0, 30));
        }
        TextView onClickText = findViewById(R.id.textView2);
        onClickText.setText("Вы накликали: " + counter.toString() + " коробок");
    }

    public void onChangeColor(View view) {
        color = findViewById(R.id.main);
        Button changeColor = findViewById(R.id.button2);
        changeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color.setBackgroundResource(R.color.purple);
            }
        });

    }

    public void restoreWhiteBackground(View view) {
        color = findViewById(R.id.main);
        Button restore = findViewById(R.id.button3);
        restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color.setBackgroundColor(Color.WHITE);
            }
        });
    }

}