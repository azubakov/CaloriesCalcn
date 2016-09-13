package azubakov.edu.caloriescalc.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.TimeZone;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.dialogs.ActsItemFragment;
import azubakov.edu.caloriescalc.dialogs.MealItemFragment;
import azubakov.edu.caloriescalc.models.Body;

public class MealSummaryRecyclerActivity extends AppCompatActivity {

    TextView tvCalSumDayCal;
    TextView tvSumRecomendCal;
    TextView tvSumRecomendExtraCal;
    TextView tvRealDate;
    TextView tvRealDate1;
    FrameLayout containerSummaryBreakfast;
    FrameLayout containerSummaryDinner;
    FrameLayout containerSummaryLaunch;
    FrameLayout containerSummarySnacks;
    FrameLayout containerSummaryActivity;
    Double SumDayCal;
    String Date;
    Double Sumdaybreakfast, Sumdaylunch, Sumdaydinner, Sumdaysnakes, Sumdayacts;
    Double Sumdaygrammbreakfast, Sumdaygrammlunch, Sumdaygrammdinner, Sumdaygrammsnakes, Sumdaygrammacts;
    Integer Countbreakfast, Countlunch, Countdinner, Countsnakes, Countacts;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_summary_recycler);
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


        tvCalSumDayCal = (TextView) findViewById(R.id.tvCalSumDayCal);
        tvSumRecomendCal = (TextView) findViewById(R.id.tvSumRecomendCal);
        tvSumRecomendExtraCal = (TextView) findViewById(R.id.tvSumRecomendExtraCal);
        tvRealDate = (TextView) findViewById(R.id.tvRealDate);
        tvRealDate1 = (TextView) findViewById(R.id.tvRealDate1);
        containerSummaryBreakfast = (FrameLayout) findViewById(R.id.containerSummaryBreakfast);
        containerSummaryDinner = (FrameLayout) findViewById(R.id.containerSummaryDinner);
        containerSummaryLaunch = (FrameLayout) findViewById(R.id.containerSummaryLaunch);
        containerSummarySnacks = (FrameLayout) findViewById(R.id.containerSummarySnacks);
        containerSummaryActivity = (FrameLayout) findViewById(R.id.containerSummaryActivity);


        final Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+3"));
        int yy = c.get(Calendar.YEAR);
        int mm = c.get(Calendar.MONTH);
        int dd = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR);
        int min = c.get(Calendar.MINUTE);
        int sec = c.get(Calendar.SECOND);


       /* Date = dd + "." + (mm + 1) + "." + yy;
        tvRealDate.setText(Date.toString());
        tvRealDate1.setText(Date.toString());*/
        Date = dd + "." + (mm + 1) + "." + yy + " " + hour + ":" + min + ":" + sec;
        tvRealDate.setText(Date.toString());
        tvRealDate1.setText(Date.toString());


        /*String category = "breakfast";
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MealItemFragment().newInstance(category)).commit();
        String category1 = "lunch";
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MealItemFragment().newInstance(category1)).commit();
        String category2 = "dinner";
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MealItemFragment().newInstance(category2)).commit();
        String category3 = "snakes";
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MealItemFragment().newInstance(category3)).commit();
        String category4 = "acts";
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ActsItemFragment().newInstance(category4)).commit();*/



        //MealSummaryFragment f = MealSummaryFragment.newInstance("breakfast");
        MealItemFragment f = MealItemFragment.newInstance("breakfast");
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.containerSummaryBreakfast, f).
                commit();

        //MealSummaryFragment f2 = MealSummaryFragment.newInstance("lunch");
        MealItemFragment f2 = MealItemFragment.newInstance("lunch");
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.containerSummaryLaunch, f2).
                commit();

        //MealSummaryFragment f3 = MealSummaryFragment.newInstance("dinner");
        MealItemFragment f3 = MealItemFragment.newInstance("dinner");
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.containerSummaryDinner, f3).
                commit();


        //MealSummaryFragment f4 = MealSummaryFragment.newInstance("snakes");
        MealItemFragment f4 = MealItemFragment.newInstance("snakes");
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.containerSummarySnacks, f4).
                commit();

        //MealSummaryFragment f5 = MealSummaryFragment.newInstance("acts");
        ActsItemFragment f5 = ActsItemFragment.newInstance("acts");
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.containerSummaryActivity, f5).
                commit();


        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        String uid = currentUser.getUid();

        DatabaseReference ref1 = FirebaseDatabase.getInstance().getReference().child("Body").child(uid);

        ref1.addChildEventListener(new ChildEventListener() {



            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Body body = dataSnapshot.getValue(Body.class);


                Double bmi = body.getBmi();
                if (bmi <= 15) {
                    String recomm = "" + body.getFat().toString();
                    tvSumRecomendCal.setText(recomm);
                    String recommExtra = "" + body.getExtrafat().toString();
                    tvSumRecomendExtraCal.setText(recommExtra);
                } else if (bmi > 15 && bmi < 20) {
                    String recomm = "" + body.getFat().toString();
                    tvSumRecomendCal.setText(recomm);
                    String recommExtra = "" + body.getExtrafat().toString();
                    tvSumRecomendExtraCal.setText(recommExtra);
                } else if (bmi > 25 && bmi < 30) {
                    String recomm = "" + body.getSlim().toString();
                    tvSumRecomendCal.setText(recomm);
                    String recommExtra = "" + body.getExtraslim().toString();
                    tvSumRecomendExtraCal.setText(recommExtra);
                } else if (bmi > 30) {
                    String recomm = "" + body.getSlim().toString();
                    tvSumRecomendCal.setText(recomm);
                    String recommExtra = "" + body.getExtraslim().toString();
                    tvSumRecomendExtraCal.setText(recommExtra);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }



}
