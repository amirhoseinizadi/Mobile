package com.example.nameamir;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText nameEditText = findViewById(R.id.nameEditText);
        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> {
            String userName = nameEditText.getText().toString();
            
            if (userName.isEmpty()) {
                showToast("Please enter your name");
            } else {
                showToast("Welcome, " + userName + "!");
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
