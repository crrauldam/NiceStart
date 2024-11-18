package com.crraul.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        openApp();

        // objeto sobre el que se aplicara la animacion
        ImageView logoLightBeam = findViewById(R.id.logoFront);
        TextView slogan = findViewById(R.id.slogan);

        // objeto animacion que incorpora la animacion descrita en el xml y con el metodo
        // startAnimation lo aplicaremos al ImageView del logo

        Animation sloganAnim = AnimationUtils.loadAnimation(this, R.anim.slogan_appear);
        slogan.startAnimation(sloganAnim);

        Animation logoAnim = AnimationUtils.loadAnimation(this, R.anim.logo_move);
        logoLightBeam.startAnimation(logoAnim);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void openApp() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 2000);
    }
}