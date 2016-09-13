package azubakov.edu.caloriescalc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.models.Gender;

public class MealProductsSpinActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    ImageView ivBody;
    TextView tvProductName;
    Spinner spProductName;
   // Button btnProductName;
    //String item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_products_spin);
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

        ivBody = (ImageView) findViewById(R.id.ivBody);
        tvProductName = (TextView) findViewById(R.id.tvProductName);
        spProductName = (Spinner) findViewById(R.id.spProductName);
  //      btnProductName = (Button) findViewById(R.id.btnProductName);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.productname_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spProductName.setAdapter(adapter);
        spProductName.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //String item = adapterView.getItemAtPosition(i).toString();
        String item = (String) adapterView.getItemAtPosition(i);
        //Toast.makeText(MealProductsSpinActivity.this, "item is: "+ item, Toast.LENGTH_SHORT).show();
       // Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        if (item.equals("Milk"))
        {
            Intent intent = new Intent(this, RecyclerMilkProductsActivity.class);
            startActivity(intent);
        }
        else if (item.equals("Bread"))
        {
            Intent intent = new Intent(this, RecyclerBreadProductsActivity.class);
            startActivity(intent);
        }
        else if (item.equals("Fish"))
        {
            Intent intent = new Intent(this, RecyclerFishProductsActivity.class);
            startActivity(intent);
        }
        else if (item.equals("Meat"))
        {
            Intent intent = new Intent(this, RecyclerMeatProductsActivity.class);
            startActivity(intent);
        }
        else if (item.equals("Popular"))
        {
            Intent intent = new Intent(this, RecyclerPopularProductsActivity.class);
            startActivity(intent);
        }
        else if (item.equals("Acts"))
        {
            Intent intent = new Intent(this, RecyclerActsActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

  /*  public void gotoProductName(View view) {
        String s1 =  spProductName.getSelectedItem().toString();
        //s2 = String.valueOf(spProductName.getSelectedItem());
        //Toast.makeText(MealProductsSpinActivity.this, "s1 = " + s1, Toast.LENGTH_SHORT).show();
        //Toast.makeText(MealProductsSpinActivity.this, "s2 = " + s2, Toast.LENGTH_SHORT).show();
        if (s1.equals("Milk"))
        {
            Intent intent = new Intent(this, RecyclerMilkProductsActivity.class);
            startActivity(intent);
        }
        else if (s1.equals("Bread"))
        {
            Intent intent = new Intent(this, RecyclerBreadProductsActivity.class);
            startActivity(intent);
        }
        else if (s1.equals("Fish"))
        {
            Intent intent = new Intent(this, RecyclerFishProductsActivity.class);
            startActivity(intent);
        }
        else if (s1.equals("Meat"))
        {
            Intent intent = new Intent(this, RecyclerMeatProductsActivity.class);
            startActivity(intent);
        }
        else if (s1.equals("Popular"))
        {
            Intent intent = new Intent(this, RecyclerPopularProductsActivity.class);
            startActivity(intent);
        }
        else if (s1.equals("Acts"))
        {
            Intent intent = new Intent(this, RecyclerActsActivity.class);
            startActivity(intent);
        }
    }*/
}
