package azubakov.edu.caloriescalc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.services.NutritionixService;

public class NutritionixActivity extends AppCompatActivity {

    RecyclerView rvReddits;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritionix);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        rvReddits = (RecyclerView) findViewById(R.id.rvReddits);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Intent intent = getIntent();
        String searching = intent.getStringExtra("stringsearching");
        Toast.makeText(NutritionixActivity.this, "" + searching, Toast.LENGTH_SHORT).show();

        new NutritionixService(rvReddits, progressBar, searching).execute();



    }

}
