package azubakov.edu.caloriescalc.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.adapters.InfoBodyListItemsAdapter;

public class RecyclerInfoBodyActivity extends AppCompatActivity {

    private String pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_info_body);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        RecyclerView rvInfoBodyItems = (RecyclerView) findViewById(R.id.InfoBodyRecycler);
        //rvInfoBodyItems.setLayoutManager(new LinearLayoutManager(this));
        ///rvShoppingListItems.setLayoutManager(new LinearLayoutManager(this));

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String uid = currentUser.getUid();
//        pid = getIntent().getStringExtra(CalorieContract.EXTRA_PID);

        //DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Body").child(pid);

        //DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Todos").child(uid);
        //DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Body").child(uid);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Body").child(uid);
        InfoBodyListItemsAdapter adapter = new InfoBodyListItemsAdapter(ref);

        ////rvInfoBodyItems.setLayoutManager(new LinearLayoutManager(this));
        rvInfoBodyItems.setAdapter(adapter);
        rvInfoBodyItems.setLayoutManager(new LinearLayoutManager(this));
        //rvInfoBodyItems.setLayoutManager(new LinearLayoutManager(this));


        //getRef().child("infobodyListItems").child(pid);
        /*DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("userLists").child(uid);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users");*/


    }

}
