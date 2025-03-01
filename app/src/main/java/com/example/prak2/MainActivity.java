package com.example.prak2;
import com.example.prak2.R;


import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.util.Log;



public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate вызван");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart вызван");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume вызван");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause вызван");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop вызван");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy вызван");
    }


    public void openSecondActivity(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    public void onNextActivity(View view) {
        EditText editName = findViewById(R.id.edit_name);
        EditText editGroup = findViewById(R.id.edit_group);
        EditText editAge = findViewById(R.id.edit_age);
        EditText editMark = findViewById(R.id.edit_mark);

        String name = editName.getText().toString();
        String group = editGroup.getText().toString();
        int age = Integer.parseInt(editAge.getText().toString());
        int mark = Integer.parseInt(editMark.getText().toString());

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("group", group);
        intent.putExtra("age", age);
        intent.putExtra("mark", mark);
        startActivity(intent);
    }

}