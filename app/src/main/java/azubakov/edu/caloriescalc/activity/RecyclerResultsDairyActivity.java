package azubakov.edu.caloriescalc.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.adapters.ResultsDairyRecyclerAdapter;
import azubakov.edu.caloriescalc.dialogs.AddResultsDairyDialogFragment;

public class RecyclerResultsDairyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_results_dairy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

  /*      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        initRecycler();
    }

    private void initRecycler() {
        //find View By Id:
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.resultsDairyRecycler);

        //Get a reference to our table:
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String uid = currentUser.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Dairy").child(uid);

        //init a new instance of the adapter
        ResultsDairyRecyclerAdapter adapter = new ResultsDairyRecyclerAdapter(ref);

        //set the adapter on the recyclerView
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void addMessages(View view) {

        AddResultsDairyDialogFragment fragment =
                new AddResultsDairyDialogFragment();

        fragment.show(
                getSupportFragmentManager(),
                "AddResultsDairyDialog"
        );
    }

}
