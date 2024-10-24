package com.crraul.nicestart;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageView pfp;

        pfp = findViewById(R.id.pfp);

        Glide.with(this)
                .load("https://static.wikia.nocookie.net/megamitensei/images/a/a5/P3RE_Portrait_Akihiko.png/revision/latest/scale-to-width-down/1000?cb=20240410011711")
//                .load(R.drawable.p3re_foto)
                .transition(DrawableTransitionOptions.withCrossFade(500))
//                .centerCrop()
                .circleCrop()
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.emerald)))
                .into(pfp);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}