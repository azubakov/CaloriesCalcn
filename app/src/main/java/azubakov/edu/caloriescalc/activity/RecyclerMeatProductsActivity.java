package azubakov.edu.caloriescalc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import azubakov.edu.caloriescalc.adapters.MeatProductsRecyclerAdapter;
import azubakov.edu.caloriescalc.adapters.MilkProductsRecyclerAdapter;
import azubakov.edu.caloriescalc.dialogs.AddMeatProductsDialogFragment;
import azubakov.edu.caloriescalc.dialogs.AddMilkProductsDialogFragment;

public class RecyclerMeatProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_meat_products);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
/*        fab.setOnClickListener(new View.OnClickListener() {
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
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.meatproductsRecycler);

        //Get a reference to our table:
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String uid = currentUser.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("MeatProducts").child(uid);

        //init a new instance of the adapter
        MeatProductsRecyclerAdapter adapter = new MeatProductsRecyclerAdapter(ref);

        //set the adapter on the recyclerView
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void addMessages(View view) {
        AddMeatProductsDialogFragment fragment =
                new AddMeatProductsDialogFragment();

        fragment.show(
                getSupportFragmentManager(),
                "AddMeatProductDialog"
        );
    }

    public void backDrNav(View view) {
        Intent intent = new Intent(this, CalorieNavDrawerActivity.class);
        startActivity(intent);
    }
}
