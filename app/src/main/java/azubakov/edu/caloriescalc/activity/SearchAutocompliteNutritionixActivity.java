package azubakov.edu.caloriescalc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;

import azubakov.edu.caloriescalc.R;

public class SearchAutocompliteNutritionixActivity extends AppCompatActivity implements TextWatcher {

    AutoCompleteTextView tvProducts;
    private static final ArrayList<String> products = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_autocomplite_nutritionix);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

 /*       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

           products.add("kefir");
           products.add("bread");
           products.add("butter");
           products.add("nuts");
           products.add("sausage");
           products.add("creame");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, products);

        tvProducts = (AutoCompleteTextView)  findViewById(R.id.tvProducts);
        tvProducts.setAdapter(adapter);

        tvProducts.addTextChangedListener(this);



    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
           //Search json and add data to the list
      /*  Toast.makeText(SearchAutocompliteNutritionixActivity.this, "charSequence is:" + charSequence , Toast.LENGTH_SHORT).show();
        Toast.makeText(SearchAutocompliteNutritionixActivity.this, "i is: " + i , Toast.LENGTH_SHORT).show();
        Toast.makeText(SearchAutocompliteNutritionixActivity.this, "i1 is:" + i1 , Toast.LENGTH_SHORT).show();
        Toast.makeText(SearchAutocompliteNutritionixActivity.this, "i2 is:" + i1 , Toast.LENGTH_SHORT).show();*/
        //String s1 = tvProducts.getText().toString();
       //String s1 = (String) charSequence;
        //CharSequence s2 = charSequence;
        //Toast.makeText(SearchAutocompliteNutritionixActivity.this, "s2 is:" + s2 , Toast.LENGTH_SHORT).show();
       ////String s1 = tvProducts.getEditableText().toString();
       //// Toast.makeText(SearchAutocompliteNutritionixActivity.this, "s1 is:" + s1 , Toast.LENGTH_SHORT).show();
        /*  Intent intent = new Intent(this, NutritionixActivity.class);
        intent.putExtra("stringsearching", charSequence);
        startActivity(intent);*/
    }

    @Override
    public void afterTextChanged(Editable editable) {

        /*    Intent intent = new Intent(this, NutritionixActivity.class);
        intent.putExtra("stringsearching", editable);
        startActivity(intent);*/
       /* String s1 = tvProducts.getText().toString();
        Intent intent = new Intent(this, NutritionixActivity.class);
        intent.putExtra("stringsearching", s1);
        startActivity(intent);*/

    }

    public void SearchNutrition(View view) {
        String s1 = tvProducts.getText().toString();
        Intent intent = new Intent(this, NutritionixActivity.class);
        intent.putExtra("stringsearching", s1);
        startActivity(intent);
    }
}
