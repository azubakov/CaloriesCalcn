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
import azubakov.edu.caloriescalc.adapters.BreadProductsRecyclerAdapter;
import azubakov.edu.caloriescalc.adapters.MeatProductsRecyclerAdapter;
import azubakov.edu.caloriescalc.dialogs.AddBreadProductsDialogFragment;
import azubakov.edu.caloriescalc.dialogs.AddMeatProductsDialogFragment;

public class RecyclerBreadProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_bread_products);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        initRecycler();
    }

    private void initRecycler() {
        //find View By Id:
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.breadproductsRecycler);

        //Get a reference to our table:
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String uid = currentUser.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("BreadProducts").child(uid);

        //init a new instance of the adapter
        BreadProductsRecyclerAdapter adapter = new BreadProductsRecyclerAdapter(ref);

        //set the adapter on the recyclerView
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    public void addMessages(View view) {
        AddBreadProductsDialogFragment fragment =
                new AddBreadProductsDialogFragment();

        fragment.show(
                getSupportFragmentManager(),
                "AddBreadProductDialog"
        );
    }

    public void backDrNav(View view) {
        Intent intent = new Intent(this, CalorieNavDrawerActivity.class);
        startActivity(intent);
    }

}
