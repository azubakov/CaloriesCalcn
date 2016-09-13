package azubakov.edu.caloriescalc.activity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.models.Body;
import azubakov.edu.caloriescalc.models.Dairy;
import azubakov.edu.caloriescalc.models.DaySumCalories;

public class DairynActivity extends AppCompatActivity {




    NestedScrollView nstScrView;
    TextView tvSumCalBreakfast;
    EditText etNameProductBreakfast, etGrammBreakfast, etKcalBreakfast;
    EditText etNameProductBreakfast2, etGrammBreakfast2, etKcalBreakfast2;
    EditText etNameProductBreakfast3, etGrammBreakfast3,etKcalBreakfast3;
    EditText etNameProductBreakfast4, etGrammBreakfast4,etKcalBreakfast4;
    EditText etNameProductBreakfast5, etGrammBreakfast5,etKcalBreakfast5;
    EditText etNameProductBreakfast6, etGrammBreakfast6,etKcalBreakfast6;
    EditText etNameProductBreakfast7, etGrammBreakfast7,etKcalBreakfast7;
    TextView tvSumCalLunch;

    EditText etNameProductLunch, etGrammLunch, etKcalLunch;
    EditText etNameProductLunch2, etGrammLunch2, etKcallunch2;
    EditText etNameProductLunch3, etGrammLunch3, etKcalLunch3;
    EditText etNameProductLunch4, etGrammLunch4, etKcalLunch4;
    EditText etNameProductLunch5, etGrammLunch5, etKcalLunch5;
    EditText etNameProductLunch6, etGrammLunch6, etKcalLunch6;
    EditText etNameProductLunch7, etGrammLunch7, etKcalLunch7;
    TextView tvSumCalDinner;

    EditText etNameProductDinner, etGrammDinner, etKcalDinner;
    EditText etNameProductDinner2, etGrammDinner2, etKcalDinner2;
    EditText etNameProductDinner3, etGrammDinner3, etKcalDinner3;
    EditText etNameProductDinner4, etGrammDinner4, etKcalDinner4;
    EditText etNameProductDinner5, etGrammDinner5, etKcalDinner5;
    EditText etNameProductDinner6, etGrammDinner6, etKcalDinner6;
    EditText etNameProductDinner7, etGrammDinner7, etKcalDinner7;

    EditText etNameProductSnakes, etGrammSnakes, etKcalSnakes;
    EditText etNameProductSnakes2, etGrammSnakes2, etKcalSnakes2;
    EditText etNameProductSnakes3, etGrammSnakes3, etKcalSnakes3;
    EditText etNameProductSnakes4, etGrammSnakes4, etKcalSnakes4;
    EditText etNameProductSnakes5, etGrammSnakes5, etKcalSnakes5;
    EditText etNameProductSnakes6, etGrammSnakes6, etKcalSnakes6;
    EditText etNameProductSnakes7, etGrammSnakes7, etKcalSnakes7;
    TextView tvSumCalSnakes;

    EditText etNameProductActs, etMinActs, etKcalActs;
    EditText etNameProductActs2,etMinActs2, etKcalActs2;
    EditText etNameProductActs3,etMinActs3, etKcalActs3;

    TextView tvSumCalActs;


    TextView  tvRecomendCal, tvSumRecomendCal, tvSumDayCal, tvCalSumDayCal;
    TextView tvRecomendExtraCal, tvSumRecomendExtraCal;
    TextView tvBmi, tvBmiSum;

    TextView tvDate, tvRealDate, tvDate1, tvRealDate1;

    String Date;
   /* private double GrammLunch;
    private double GrammBreakfast;
    private double KcalBrakfast;
    private double KcalLunch;
    private double GrammDinner;
    private double KcalDinner;
    private double GrammSnakes;
    private double KcalSnakes;
    private double MinActs;
    private double KcalActs;
    private double GrammBreakfast2;
    private double KcalBrakfast2;
    private double GrammBreakfast3;
    private double KcalBrakfast3;
    private double GrammBreakfast4;
    private double KcalBrakfast4;
    private double GrammBreakfast5;
    private double KcalBrakfast5;
    private double GrammBreakfast6;
    private double KcalBrakfast6;
    private double GrammBreakfast7;
    private double KcalBrakfast7;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairyn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

   /*     FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        //tvBreakfast = (TextView) findViewById(R.id.tvBreakfast);
      /*  etBreakfastCalMinus = (EditText) findViewById(R.id.etBreakfastCalPlus);
        etBreakfastCalPlus = (EditText) findViewById(R.id.etBreakfastCalPlus);
        tvLunch = (TextView) findViewById(R.id.tvLunch);
        etLunchCalMinus = (EditText) findViewById(R.id.etLunchCalMinus);
        etLunchCalMinus = (EditText) findViewById(R.id.etLunchCalMinus);
        tvDinner = (TextView) findViewById(R.id.tvDinner);
        etSnakesCalMinus = (EditText) findViewById(R.id.etSnakesCalMinus);
        etSnakesCalMinus = (EditText) findViewById(R.id.etSnakesCalMinus);*/

        tvSumCalBreakfast = (TextView) findViewById(R.id.tvSumCalBreakfast);
        etNameProductBreakfast = (EditText) findViewById(R.id.etNameProductBreakfast);
        etGrammBreakfast = (EditText) findViewById(R.id.etGrammBreakfast);
        etKcalBreakfast = (EditText) findViewById(R.id.etKcalBreakfast);
        etNameProductBreakfast2 = (EditText) findViewById(R.id.etNameProductBreakfast2);
        etGrammBreakfast2 = (EditText) findViewById(R.id.etGrammBreakfast2);
        etKcalBreakfast2 = (EditText) findViewById(R.id.etKcalBreakfast2);
        etNameProductBreakfast3 = (EditText) findViewById(R.id.etNameProductBreakfast3);
        etGrammBreakfast3 = (EditText) findViewById(R.id.etGrammBreakfast3);
        etKcalBreakfast3 = (EditText) findViewById(R.id.etKcalBreakfast3);
        etNameProductBreakfast4 = (EditText) findViewById(R.id.etNameProductBreakfast4);
        etGrammBreakfast4 = (EditText) findViewById(R.id.etGrammBreakfast4);
        etKcalBreakfast4 = (EditText) findViewById(R.id.etKcalBreakfast4);
        etNameProductBreakfast5 = (EditText) findViewById(R.id.etNameProductBreakfast5);
        etGrammBreakfast5 = (EditText) findViewById(R.id.etGrammBreakfast5);
        etKcalBreakfast5 = (EditText) findViewById(R.id.etKcalBreakfast5);
        etNameProductBreakfast6 = (EditText) findViewById(R.id.etNameProductBreakfast6);
        etGrammBreakfast6 = (EditText) findViewById(R.id.etGrammBreakfast6);
        etKcalBreakfast6 = (EditText) findViewById(R.id.etKcalBreakfast6);
        etNameProductBreakfast7 = (EditText) findViewById(R.id.etNameProductBreakfast7);
        etGrammBreakfast7 = (EditText) findViewById(R.id.etGrammBreakfast7);
        etKcalBreakfast7 = (EditText) findViewById(R.id.etKcalBreakfast7);


        tvSumCalLunch = (TextView) findViewById(R.id.tvSumCalLunch);
        etNameProductLunch = (EditText) findViewById(R.id.etNameProductLunch);
        etGrammLunch = (EditText) findViewById(R.id.etGrammLunch);
        etKcalLunch = (EditText) findViewById(R.id.etKcalLunch);
        etNameProductLunch2 = (EditText) findViewById(R.id.etNameProductLunch2);
        etGrammLunch2 = (EditText) findViewById(R.id.etGrammLunch2);
        etKcallunch2 = (EditText) findViewById(R.id.etKcallunch2);
        etNameProductLunch3 = (EditText) findViewById(R.id.etNameProductLunch3);
        etGrammLunch3 = (EditText) findViewById(R.id.etGrammLunch3);
        etKcalLunch3 = (EditText) findViewById(R.id.etKcalLunch3);
        etNameProductLunch4 = (EditText) findViewById(R.id.etNameProductLunch4);
        etGrammLunch4 = (EditText) findViewById(R.id.etGrammLunch4);
        etKcalLunch4 = (EditText) findViewById(R.id.etKcalLunch4);
        etNameProductLunch5 = (EditText) findViewById(R.id.etNameProductLunch5);
        etGrammLunch5 = (EditText) findViewById(R.id.etGrammLunch5);
        etKcalLunch5 = (EditText) findViewById(R.id.etKcalLunch5);
        etNameProductLunch6 = (EditText) findViewById(R.id.etNameProductLunch6);
        etGrammLunch6 = (EditText) findViewById(R.id.etGrammLunch6);
        etKcalLunch6 = (EditText) findViewById(R.id.etKcalLunch6);
        etNameProductLunch7 = (EditText) findViewById(R.id.etNameProductLunch7);
        etGrammLunch7 = (EditText) findViewById(R.id.etGrammLunch7);
        etKcalLunch7 = (EditText) findViewById(R.id.etKcalLunch7);

        tvSumCalDinner = (TextView) findViewById(R.id.tvSumCalDinner);

        etNameProductDinner = (EditText) findViewById(R.id.etNameProductDinner);
        etGrammDinner = (EditText) findViewById(R.id.etGrammDinner);
        etKcalDinner = (EditText) findViewById(R.id.etKcalDinner);
        etNameProductDinner2 = (EditText) findViewById(R.id.etNameProductDinner2);
        etGrammDinner2 = (EditText) findViewById(R.id.etGrammDinner2);
        etKcalDinner2 = (EditText) findViewById(R.id.etKcalDinner2);
        etNameProductDinner3 = (EditText) findViewById(R.id.etNameProductDinner3);
        etGrammDinner3 = (EditText) findViewById(R.id.etGrammDinner3);
        etKcalDinner3 = (EditText) findViewById(R.id.etKcalDinner3);
        etNameProductDinner4 = (EditText) findViewById(R.id.etNameProductDinner4);
        etGrammDinner4 = (EditText) findViewById(R.id.etGrammDinner4);
        etKcalDinner4 = (EditText) findViewById(R.id.etKcalDinner4);
        etNameProductDinner5 = (EditText) findViewById(R.id.etNameProductDinner5);
        etGrammDinner5 = (EditText) findViewById(R.id.etGrammDinner5);
        etKcalDinner5 = (EditText) findViewById(R.id.etKcalDinner5);
        etNameProductDinner6 = (EditText) findViewById(R.id.etNameProductDinner6);
        etGrammDinner6 = (EditText) findViewById(R.id.etGrammDinner6);
        etKcalDinner6 = (EditText) findViewById(R.id.etKcalDinner6);
        etNameProductDinner7 = (EditText) findViewById(R.id.etNameProductDinner7);
        etGrammDinner7 = (EditText) findViewById(R.id.etGrammDinner7);
        etKcalDinner7 = (EditText) findViewById(R.id.etKcalDinner7);

        tvSumCalSnakes = (TextView) findViewById(R.id.tvSumCalSnakes);

        etNameProductSnakes = (EditText) findViewById(R.id.etNameProductSnakes);
        etGrammSnakes = (EditText) findViewById(R.id.etGrammSnakes);
        etKcalSnakes = (EditText) findViewById(R.id.etKcalSnakes);
        etNameProductSnakes2 = (EditText) findViewById(R.id.etNameProductSnakes2);
        etGrammSnakes2 = (EditText) findViewById(R.id.etGrammSnakes2);
        etKcalSnakes2 = (EditText) findViewById(R.id.etKcalSnakes2);
        etNameProductSnakes3 = (EditText) findViewById(R.id.etNameProductSnakes3);
        etGrammSnakes3 = (EditText) findViewById(R.id.etGrammSnakes3);
        etKcalSnakes3 = (EditText) findViewById(R.id.etKcalSnakes3);
        etNameProductSnakes4 = (EditText) findViewById(R.id.etNameProductSnakes4);
        etGrammSnakes4 = (EditText) findViewById(R.id.etGrammSnakes4);
        etKcalSnakes4 = (EditText) findViewById(R.id.etKcalSnakes4);
        etNameProductSnakes5 = (EditText) findViewById(R.id.etNameProductSnakes5);
        etGrammSnakes5 = (EditText) findViewById(R.id.etGrammSnakes5);
        etKcalSnakes5 = (EditText) findViewById(R.id.etKcalSnakes5);
        etNameProductSnakes6 = (EditText) findViewById(R.id.etNameProductSnakes6);
        etGrammSnakes6 = (EditText) findViewById(R.id.etGrammSnakes6);
        etKcalSnakes6 = (EditText) findViewById(R.id.etKcalSnakes6);
        etNameProductSnakes7 = (EditText) findViewById(R.id.etNameProductSnakes7);
        etGrammSnakes7 = (EditText) findViewById(R.id.etGrammSnakes7);
        etKcalSnakes7 = (EditText) findViewById(R.id.etKcalSnakes7);


        tvSumCalActs = (TextView) findViewById(R.id.tvSumCalActs);
        etNameProductActs = (EditText) findViewById(R.id.etNameProductActs);
        etMinActs = (EditText) findViewById(R.id.etMinActs);
        etKcalActs = (EditText) findViewById(R.id.etKcalActs);
        etNameProductActs2 = (EditText) findViewById(R.id.etNameProductActs2);
        etMinActs2 = (EditText) findViewById(R.id.etMinActs2);
        etKcalActs2 = (EditText) findViewById(R.id.etKcalActs2);
        etNameProductActs3 = (EditText) findViewById(R.id.etNameProductActs3);
        etMinActs3 = (EditText) findViewById(R.id.etMinActs3);
        etKcalActs3 = (EditText) findViewById(R.id.etKcalActs3);


        tvRecomendCal = (TextView) findViewById(R.id.tvRecomendCal);
        tvSumRecomendCal = (TextView) findViewById(R.id.tvSumRecomendCal);
        tvSumDayCal = (TextView) findViewById(R.id.tvSumDayCal);
        tvCalSumDayCal = (TextView) findViewById(R.id.tvCalSumDayCal);

        tvRecomendExtraCal = (TextView) findViewById(R.id.tvRecomendExtraCal);
        tvSumRecomendExtraCal = (TextView) findViewById(R.id.tvSumRecomendExtraCal);

        tvBmi = (TextView) findViewById(R.id.tvBmi);
        tvBmiSum = (TextView) findViewById(R.id.tvBmi);

        tvDate = (TextView) findViewById(R.id.tvDate);
        tvRealDate = (TextView) findViewById(R.id.tvRealDate);

        tvDate1 = (TextView) findViewById(R.id.tvDate1);
        tvRealDate1 = (TextView) findViewById(R.id.tvRealDate1);



        final Calendar c = Calendar.getInstance();
        int yy = c.get(Calendar.YEAR);
        int mm = c.get(Calendar.MONTH);
        int dd = c.get(Calendar.DAY_OF_MONTH);

   /*     // set current date into textview
              tvRealDate.setText(new StringBuilder()
                .append(dd).append(".").append(mm+1)
                .append(".").append(yy));*/
        Date = dd + "." + (mm + 1) + "." + yy;
        tvRealDate.setText(Date.toString());
        tvRealDate1.setText(Date.toString());

    }


    public void Calculate(View view) {

        Double slim;
        Double GrammLunch, GrammBreakfast, KcalBrakfast, KcalLunch, GrammDinner, KcalDinner, GrammSnakes, KcalSnakes, MinActs, KcalActs;
       /* Double GrammBreakfast;
        Double KcalBrakfast;
        Double KcalLunch;
        Double GrammDinner;
        Double KcalDinner;
        Double GrammSnakes;
        Double KcalSnakes;
        Double MinActs;
        Double KcalActs;*/
        Double GrammBreakfast2, KcalBrakfast2, GrammBreakfast3, KcalBrakfast3, GrammBreakfast4,
                KcalBrakfast4, GrammBreakfast5, KcalBrakfast5, GrammBreakfast6, KcalBrakfast6,
                GrammBreakfast7, KcalBrakfast7;
       /* Double KcalBrakfast2;
        Double GrammBreakfast3;
        Double KcalBrakfast3;
        Double GrammBreakfast4;
        Double KcalBrakfast4;
        Double GrammBreakfast5;
        Double KcalBrakfast5;
        Double GrammBreakfast6;
        Double KcalBrakfast6;
        Double GrammBreakfast7;
        Double KcalBrakfast7;*/
        Double GrammLunch2, KcalLunch2, GrammLunch3, KcalLunch3, GrammLunch4, KcalLunch4, GrammLunch5,
                KcalLunch5, GrammLunch6, KcalLunch6, GrammLunch7, KcalLunch7;
      /*  Double KcalLunch2;
        Double GrammLunch3;
        Double KcalLunch3;
        Double GrammLunch4;
        Double KcalLunch4;
        Double GrammLunch5;
        Double KcalLunch5;
        Double GrammLunch6;
        Double KcalLunch6;
        Double GrammLunch7;
        Double KcalLunch7;*/
        Double GrammDinner2, KcalDinner2, GrammDinner3, KcalDinner3, GrammDinner4, KcalDinner4,
                GrammDinner5, KcalDinner5, GrammDinner6, KcalDinner6, GrammDinner7, KcalDinner7;
        Double GrammSnakes2, KcalSnakes2, GrammSnakes3, KcalSnakes3, GrammSnakes4, KcalSnakes4,
                GrammSnakes5, KcalSnakes5, GrammSnakes6, KcalSnakes6, GrammSnakes7, KcalSnakes7;
        Double MinActs2, KcalActs2, MinActs3, KcalActs3;




        String NameProductBreakfast = etNameProductBreakfast.getText().toString();
        if (NameProductBreakfast == null || NameProductBreakfast.length() <= 0)
            NameProductBreakfast = "";
        String GrammBreakfastString = etGrammBreakfast.getText().toString();
        if (GrammBreakfastString == null || GrammBreakfastString.length() <= 0) {
            GrammBreakfast = 0D;
        } else {
            GrammBreakfast = Double.parseDouble(GrammBreakfastString);
        }
        String KcalBreakfastString = etKcalBreakfast.getText().toString();
        
        if (KcalBreakfastString == null || KcalBreakfastString.length() <= 0) {
            KcalBrakfast = 0D;
        } else {
            KcalBrakfast = Double.parseDouble(KcalBreakfastString);
        }

        String NameProductBreakfast2 = etNameProductBreakfast2.getText().toString();
        if (NameProductBreakfast2 == null || NameProductBreakfast2.length() <= 0)
            NameProductBreakfast2 = "";
        String GrammBreakfastString2 = etGrammBreakfast2.getText().toString();
        if (GrammBreakfastString2 == null || GrammBreakfastString2.length() <= 0) {
            GrammBreakfast2 = 0D;
        } else {
            GrammBreakfast2 = Double.parseDouble(GrammBreakfastString2);
        }
        String KcalBreakfastString2 = etKcalBreakfast2.getText().toString();

        if (KcalBreakfastString2 == null || KcalBreakfastString2.length() <= 0) {
            KcalBrakfast2 = 0D;
        } else {
            KcalBrakfast2 = Double.parseDouble(KcalBreakfastString2);
        }

        String NameProductBreakfast3 = etNameProductBreakfast3.getText().toString();
        if (NameProductBreakfast3 == null || NameProductBreakfast3.length() <= 0)
            NameProductBreakfast3 = "";
        String GrammBreakfastString3 = etGrammBreakfast3.getText().toString();
        if (GrammBreakfastString3 == null || GrammBreakfastString3.length() <= 0) {
            GrammBreakfast3 = 0D;
        } else {
            GrammBreakfast3 = Double.parseDouble(GrammBreakfastString3);
        }
        String KcalBreakfastString3 = etKcalBreakfast2.getText().toString();

        if (KcalBreakfastString3 == null || KcalBreakfastString3.length() <= 0) {
            KcalBrakfast3 = 0D;
        } else {
            KcalBrakfast3 = Double.parseDouble(KcalBreakfastString3);
        }

        String NameProductBreakfast4 = etNameProductBreakfast4.getText().toString();
        if (NameProductBreakfast4 == null || NameProductBreakfast.length() <= 0)
            NameProductBreakfast = "";
        String GrammBreakfastString4 = etGrammBreakfast4.getText().toString();
        if (GrammBreakfastString4 == null || GrammBreakfastString4.length() <= 0) {
            GrammBreakfast4 = 0D;
        } else {
            GrammBreakfast4 = Double.parseDouble(GrammBreakfastString4);
        }
        String KcalBreakfastString4 = etKcalBreakfast4.getText().toString();

        if (KcalBreakfastString4 == null || KcalBreakfastString4.length() <= 0) {
            KcalBrakfast4 = 0D;
        } else {
            KcalBrakfast4 = Double.parseDouble(KcalBreakfastString4);
        }

        String NameProductBreakfast5 = etNameProductBreakfast5.getText().toString();
        if (NameProductBreakfast5 == null || NameProductBreakfast.length() <= 0)
            NameProductBreakfast5 = "";
        String GrammBreakfastString5 = etGrammBreakfast5.getText().toString();
        if (GrammBreakfastString5 == null || GrammBreakfastString5.length() <= 0) {
            GrammBreakfast5 = 0D;
        } else {
            GrammBreakfast5 = Double.parseDouble(GrammBreakfastString5);
        }
        String KcalBreakfastString5 = etKcalBreakfast5.getText().toString();

        if (KcalBreakfastString5 == null || KcalBreakfastString5.length() <= 0) {
            KcalBrakfast5 = 0D;
        } else {
            KcalBrakfast5 = Double.parseDouble(KcalBreakfastString5);
        }

        String NameProductBreakfast6 = etNameProductBreakfast6.getText().toString();
        if (NameProductBreakfast6 == null || NameProductBreakfast6.length() <= 0)
            NameProductBreakfast6 = "";
        String GrammBreakfastString6 = etGrammBreakfast6.getText().toString();
        if (GrammBreakfastString6 == null || GrammBreakfastString6.length() <= 0) {
            GrammBreakfast6 = 0D;
        } else {
            GrammBreakfast6 = Double.parseDouble(GrammBreakfastString6);
        }
        String KcalBreakfastString6 = etKcalBreakfast6.getText().toString();

        if (KcalBreakfastString6 == null || KcalBreakfastString6.length() <= 0) {
            KcalBrakfast6 = 0D;
        } else {
            KcalBrakfast6 = Double.parseDouble(KcalBreakfastString6);
        }

        String NameProductBreakfast7 = etNameProductBreakfast7.getText().toString();
        if (NameProductBreakfast7 == null || NameProductBreakfast7.length() <= 0)
            NameProductBreakfast7 = "";
        String GrammBreakfastString7 = etGrammBreakfast7.getText().toString();
        if (GrammBreakfastString7 == null || GrammBreakfastString7.length() <= 0) {
            GrammBreakfast7 = 0D;
        } else {
            GrammBreakfast7 = Double.parseDouble(GrammBreakfastString7);
        }
        String KcalBreakfastString7 = etKcalBreakfast7.getText().toString();

        if (KcalBreakfastString7 == null || KcalBreakfastString7.length() <= 0) {
            KcalBrakfast7 = 0D;
        } else {
            KcalBrakfast7 = Double.parseDouble(KcalBreakfastString7);
        }

        Double SumCalBreakfast = (GrammBreakfast / 100 * KcalBrakfast) + (GrammBreakfast2 / 100 * KcalBrakfast2) +
                                 (GrammBreakfast3 / 100 * KcalBrakfast3) + (GrammBreakfast4 / 100 * KcalBrakfast4) +
                                 (GrammBreakfast5 / 100 * KcalBrakfast5) + (GrammBreakfast6 / 100 * KcalBrakfast6) +
                                 (GrammBreakfast7 / 100 * KcalBrakfast7);
        tvSumCalBreakfast.setText((SumCalBreakfast).toString());

        String NameProductLunch = etNameProductLunch.getText().toString();
        if (NameProductLunch == null || NameProductLunch.length() <= 0)
            NameProductLunch = "";
        String GrammLunchString = etGrammLunch.getText().toString();
        if (GrammLunchString == null || GrammLunchString.length() <= 0) {
            GrammLunch = 0D;
        } else {
            GrammLunch = Double.parseDouble(GrammLunchString);
        }
        String KcalLunchString = etKcalLunch.getText().toString();
        if (KcalLunchString == null || KcalLunchString.length() <= 0) {
            KcalLunch = 0D;
        } else {
            KcalLunch = Double.parseDouble(KcalLunchString);
        }

        String NameProductLunch2 = etNameProductLunch2.getText().toString();
        if (NameProductLunch2 == null || NameProductLunch2.length() <= 0)
            NameProductLunch2 = "";
        String GrammLunchString2 = etGrammLunch2.getText().toString();
        if (GrammLunchString2 == null || GrammLunchString2.length() <= 0) {
            GrammLunch2 = 0D;
        } else {
            GrammLunch2 = Double.parseDouble(GrammLunchString2);
        }
        String KcalLunchString2 = etKcallunch2.getText().toString();
        if (KcalLunchString2 == null || KcalLunchString2.length() <= 0) {
            KcalLunch2 = 0D;
        } else {
            KcalLunch2 = Double.parseDouble(KcalLunchString2);
        }


        String NameProductLunch3 = etNameProductLunch3.getText().toString();
        if (NameProductLunch3 == null || NameProductLunch3.length() <= 0)
            NameProductLunch3 = "";
        String GrammLunchString3 = etGrammLunch3.getText().toString();
        if (GrammLunchString3 == null || GrammLunchString3.length() <= 0) {
            GrammLunch3 = 0D;
        } else {
            GrammLunch3 = Double.parseDouble(GrammLunchString3);
        }
        String KcalLunchString3 = etKcalLunch3.getText().toString();
        if (KcalLunchString3 == null || KcalLunchString3.length() <= 0) {
            KcalLunch3 = 0D;
        } else {
            KcalLunch3 = Double.parseDouble(KcalLunchString3);
        }


        String NameProductLunch4 = etNameProductLunch4.getText().toString();
        if (NameProductLunch4 == null || NameProductLunch4.length() <= 0)
            NameProductLunch4 = "";
        String GrammLunchString4 = etGrammLunch4.getText().toString();
        if (GrammLunchString4 == null || GrammLunchString4.length() <= 0) {
            GrammLunch4 = 0D;
        } else {
            GrammLunch4 = Double.parseDouble(GrammLunchString4);
        }
        String KcalLunchString4 = etKcalLunch4.getText().toString();
        if (KcalLunchString4 == null || KcalLunchString4.length() <= 0) {
            KcalLunch4 = 0D;
        } else {
            KcalLunch4 = Double.parseDouble(KcalLunchString4);
        }

        String NameProductLunch5 = etNameProductLunch5.getText().toString();
        if (NameProductLunch5 == null || NameProductLunch5.length() <= 0)
            NameProductLunch5 = "";
        String GrammLunchString5 = etGrammLunch5.getText().toString();
        if (GrammLunchString5 == null || GrammLunchString5.length() <= 0) {
            GrammLunch5 = 0D;
        } else {
            GrammLunch5 = Double.parseDouble(GrammLunchString5);
        }
        String KcalLunchString5 = etKcalLunch5.getText().toString();
        if (KcalLunchString5 == null || KcalLunchString5.length() <= 0) {
            KcalLunch5 = 0D;
        } else {
            KcalLunch5 = Double.parseDouble(KcalLunchString5);
        }

        String NameProductLunch6 = etNameProductLunch6.getText().toString();
        if (NameProductLunch6 == null || NameProductLunch6.length() <= 0)
            NameProductLunch6 = "";
        String GrammLunchString6 = etGrammLunch6.getText().toString();
        if (GrammLunchString6 == null || GrammLunchString6.length() <= 0) {
            GrammLunch6 = 0D;
        } else {
            GrammLunch6 = Double.parseDouble(GrammLunchString6);
        }
        String KcalLunchString6 = etKcalLunch6.getText().toString();
        if (KcalLunchString6 == null || KcalLunchString6.length() <= 0) {
            KcalLunch6 = 0D;
        } else {
            KcalLunch6 = Double.parseDouble(KcalLunchString6);
        }

        String NameProductLunch7 = etNameProductLunch7.getText().toString();
        if (NameProductLunch7 == null || NameProductLunch7.length() <= 0)
            NameProductLunch7 = "";
        String GrammLunchString7 = etGrammLunch7.getText().toString();
        if (GrammLunchString7 == null || GrammLunchString7.length() <= 0) {
            GrammLunch7 = 0D;
        } else {
            GrammLunch7 = Double.parseDouble(GrammLunchString7);
        }
        String KcalLunchString7 = etKcalLunch7.getText().toString();
        if (KcalLunchString7 == null || KcalLunchString7.length() <= 0) {
            KcalLunch7 = 0D;
        } else {
            KcalLunch7 = Double.parseDouble(KcalLunchString7);
        }

        Double SumCalLunch = (GrammLunch / 100 * KcalLunch) + (GrammLunch2 / 100 * KcalLunch2) + (GrammLunch3 / 100 * KcalLunch3) +
                             (GrammLunch4 / 100 * KcalLunch4) + (GrammLunch5 / 100 * KcalLunch5) + (GrammLunch6 / 100 * KcalLunch6) +
                             (GrammLunch7 / 100 * KcalLunch7);
        tvSumCalLunch.setText((SumCalLunch).toString());

        String NameProductDinner = etNameProductDinner.getText().toString();
        if (NameProductDinner == null || NameProductDinner.length() <= 0)
            NameProductBreakfast = "";
        String GrammDinnerString = etGrammDinner.getText().toString();
        if (GrammDinnerString == null || GrammDinnerString.length() <= 0) {
            GrammDinner = 0D;
        } else {
            GrammDinner = Double.parseDouble(GrammDinnerString);
        }
        String KcalDinnerString = etKcalDinner.getText().toString();
        if (KcalDinnerString == null || KcalDinnerString.length() <= 0) {
            KcalDinner = 0D;
        } else {
            KcalDinner = Double.parseDouble(KcalDinnerString);
        }

        String NameProductDinner2 = etNameProductDinner2.getText().toString();
        if (NameProductDinner2 == null || NameProductDinner2.length() <= 0)
            NameProductBreakfast2 = "";
        String GrammDinnerString2 = etGrammDinner2.getText().toString();
        if (GrammDinnerString2 == null || GrammDinnerString2.length() <= 0) {
            GrammDinner2 = 0D;
        } else {
            GrammDinner2 = Double.parseDouble(GrammDinnerString2);
        }
        String KcalDinnerString2 = etKcalDinner2.getText().toString();
        if (KcalDinnerString2 == null || KcalDinnerString2.length() <= 0) {
            KcalDinner2 = 0D;
        } else {
            KcalDinner2 = Double.parseDouble(KcalDinnerString2);
        }

        String NameProductDinner3 = etNameProductDinner3.getText().toString();
        if (NameProductDinner3 == null || NameProductDinner3.length() <= 0)
            NameProductBreakfast3 = "";
        String GrammDinnerString3 = etGrammDinner3.getText().toString();
        if (GrammDinnerString3 == null || GrammDinnerString3.length() <= 0) {
            GrammDinner3 = 0D;
        } else {
            GrammDinner3 = Double.parseDouble(GrammDinnerString3);
        }
        String KcalDinnerString3 = etKcalDinner3.getText().toString();
        if (KcalDinnerString3 == null || KcalDinnerString3.length() <= 0) {
            KcalDinner3 = 0D;
        } else {
            KcalDinner3 = Double.parseDouble(KcalDinnerString3);
        }

        String NameProductDinner4 = etNameProductDinner4.getText().toString();
        if (NameProductDinner4 == null || NameProductDinner4.length() <= 0)
            NameProductBreakfast4 = "";
        String GrammDinnerString4 = etGrammDinner4.getText().toString();
        if (GrammDinnerString4 == null || GrammDinnerString4.length() <= 0) {
            GrammDinner4 = 0D;
        } else {
            GrammDinner4 = Double.parseDouble(GrammDinnerString4);
        }
        String KcalDinnerString4 = etKcalDinner4.getText().toString();
        if (KcalDinnerString4 == null || KcalDinnerString4.length() <= 0) {
            KcalDinner4 = 0D;
        } else {
            KcalDinner4 = Double.parseDouble(KcalDinnerString4);
        }

        String NameProductDinner5 = etNameProductDinner5.getText().toString();
        if (NameProductDinner5 == null || NameProductDinner5.length() <= 0)
            NameProductBreakfast5 = "";
        String GrammDinnerString5 = etGrammDinner5.getText().toString();
        if (GrammDinnerString5 == null || GrammDinnerString5.length() <= 0) {
            GrammDinner5 = 0D;
        } else {
            GrammDinner5 = Double.parseDouble(GrammDinnerString5);
        }
        String KcalDinnerString5 = etKcalDinner5.getText().toString();
        if (KcalDinnerString5 == null || KcalDinnerString5.length() <= 0) {
            KcalDinner5 = 0D;
        } else {
            KcalDinner5 = Double.parseDouble(KcalDinnerString5);
        }

        String NameProductDinner6 = etNameProductDinner6.getText().toString();
        if (NameProductDinner6 == null || NameProductDinner6.length() <= 0)
            NameProductBreakfast6 = "";
        String GrammDinnerString6 = etGrammDinner6.getText().toString();
        if (GrammDinnerString6 == null || GrammDinnerString6.length() <= 0) {
            GrammDinner6 = 0D;
        } else {
            GrammDinner6 = Double.parseDouble(GrammDinnerString6);
        }
        String KcalDinnerString6 = etKcalDinner6.getText().toString();
        if (KcalDinnerString6 == null || KcalDinnerString6.length() <= 0) {
            KcalDinner6 = 0D;
        } else {
            KcalDinner6 = Double.parseDouble(KcalDinnerString6);
        }

        String NameProductDinner7 = etNameProductDinner7.getText().toString();
        if (NameProductDinner7 == null || NameProductDinner7.length() <= 0)
            NameProductBreakfast7 = "";
        String GrammDinnerString7 = etGrammDinner7.getText().toString();
        if (GrammDinnerString7 == null || GrammDinnerString7.length() <= 0) {
            GrammDinner7 = 0D;
        } else {
            GrammDinner7 = Double.parseDouble(GrammDinnerString7);
        }
        String KcalDinnerString7 = etKcalDinner7.getText().toString();
        if (KcalDinnerString7 == null || KcalDinnerString7.length() <= 0) {
            KcalDinner7 = 0D;
        } else {
            KcalDinner7 = Double.parseDouble(KcalDinnerString6);
        }


        Double SumCalDinner = (GrammDinner / 100 * KcalDinner) + (GrammDinner2 / 100 * KcalDinner2) + (GrammDinner3 / 100 * KcalDinner3) +
                              (GrammDinner4 / 100 * KcalDinner4) + (GrammDinner5 / 100 * KcalDinner5) +  (GrammDinner6 / 100 * KcalDinner6) +
                              (GrammDinner7 / 100 * KcalDinner7);
        tvSumCalDinner.setText((SumCalDinner).toString());

        String NameProductSnakes = etNameProductSnakes.getText().toString();
        if (NameProductSnakes == null || NameProductSnakes.length() <= 0)
            NameProductSnakes = "";
        String GrammSnakesString = etGrammSnakes.getText().toString();
        if (GrammSnakesString == null || GrammSnakesString.length() <= 0) {
            GrammSnakes = 0D;
        } else {
            GrammSnakes = Double.parseDouble(GrammSnakesString);
        }
        String KcalSnakesString = etKcalSnakes.getText().toString();
        if (KcalSnakesString == null || KcalSnakesString.length() <= 0) {
            KcalSnakes = 0D;
        } else {
            KcalSnakes = Double.parseDouble(KcalSnakesString);
        }

        String NameProductSnakes2 = etNameProductSnakes2.getText().toString();
        if (NameProductSnakes2 == null || NameProductSnakes2.length() <= 0)
            NameProductSnakes2 = "";
        String GrammSnakesString2 = etGrammSnakes2.getText().toString();
        if (GrammSnakesString2 == null || GrammSnakesString2.length() <= 0) {
            GrammSnakes2 = 0D;
        } else {
            GrammSnakes2 = Double.parseDouble(GrammSnakesString2);
        }
        String KcalSnakesString2 = etKcalSnakes2.getText().toString();
        if (KcalSnakesString2 == null || KcalSnakesString2.length() <= 0) {
            KcalSnakes2 = 0D;
        } else {
            KcalSnakes2 = Double.parseDouble(KcalSnakesString2);
        }

        String NameProductSnakes3 = etNameProductSnakes3.getText().toString();
        if (NameProductSnakes3 == null || NameProductSnakes3.length() <= 0)
            NameProductSnakes3 = "";
        String GrammSnakesString3 = etGrammSnakes3.getText().toString();
        if (GrammSnakesString3 == null || GrammSnakesString3.length() <= 0) {
            GrammSnakes3 = 0D;
        } else {
            GrammSnakes3 = Double.parseDouble(GrammSnakesString3);
        }
        String KcalSnakesString3 = etKcalSnakes3.getText().toString();
        if (KcalSnakesString3 == null || KcalSnakesString3.length() <= 0) {
            KcalSnakes3 = 0D;
        } else {
            KcalSnakes3 = Double.parseDouble(KcalSnakesString3);
        }

        String NameProductSnakes4 = etNameProductSnakes4.getText().toString();
        if (NameProductSnakes4 == null || NameProductSnakes4.length() <= 0)
            NameProductSnakes4 = "";
        String GrammSnakesString4 = etGrammSnakes4.getText().toString();
        if (GrammSnakesString4 == null || GrammSnakesString4.length() <= 0) {
            GrammSnakes4 = 0D;
        } else {
            GrammSnakes4 = Double.parseDouble(GrammSnakesString4);
        }
        String KcalSnakesString4 = etKcalSnakes4.getText().toString();
        if (KcalSnakesString4 == null || KcalSnakesString4.length() <= 0) {
            KcalSnakes4 = 0D;
        } else {
            KcalSnakes4 = Double.parseDouble(KcalSnakesString4);
        }

        String NameProductSnakes5 = etNameProductSnakes5.getText().toString();
        if (NameProductSnakes5 == null || NameProductSnakes5.length() <= 0)
            NameProductSnakes5 = "";
        String GrammSnakesString5 = etGrammSnakes5.getText().toString();
        if (GrammSnakesString5 == null || GrammSnakesString5.length() <= 0) {
            GrammSnakes5 = 0D;
        } else {
            GrammSnakes5 = Double.parseDouble(GrammSnakesString5);
        }
        String KcalSnakesString5 = etKcalSnakes5.getText().toString();
        if (KcalSnakesString5 == null || KcalSnakesString5.length() <= 0) {
            KcalSnakes5 = 0D;
        } else {
            KcalSnakes5 = Double.parseDouble(KcalSnakesString5);
        }

        String NameProductSnakes6 = etNameProductSnakes6.getText().toString();
        if (NameProductSnakes6 == null || NameProductSnakes6.length() <= 0)
            NameProductSnakes6 = "";
        String GrammSnakesString6 = etGrammSnakes6.getText().toString();
        if (GrammSnakesString6 == null || GrammSnakesString6.length() <= 0) {
            GrammSnakes6 = 0D;
        } else {
            GrammSnakes6 = Double.parseDouble(GrammSnakesString6);
        }
        String KcalSnakesString6 = etKcalSnakes6.getText().toString();
        if (KcalSnakesString6 == null || KcalSnakesString6.length() <= 0) {
            KcalSnakes6 = 0D;
        } else {
            KcalSnakes6 = Double.parseDouble(KcalSnakesString6);
        }

        String NameProductSnakes7 = etNameProductSnakes7.getText().toString();
        if (NameProductSnakes7 == null || NameProductSnakes7.length() <= 0)
            NameProductSnakes7 = "";
        String GrammSnakesString7 = etGrammSnakes7.getText().toString();
        if (GrammSnakesString7 == null || GrammSnakesString7.length() <= 0) {
            GrammSnakes7 = 0D;
        } else {
            GrammSnakes7 = Double.parseDouble(GrammSnakesString7);
        }
        String KcalSnakesString7 = etKcalSnakes7.getText().toString();
        if (KcalSnakesString7 == null || KcalSnakesString7.length() <= 0) {
            KcalSnakes7 = 0D;
        } else {
            KcalSnakes7 = Double.parseDouble(KcalSnakesString7);
        }


        Double SumCalSnakes = (GrammSnakes / 100 * KcalSnakes) + (GrammSnakes2 / 100 * KcalSnakes2) + (GrammSnakes3 / 100 * KcalSnakes3) +
                              (GrammSnakes4 / 100 * KcalSnakes4) + (GrammSnakes5 / 100 * KcalSnakes5) + (GrammSnakes6 / 100 * KcalSnakes6) +
                              (GrammSnakes7 / 100 * KcalSnakes7);
        tvSumCalSnakes.setText((SumCalSnakes).toString());

        String NameProductActs = etNameProductActs.getText().toString();
        if (NameProductActs == null || NameProductActs.length() <= 0)
            NameProductActs = "";
        String MinActsString = etMinActs.getText().toString();
        if (MinActsString == null || MinActsString.length() <= 0) {
            MinActs = 0D;
        } else {
            MinActs = Double.parseDouble(MinActsString);
        }
        String KcalActsString = etKcalActs.getText().toString();
        if (KcalActsString == null || KcalActsString.length() <= 0) {
            KcalActs = 0D;
        } else {
            KcalActs = Double.parseDouble(KcalActsString);
        }

        String NameProductActs2 = etNameProductActs2.getText().toString();
        if (NameProductActs2 == null || NameProductActs2.length() <= 0)
            NameProductActs2 = "";
        String MinActsString2 = etMinActs2.getText().toString();
        if (MinActsString2 == null || MinActsString2.length() <= 0) {
            MinActs2 = 0D;
        } else {
            MinActs2 = Double.parseDouble(MinActsString2);
        }
        String KcalActsString2 = etKcalActs2.getText().toString();
        if (KcalActsString2 == null || KcalActsString2.length() <= 0) {
            KcalActs2 = 0D;
        } else {
            KcalActs2 = Double.parseDouble(KcalActsString2);
        }

        String NameProductActs3 = etNameProductActs3.getText().toString();
        if (NameProductActs3 == null || NameProductActs3.length() <= 0)
            NameProductActs3 = "";
        String MinActsString3 = etMinActs3.getText().toString();
        if (MinActsString3 == null || MinActsString3.length() <= 0) {
            MinActs3 = 0D;
        } else {
            MinActs3 = Double.parseDouble(MinActsString2);
        }
        String KcalActsString3 = etKcalActs3.getText().toString();
        if (KcalActsString3 == null || KcalActsString3.length() <= 0) {
            KcalActs3 = 0D;
        } else {
            KcalActs3 = Double.parseDouble(KcalActsString3);
        }



        Double SumCalActs = (MinActs / 10 * KcalActs) + (MinActs2 / 10 * KcalActs2) + (MinActs3 / 10 * KcalActs3);
        tvSumCalActs.setText((SumCalActs).toString());

        Double SumCal = SumCalBreakfast + SumCalLunch + SumCalDinner + SumCalSnakes - SumCalActs;
        //Toast.makeText(DairynActivity.this, ""+ SumCal, Toast.LENGTH_SHORT).show();
        tvCalSumDayCal.setText(SumCal.toString());


        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();


        String uid = currentUser.getUid();
        //DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Weight").child(uid);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Dairy").child(uid);

        //Weight todo = new Weight(etTitle.getText().toString(), etMessage.getText().toString());
    /*    Dairy dairy = new Dairy(NameProductBreakfast, GrammBreakfast, KcalBrakfast, SumCalBreakfast,
                NameProductLunch, GrammLunch, KcalLunch, SumCalLunch,
                NameProductDinner, GrammDinner, KcalDinner, SumCalDinner,
                NameProductSnakes, GrammSnakes, KcalSnakes, SumCalSnakes,
                NameProductActs, MinActs, KcalActs, SumCalActs,
                SumCal);*/

        //Dairy dairy = new Dairy(Date, SumCalBreakfast, SumCalLunch, SumCalDinner,SumCalSnakes, SumCalActs, SumCal);
        DaySumCalories dairy = new DaySumCalories(Date, SumCalBreakfast, SumCalLunch, SumCalDinner,SumCalSnakes, SumCalActs, SumCal);

        //Dairy dairy = new Dairy(NameProductBreakfast, GrammBreakfast, KcalBrakfast);
        //Dairy dairy = new Dairy(etNameProductBreakfast.getText().toString());
        //Dairy dairy = new Dairy(NameProductBreakfast);

        ref.push().setValue(dairy);
        dismiss();


        DatabaseReference ref1 = FirebaseDatabase.getInstance().getReference().child("Body").child(uid);


        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //BlogPost newPost = snapshot.getValue(BlogPost.class);
                Body body = dataSnapshot.getValue(Body.class);

              /*  String s1 = "The getValue is: " + body.getDate() + body.getGender().toString() + body.getWeight().toString() + body.getAge().toString() +
                        body.getHeight().toString() + body.getActivity().toString() + body.getBmi().toString() +
                        body.getDescriptionbmi() + body.getHarbencalold().toString() + body.getHarbencalnew() +
                        body.getMiffilincal().toString() + body.getAvgcal().toString() + body.getMincal().toString()+
                        body.getMaxcal().toString() + body.getSlim().toString() + body.getExtraslim().toString()+
                        body.getFat().toString() + body.getExtrafat().toString();

                Toast.makeText(DairynActivity.this, "the slim is:" + s1, Toast.LENGTH_SHORT).show();*/


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


                /*String recomm = "" + body.getSlim().toString();
                tvSumRecomendCal.setText(recomm);
                String recommExtra = "" + body.getExtraslim().toString();
                tvSumRecomendExtraCal.setText(recommExtra);*/
                //double bmisumDouble = Math.round(body.getBmi());
                /*String bmisum = "" +  body.getBmi().toString();
                tvBmiSum.setText(bmisum);*/

                //Toast.makeText(DairynActivity.this, "" + s2, Toast.LENGTH_SHORT).show();
                //Toast.makeText(DairynActivity.this, "" + body.toString(), Toast.LENGTH_SHORT).show();


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


        /*   ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Toast.makeText(DairynActivity.this, "" + dataSnapshot.getChildrenCount(), Toast.LENGTH_SHORT).show();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Body body = postSnapshot.getValue(Body.class);
                    //Double slim =  body.getSlim();
                    //tvSumRecomendCal.setText(slim);

                    String s1 = "the getValue is: " + body.getDate() + body.getGender().toString() + body.getWeight().toString() + body.getAge().toString() +
                                                      body.getHeight().toString() + body.getActivity().toString() + body.getBmi().toString() +
                                                      body.getDescriptionbmi() + body.getHarbencalold().toString() + body.getHarbencalnew() +
                                                      body.getMiffilincal().toString() + body.getAvgcal().toString() + body.getMincal().toString()+
                                                      body.getMaxcal().toString() + body.getSlim().toString() + body.getExtraslim().toString()+
                                                      body.getFat().toString() + body.getExtrafat().toString();

                    Toast.makeText(DairynActivity.this, "the slim is:" + s1, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/


    }

    private void dismiss() {
    }

}
