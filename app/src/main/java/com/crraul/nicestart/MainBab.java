package com.crraul.nicestart;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainBab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_bab);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);
        FloatingActionButton myfab = findViewById(R.id.fab);

        myfab.setOnClickListener(v -> {
            Toast.makeText(this, "FAB Clicked", Toast.LENGTH_SHORT).show();
        });

        bottomAppBar.setNavigationOnClickListener(v -> {
            Toast.makeText(this, "Menu clicked", Toast.LENGTH_SHORT).show();
        });

        bottomAppBar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.heart) {
                Toast.makeText(this, "Added to favourite", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.search) {
                Toast.makeText(this, "Beginning search", Toast.LENGTH_SHORT).show();
            }

            return false;
        });
    }
}