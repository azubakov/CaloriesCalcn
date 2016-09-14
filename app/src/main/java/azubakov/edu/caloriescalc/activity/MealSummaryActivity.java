package azubakov.edu.caloriescalc.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;


import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.dialogs.MealSummaryFragment;
import azubakov.edu.caloriescalc.models.Body;
import azubakov.edu.caloriescalc.models.DaySumCalories;
import azubakov.edu.caloriescalc.models.MealSummary;

public class MealSummaryActivity extends AppCompatActivity {

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
    Double Sumdayproteinsbreakfast, Sumdayproteinslunch, Sumdayproteinsdinner, Sumdayproteinssnakes;
    Double Sumdayfatsbreakfast, Sumdayfatslunch, Sumdayfatsdinner, Sumdayfatssnakes;
    Double Sumdaycarbohydratesbreakfast, Sumdaycarbohydrateslunch, Sumdaycarbohydratesdinner, Sumdaycarbohydratessnakes;
    //Double Sumdayproteins, Sumdayfats, Sumdaycarbohydrates;
    Integer Countbreakfast, Countlunch, Countdinner, Countsnakes, Countacts;
    TextView tvSumDayRealProteins, tvSumDayRealFats, tvSumDayRealCarbohydrates;
    Double  Sumbreakfast,Sumlunch,Sumdinner, Sumsnakes, Sumacts, Sumdayminacts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_summary);
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

        tvSumDayRealProteins = (TextView) findViewById(R.id.tvSumDayRealProteins);
        tvSumDayRealFats = (TextView) findViewById(R.id.tvSumDayRealFats);
        tvSumDayRealCarbohydrates = (TextView) findViewById(R.id.tvSumDayRealCarbohydrates);

        final Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+3"));
        int yy = c.get(Calendar.YEAR);
        int mm = c.get(Calendar.MONTH);
        int dd = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR);
        int min = c.get(Calendar.MINUTE);
        int sec = c.get(Calendar.SECOND);

        /*Date = dd + "." + (mm + 1) + "." + yy;
        tvRealDate.setText(Date.toString());
        tvRealDate1.setText(Date.toString());*/
        Date = dd + "." + (mm + 1) + "." + yy + " " + hour + ":" + min + ":" + sec;
        tvRealDate.setText(Date.toString());
        tvRealDate1.setText(Date.toString());



        MealSummaryFragment f = MealSummaryFragment.newInstance("breakfast");
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.containerSummaryBreakfast, f).
                commit();

        MealSummaryFragment f2 = MealSummaryFragment.newInstance("lunch");
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.containerSummaryLaunch, f2).
                commit();

        MealSummaryFragment f3 = MealSummaryFragment.newInstance("dinner");
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.containerSummaryDinner, f3).
                commit();


        MealSummaryFragment f4 = MealSummaryFragment.newInstance("snakes");
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.containerSummarySnacks, f4).
                commit();

        MealSummaryFragment f5 = MealSummaryFragment.newInstance("acts");
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
                //BlogPost newPost = snapshot.getValue(BlogPost.class);
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

            private void dismiss() {
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

    ArrayList<MealSummary> summaries = new ArrayList<>();

    public void addMealSummary(MealSummary summary) {
        
        summaries.add(summary);
        //Toast.makeText(MealSummaryActivity.this, summary.toString(), Toast.LENGTH_SHORT).show();
        if (summaries.size() == 5) {
            //Finished getting data.
            //calculate total sum...

            for (MealSummary s : summaries) {
             //   Toast.makeText(MealSummaryActivity.this, ""+ s.getSumCalories(), Toast.LENGTH_SHORT).show();
             //   Toast.makeText(MealSummaryActivity.this, ""+ s.getSumGrams(), Toast.LENGTH_SHORT).show();
                if (s.getCategoryName().equals("breakfast"))
                {
                    Sumdaybreakfast = s.getSumCalories();
                    Sumdaygrammbreakfast = s.getSumGrams();
                    Sumdayproteinsbreakfast = s.getSumProteins();
                    Sumdayfatsbreakfast = s.getSumFats();
                    Sumdaycarbohydratesbreakfast = s.getSumCarbohydrates();
                    Countbreakfast = s.getCount(); 
                }

                if (s.getCategoryName().equals("lunch"))
                {
                    Sumdaylunch = s.getSumCalories();
                    Sumdaygrammlunch = s.getSumGrams();
                    Sumdayproteinslunch = s.getSumProteins();
                    Sumdayfatslunch = s.getSumFats();
                    Sumdaycarbohydrateslunch = s.getSumCarbohydrates();
                    Countlunch = s.getCount();
                }
                
                if (s.getCategoryName().equals("dinner"))
                {
                    Sumdaydinner = s.getSumCalories();
                    Sumdaygrammdinner = s.getSumGrams();
                    Sumdayproteinsdinner = s.getSumProteins();
                    Sumdayfatsdinner = s.getSumFats();
                    Sumdaycarbohydratesdinner = s.getSumCarbohydrates();
                    Countdinner = s.getCount();
                }

                if (s.getCategoryName().equals("snakes"))
                {
                    Sumdaysnakes = s.getSumCalories();
                    Sumdaygrammsnakes = s.getSumGrams();
                    Sumdayproteinssnakes = s.getSumProteins();
                    Sumdayfatssnakes = s.getSumFats();
                    Sumdaycarbohydratessnakes = s.getSumCarbohydrates();
                    Countsnakes = s.getCount();
                }

                if (s.getCategoryName().equals("acts"))
                {
                    Sumdayacts = s.getSumActs();
                    Sumdayminacts = s.getSumMinActs();
                    Countacts = s.getCount();
                }
                
            }
            //double Sumbreakfast = MealSummaryFragment.SumDayBreakfast * MealSummaryFragment.SumDayBreakfastGrams / (MealSummaryFragment.CountBreakfast * 100);
            ////double Sumbreakfast = Sumdaybreakfast * Sumdaygrammbreakfast / (Countbreakfast * 100);
            if (Sumdaybreakfast == 0.0 || Sumdaygrammbreakfast == 0.0 || Countbreakfast == 0)
                Sumbreakfast = 0D;
            else
                Sumbreakfast = Sumdaybreakfast * Sumdaygrammbreakfast / (Countbreakfast * 100);
            //double Sumlunch = MealSummaryFragment.SumDayLunch * MealSummaryFragment.SumDayLunchGrams / (MealSummaryFragment.CountLunch * 100);
            ////double Sumlunch = Sumdaylunch * Sumdaygrammlunch / (Countlunch * 100);
            if (Sumdaylunch == 0.0 || Sumdaygrammlunch == 0.0 || Countlunch == 0)
                Sumlunch = 0D;
            else
                Sumlunch = Sumdaylunch * Sumdaygrammlunch / (Countlunch * 100);
            //double Sumdinner = MealSummaryFragment.SumDayDinner * MealSummaryFragment.SumDayDinnerGrams / (MealSummaryFragment.CountDinner * 100);
            ////double Sumdinner = Sumdaydinner * Sumdaygrammdinner / (Countdinner * 100);
            if (Sumdaydinner == 0.0 || Sumdaygrammdinner == 0.0 || Countdinner == 0)
                Sumdinner = 0D;
            else
                Sumdinner = Sumdaydinner * Sumdaygrammdinner / (Countdinner * 100);
            //double Sumsnakes = MealSummaryFragment.SumDaySnakes * MealSummaryFragment.SumDaySnakesGrams / (MealSummaryFragment.CountSnakes * 100);
            ////double Sumsnakes = Sumdaysnakes * Sumdaygrammsnakes / (MealSummaryFragment.CountSnakes * 100);
            if (Sumdaysnakes == 0.0 || Sumdaygrammsnakes == 0.0 || Countsnakes == 0)
                Sumsnakes = 0D;
            else
                Sumsnakes = Sumdaysnakes * Sumdaygrammsnakes / (Countsnakes * 100);
            //double Sumacts = MealSummaryFragment.SumDayActs * MealSummaryFragment.SumDayActsMinuts / (MealSummaryFragment.CountActs * 60);
            ////Sumacts = Sumdayacts * Sumdayminacts / (Countacts * 60);
            if (Sumdayacts == 0.0 || Sumdayminacts == 0.0 || Countacts == 0)
                Sumacts = 0D;
            else
                Sumacts = Sumdayacts * Sumdayminacts / (Countacts * 60);



            double Sumdayproteins = Sumdayproteinsbreakfast + Sumdayproteinslunch + Sumdayproteinsdinner + Sumdayproteinssnakes;
            double Sumdayfats = Sumdayfatsbreakfast + Sumdayfatslunch + Sumdayfatsdinner + Sumdayfatssnakes;
            double Sumdaycarbohydrates = Sumdaycarbohydratesbreakfast + Sumdaycarbohydrateslunch + Sumdaycarbohydratesdinner + Sumdaycarbohydratessnakes;

            double SumDayCal = Sumbreakfast + Sumlunch + Sumdinner + Sumsnakes - Sumacts;


            tvSumDayRealProteins.setText(Double.valueOf(Sumdayproteins).toString());
            tvSumDayRealFats.setText(Double.valueOf(Sumdayfats).toString());
            tvSumDayRealCarbohydrates.setText(Double.valueOf(Sumdaycarbohydrates).toString());
            tvCalSumDayCal.setText(Double.valueOf(SumDayCal).toString());

            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();


            String uid1 = currentUser.getUid();
            //DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Weight").child(uid);
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Dairy").child(uid1);


            /* DaySumCalories dairy = new DaySumCalories(Date, Sumdaybreakfast, Sumdaylunch,
                    Sumdaydinner, Sumdaysnakes, Sumdayacts, SumDayCal);*/
            DaySumCalories dairy = new DaySumCalories(Date, Sumdaybreakfast, Sumdaylunch,
                    Sumdaydinner, Sumdaysnakes, Sumdayacts, Sumdayproteins, Sumdayfats, Sumdaycarbohydrates, SumDayCal);


                ref.push().setValue(dairy);
                dismiss();
       }
    }

    private void dismiss() {
    }
}