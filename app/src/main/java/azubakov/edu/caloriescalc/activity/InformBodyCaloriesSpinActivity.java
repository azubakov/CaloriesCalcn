package azubakov.edu.caloriescalc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.adapters.ActivitySpinAdapter;
import azubakov.edu.caloriescalc.adapters.AgeSpinAdapter;
import azubakov.edu.caloriescalc.adapters.GenderSpinAdapter;
import azubakov.edu.caloriescalc.adapters.HeightSpinAdapter;
import azubakov.edu.caloriescalc.adapters.WeightSpinAdapter;
import azubakov.edu.caloriescalc.adapters.WeightSpinAdapterGrammes;
import azubakov.edu.caloriescalc.models.ActivitySpin;
import azubakov.edu.caloriescalc.models.AgeSpin;
import azubakov.edu.caloriescalc.models.Gender;
import azubakov.edu.caloriescalc.models.HeightSpin;
import azubakov.edu.caloriescalc.models.Weight;
import azubakov.edu.caloriescalc.models.WeightSpin;

public class InformBodyCaloriesSpinActivity extends AppCompatActivity {

    TextView tvDate, tvGender, tvWeight, tvAge, tvHeight, tvActivity;
    //EditText etDate;
    TextView etDate;
    Spinner GenderSpinner, WeightSpinner, WeightGrammSpinner, AgeSpinner, HeightSpinner, ActivitySpinner;
    String Date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inform_body_calories_spin);
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

        tvDate = (TextView) findViewById(R.id.tvDate);
        tvGender = (TextView) findViewById(R.id.tvGender);
        tvWeight = (TextView) findViewById(R.id.tvWeight);
        tvAge = (TextView) findViewById(R.id.tvAge);
        tvHeight = (TextView) findViewById(R.id.tvHeight);
        tvActivity = (TextView) findViewById(R.id.tvDate);
        //etDate = (EditText) findViewById(R.id.etDate);
        etDate = (TextView) findViewById(R.id.etDate);
        GenderSpinner = (Spinner) findViewById(R.id.GenderSpinner);
        WeightSpinner = (Spinner) findViewById(R.id.WeightSpinner);
        WeightGrammSpinner = (Spinner) findViewById(R.id.WeightGrammSpinner);
        AgeSpinner = (Spinner) findViewById(R.id.AgeSpinner);
        HeightSpinner = (Spinner) findViewById(R.id.HeightSpinner);
        ActivitySpinner = (Spinner) findViewById(R.id.ActivitySpinner);



        Spinner spinnergender = (Spinner) findViewById(R.id.GenderSpinner);
        GenderSpinAdapter adaptergender = new GenderSpinAdapter(this);
        spinnergender.setAdapter(adaptergender);
        spinnergender.setOnItemSelectedListener(adaptergender);

        Spinner spinnerweight = (Spinner) findViewById(R.id.WeightSpinner);
        WeightSpinAdapter adapterweight = new WeightSpinAdapter(this);
        spinnerweight.setAdapter(adapterweight);
        spinnerweight.setOnItemSelectedListener(adapterweight);


        Spinner spinnerweightgramm = (Spinner) findViewById(R.id.WeightGrammSpinner);
        WeightSpinAdapterGrammes adapterweightgramm = new WeightSpinAdapterGrammes(this);
        spinnerweightgramm.setAdapter(adapterweightgramm);
        spinnerweightgramm.setOnItemSelectedListener(adapterweight);

        Spinner spinnerage = (Spinner) findViewById(R.id.AgeSpinner);
        AgeSpinAdapter adapterage = new AgeSpinAdapter(this);
        spinnerage.setAdapter(adapterage);
        spinnerage.setOnItemSelectedListener(adapterweight);



        Spinner spinnerheight = (Spinner) findViewById(R.id.HeightSpinner);
        HeightSpinAdapter adapterheight = new HeightSpinAdapter(this);
        spinnerheight.setAdapter(adapterheight);
        spinnerheight.setOnItemSelectedListener(adapterweight);

        Spinner spinneractivity = (Spinner) findViewById(R.id.ActivitySpinner);
        ActivitySpinAdapter adapteractivity = new ActivitySpinAdapter(this);
        spinneractivity.setAdapter(adapteractivity);
        spinnerheight.setOnItemSelectedListener(adapterweight);

        //String date = etDate.getText().toString();
        //Toast.makeText(InformBodyCaloriesSpinActivity.this, "From InformBodyCaloriesSpinActivity"+ date, Toast.LENGTH_SHORT).show();
        /*Intent intent = new Intent(this, ResultInfoBodyActivity.class);
        //intent.putExtra("date", etDate.getText().toString());
        intent.putExtra("date", date);
        startActivity(intent);*/


        final Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+3"));
        int yy = c.get(Calendar.YEAR);
        int mm = c.get(Calendar.MONTH);
        int dd = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR);
        int min = c.get(Calendar.MINUTE);
        int sec = c.get(Calendar.SECOND);

        Date = dd + "." + (mm + 1) + "." + yy + " " + hour + ":" + min + ":" + sec;
        etDate.setText(Date.toString());


    }

    public void gotoResult(View view) {


        String date = etDate.getText().toString();
        Gender gender = (Gender) GenderSpinner.getSelectedItem();
//        String weight = WeightSpinner.getSelectedItem().toString();
        WeightSpin weight = (WeightSpin) WeightSpinner.getSelectedItem();
//        String age = AgeSpinner.getSelectedItem().toString();
        AgeSpin age = (AgeSpin) AgeSpinner.getSelectedItem();
//        String height = HeightSpinner.getSelectedItem().toString();
        HeightSpin height = (HeightSpin) HeightSpinner.getSelectedItem();
//        String activity = ActivitySpinner.getSelectedItem().toString();
        ActivitySpin activity = (ActivitySpin) ActivitySpinner.getSelectedItem();
/*        Toast.makeText(InformBodyCaloriesSpinActivity.this, "From InformBodyCaloriesSpinActivity date is:"+ date, Toast.LENGTH_SHORT).show();
        Toast.makeText(InformBodyCaloriesSpinActivity.this, "From InformBodyCaloriesSpinActivity gender is:"+ gender, Toast.LENGTH_SHORT).show();
        Toast.makeText(InformBodyCaloriesSpinActivity.this, "From InformBodyCaloriesSpinActivity weight is:"+ weight, Toast.LENGTH_SHORT).show();
        Toast.makeText(InformBodyCaloriesSpinActivity.this, "From InformBodyCaloriesSpinActivity age is:"+ age, Toast.LENGTH_SHORT).show();
        Toast.makeText(InformBodyCaloriesSpinActivity.this, "From InformBodyCaloriesSpinActivity height is:"+ height, Toast.LENGTH_SHORT).show();
        Toast.makeText(InformBodyCaloriesSpinActivity.this, "From InformBodyCaloriesSpinActivity activity is:"+ activity, Toast.LENGTH_SHORT).show();*/
       Intent intent = new Intent(this, ResultInfoBodyActivity.class);
        intent.putExtra("date", date);
        intent.putExtra("gender", gender.getGenderName());
        //intent.putExtra("weight", weight);
        intent.putExtra("weight", weight.getWeightName());
        //intent.putExtra("age", age);
        intent.putExtra("age", age.getAge());
        //intent.putExtra("height", height);
        intent.putExtra("height", height.getHeight());
        //intent.putExtra("activity", activity);
        intent.putExtra("activity", activity.getActivityName());
        startActivity(intent);
        /*Intent intent = new Intent(this, ResultInfoBodyActivity.class);
        intent.putExtra("date", etDate.getText().toString());
        intent.putExtra("gender", etGender.getText().toString());
        intent.putExtra("weight", etWeight.getText().toString());
        intent.putExtra("age", etAge.getText().toString());
        intent.putExtra("height", etHeight.getText().toString());
        intent.putExtra("activity", etActivity.getText().toString());
        startActivity(intent);*/


    }
}
