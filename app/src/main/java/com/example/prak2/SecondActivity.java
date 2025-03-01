package com.example.prak2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView textView = findViewById(R.id.text_result);

        String name = getIntent().getStringExtra("name");
        String group = getIntent().getStringExtra("group");
        int age = getIntent().getIntExtra("age", 0);
        int mark = getIntent().getIntExtra("mark", 0);

        textView.setText("ФИО: " + name + "\nГруппа: " + group +
                "\nВозраст: " + age + "\nОценка: " + mark);

    }
    public void goBack(View view) {
        onBackPressed();
    }
}