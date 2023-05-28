package com.example.android_tut_19_sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private TextView usernameTextView;
    private TextView ageTextView;
    private EditText usernameEditText,ageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Step 2: Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Step 6: Get references to XML elements
        usernameTextView = findViewById(R.id.usernameTextView);
        ageTextView = findViewById(R.id.ageTextView);

        // Step 3: Writing data to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //In the line editor.putString("username", "John");
        //, "username" is the key and "John" is the value being stored in SharedPreferences.
        editor.putString("username", "John");
        editor.putInt("age", 25);
        editor.apply();

        // Step 7: Displaying SharedPreferences data in XML Layout
        String username = sharedPreferences.getString("username", "default");
        int age = sharedPreferences.getInt("age", 0);
        usernameTextView.setText(username);
        ageTextView.setText(String.valueOf(age));
    }
}
