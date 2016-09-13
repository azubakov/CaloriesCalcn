package azubakov.edu.caloriescalc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.materialtextfield.MaterialTextField;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.models.Body;

public class InformBodyCaloriesActivity extends AppCompatActivity {

    EditText etGender,etWeight, etAge, etHeight, etActivity;
    TextView etDate;
    String Date;
    //TextInputEditText etDate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inform_body_calories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViews();




      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

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

    private void findViews() {
        //etDate = (TextInputEditText) findViewById(R.id.etDate);
        //etDate = (EditText) findViewById(R.id.etDate);
        etDate = (TextView) findViewById(R.id.etDate);
        etGender = (EditText) findViewById(R.id.etGender);
        etWeight = (EditText) findViewById(R.id.etWeight);
        etAge = (EditText) findViewById(R.id.etAge);
        etHeight = (EditText) findViewById(R.id.etHeight);
        etActivity = (EditText) findViewById(R.id.etActivity);


    }

    public void CalculateInform(View view){

        /*if (!isValidInputDate() ||
                !isValidInputGender() || !isValidInputWeight() ||
                !isValidInputAge() ||  !isValidHeight() || !isValidInputActivity())*/

        if (!isValidInputGender() || !isValidInputWeight() ||
                !isValidInputAge() ||  !isValidHeight() || !isValidInputActivity())
            return;


        Intent intent = new Intent(this, ResultInfoBodyActivity.class);
        intent.putExtra("date", etDate.getText().toString());
        intent.putExtra("gender", etGender.getText().toString());
        intent.putExtra("weight", etWeight.getText().toString());
        intent.putExtra("age", etAge.getText().toString());
        intent.putExtra("height", etHeight.getText().toString());
        intent.putExtra("activity", etActivity.getText().toString());
        startActivity(intent);


    }
    private Integer getGender()
    {
        //String GenderString = etGender.getText().toString();
        String GenderString = etGender.getText().toString();
        Integer Gender = Integer.valueOf(GenderString);
        return Gender;
    }


    private Double getWeight()
    {
        String WeightString = etWeight.getText().toString();
        Double Weight = Double.valueOf(WeightString);
        return Weight;
    }

    private Double getAge()
    {
        String AgeString = etAge.getText().toString();
        Double Age = Double.valueOf(AgeString);
        return Age;
    }

    private Double getHeight()
    {
        String HeightString = etHeight.getText().toString();
        Double Height = Double.valueOf(HeightString);
        return Height;
    }



    public String getDate()
    {
        String etDateString =  etDate.getText().toString();
        return etDateString;
    }

    public Integer getActivity()
    {
        String etCaloriesActivityString =  etActivity.getText().toString();
        Integer Activity = Integer.valueOf(etCaloriesActivityString);
        return Activity;
    }

  /*  private boolean isValidInputDate() {
        boolean etDateValid = getDate().length() >= 2;

        if (!etDateValid)
            etDate.setError("Date must be at least 1 characters Long");

        return etDateValid;
    }*/


    private boolean isValidInputGender() {
        //String etGenderString = etGender.getText().toString();
        String etGenderString = etGender.getText().toString();
        boolean etGenderValid = etGenderString.length() == 1;


        if (!etGenderValid)
           //// etGender.setError("Gender must be exectly 1 characters Long from 1 to 2");
            etGender.setError("Gender must be exectly 1 characters Long from 1 to 2");
        return etGenderValid;
    }

    private boolean isValidInputWeight() {
        String etWeightString = etWeight.getText().toString();
        boolean etWeightValid = etWeightString.length() >= 2;

        if (!etWeightValid)
            etWeight.setError("Weight must be at least 1 characters Long");

        return etWeightValid;
    }

    private boolean isValidInputAge() {
        String etAgeString = etAge.getText().toString();
        boolean etAgeValid = etAgeString.length() >= 2;

        if (!etAgeValid)
            etAge.setError("Age must be at least 1 characters Long");

        return etAgeValid;
    }

    private boolean isValidHeight() {
        String etHeightString = etHeight.getText().toString();
        boolean etHeightValid = etHeightString.length() >= 2;

        if (!etHeightValid)
            etHeight.setError("Height must be at least 1 characters Long");

        return etHeightValid;
    }

    private boolean isValidInputActivity() {
        String etActivityString = etActivity.getText().toString();
        boolean etActivityValid = etActivityString.length() == 1;


        if (!etActivityValid)
            etActivity.setError("Activity must be exectly 1 characters Long  and from 1 to 5");

        return etActivityValid;
    }


    public void backNavDrawer(View view) {
        Intent intent = new Intent(this, CalorieNavDrawerActivity.class);
        startActivity(intent);

    }


    public void SaveFirabase(View view) {
        Toast.makeText(InformBodyCaloriesActivity.this, "I am in InformBodyCaloriesActivity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, RecyclerInfoBodyActivity.class);
        startActivity(intent);
    }
}
