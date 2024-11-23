package com.crraul.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;


public class Main extends AppCompatActivity {
    private WebView miVisorWeb;
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        WebView mycontext = findViewById(R.id.vistaweb);
        // contextMenu shows when holding webview
        registerForContextMenu(mycontext);

        // gets reference to swipeRefreshLayout
        swipeLayout = findViewById(R.id.myswipe);
        // adds listener
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        // get reference and establish settings for webView
        miVisorWeb = findViewById(R.id.vistaweb);
        WebSettings webSettings = miVisorWeb.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com");


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // creates the context menu (depends on the place)
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context, menu);
    }

    // manages item selection of a context menu
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId(); // gets item id

        // checks which option has been selected
        if (id == R.id.item1) {
            Toast.makeText(this, "Copy", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item2) {
            Toast.makeText(this, "Download", Toast.LENGTH_SHORT).show();
        }

        return super.onContextItemSelected(item);
    }

//    assigns the menu to the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar, menu);
        return true;
    }

    // manages item selection of an options menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId(); // gets item id

        // checks which option has been selected
        if (id == R.id.item1) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();

            final ConstraintLayout layout = findViewById(R.id.main);

            Snackbar snackbar = Snackbar.make(layout, "Has pulsado Settings", Snackbar.LENGTH_SHORT)
                            .setAction("UNDO", view -> {
                                Snackbar snackbar1 = Snackbar.make(layout, "Action is restored", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            });
            snackbar.show();

        } else if (id == R.id.item2) {
            showAlertDialogButtonClicked(this);
        }

        return super.onOptionsItemSelected(item);
    }

    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

            final ConstraintLayout layout = findViewById(R.id.main);

            Snackbar snackbar = Snackbar.make(layout, "Fancy a snack while you refresh?", Snackbar.LENGTH_SHORT);
            snackbar.show();

            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };

    public void showAlertDialogButtonClicked(Main mainActivity) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

        builder.setTitle("Achtung!");
        builder.setMessage("Where do you go?");
        builder.setIcon(R.drawable.user);
        builder.setCancelable(true);

        // sends to profile activity
        builder.setPositiveButton("Go to profile", (dialogInterface, i) -> {
            Toast.makeText(mainActivity, "Sending to profile", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mainActivity, Profile.class);
            startActivity(intent);

            dialogInterface.dismiss();
        });

        // does nothing
        builder.setNegativeButton("Do absolutely nothing", (dialogInterface, i) -> dialogInterface.dismiss());

        // closes
        builder.setNeutralButton("Other", (dialogInterface, i) -> {
            System.exit(0);
            dialogInterface.dismiss();
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}