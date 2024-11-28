package com.crraul.nicestart;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// lo del glide
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void showAlertDialogButtonClicked(Login mainActivity) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

        builder.setTitle("Forgot Password?");
        builder.setIcon(R.drawable.key);
        builder.setCancelable(true);

        // sends to profile activity
        builder.setPositiveButton("Reset Password", (dialogInterface, i) -> {
            final ConstraintLayout layout = findViewById(R.id.main);

            Snackbar snackbar = Snackbar.make(layout, "We've sent a password reset link to your email. " +
                                                            "Please check your inbox and follow the instructions.",
                                                            Snackbar.LENGTH_SHORT);
//                    .setAction("UNDO", view -> {
//                        Snackbar snackbar1 = Snackbar.make(layout, "Action is restored", Snackbar.LENGTH_SHORT);
//                        snackbar1.show();
//                    });
            snackbar.show();

            dialogInterface.dismiss();
        });

        // does nothing
        builder.setNegativeButton("Return Login", (dialogInterface, i) -> dialogInterface.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void forgotPassword(View v) {
        showAlertDialogButtonClicked(this);
    }

    public void openSignup(View v) {
        Intent intent = new Intent(Login.this, Signup.class);
        startActivity(intent);
    }

    public void goToMain(View v) {
        Intent intent = new Intent(Login.this, Main.class);
        startActivity(intent);
    }
}