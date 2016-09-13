package azubakov.edu.caloriescalc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.dialogs.ActsItemFragment;
import azubakov.edu.caloriescalc.dialogs.AddItem;
import azubakov.edu.caloriescalc.dialogs.AddItemActs;
import azubakov.edu.caloriescalc.dialogs.MealItemFragment;

import com.sa90.materialarcmenu.ArcMenu;
import com.sa90.materialarcmenu.StateChangeListener;

import static android.widget.Toast.makeText;



public class CalorieNavDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    ArcMenu arcMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_nav_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ImageButton menuLeft = (ImageButton) findViewById(R.id.menuLeft);
        ImageButton menuRight = (ImageButton) findViewById(R.id.menuRight);

        menuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        menuRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer.isDrawerOpen(GravityCompat.END)) {
                    drawer.closeDrawer(GravityCompat.END);
                } else {
                    drawer.openDrawer(GravityCompat.END);
                }

            }
        });

        NavigationView navigationView1 = (NavigationView) findViewById(R.id.nav_view);
        NavigationView navigationView2 = (NavigationView) findViewById(R.id.nav_view2);
        navigationView1.setNavigationItemSelectedListener(this);
        navigationView2.setNavigationItemSelectedListener(this);

        View fabBreakfast = findViewById(R.id.fabBreakfast);
        fabBreakfast.setOnClickListener(this);

        View fabLunch = findViewById(R.id.fabLunch);
        fabLunch.setOnClickListener(this);

        View fabDinner = findViewById(R.id.fabDinner);
        fabDinner.setOnClickListener(this);

        View fabSnakes = findViewById(R.id.fabSnakes);
        fabSnakes.setOnClickListener(this);

        arcMenu = (ArcMenu) findViewById(R.id.arcMenu);
        arcMenu.setRadius(getResources().getDimension(R.dimen.radius));

        arcMenu.setStateChangeListener(new StateChangeListener() {
            @Override
            public void onMenuOpened() {
               // Snackbar.make(arcMenu, "Menu Opened", Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onMenuClosed() {
               // Snackbar.make(arcMenu, "Menu Closed", Snackbar.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.fab1).setOnClickListener(subMenuClickListener);

        String category = "breakfast";
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MealItemFragment().newInstance(category)).commit();
    }

    private View.OnClickListener subMenuClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String category = "";
                makeText(CalorieNavDrawerActivity.this, "The Acts", Toast.LENGTH_SHORT).show();
                category = "acts";
                AddItemActs dialog = AddItemActs.newInstance(category);
                dialog.show(getSupportFragmentManager(),"Add Item");
        }
    };

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            FirebaseAuth.getInstance().signOut();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       if (id == R.id.nav_parameters_body) {
           // gotoInformBodySpin();
           Intent intent = new Intent(this, InformBodyCaloriesSpinActivity.class);
           startActivity(intent);

        }
       else if (id == R.id.nav_parameters_body_edittext)
       {
          // gotoInformBody();
           Intent intent = new Intent(this, InformBodyCaloriesActivity.class);
           startActivity(intent);
       }
       else if (id == R.id.nav_parameters_recycler_body)
       {
          // gotoRecyclerInfoBodyActivity();
           Intent intent = new Intent(this, RecyclerInfoBodyActivity.class);
           startActivity(intent);

       }
       else if (id == R.id.meals_calories)
       {
          // gotoRecyclermeals();
           //gotoMealSummaryActivity();
           Intent intent = new Intent(this, MealSummaryActivity.class);
           startActivity(intent);
       }

       else if (id == R.id.recycle_all)
       {
          // gotoRecyclerall();
           Intent intent = new Intent(this, MealSummaryRecyclerActivity.class);
           startActivity(intent);
       }

       else if (id == R.id.sum_calories)
       {
          // gotoRecyclerDairySum();
           Intent intent = new Intent(this, RecyclerResultsDairyActivity.class);
           startActivity(intent);

       }

       else if (id == R.id.diet_calendar)
       {
          // gotoRecycler();
           Intent intent = new Intent(this, CalorieRecyclerActivity.class);
           startActivity(intent);
       }

       else if (id == R.id.searchingAutocomplit_json)
       {
           //gotoSearchAutocompliteNutrtionix();
           Intent intent = new Intent(this, SearchAutocompliteNutritionixActivity.class);
           startActivity(intent);
       }


       else if (id == R.id.recycler_breakfast)
       {
           String category = "breakfast";
           getSupportFragmentManager().beginTransaction().replace(R.id.container, new MealItemFragment().newInstance(category)).commit();
       }

       else if (id == R.id.recycler_lunch)
       {
           String category = "lunch";
           getSupportFragmentManager().beginTransaction().replace(R.id.container, new MealItemFragment().newInstance(category)).commit();
       }

       else if (id == R.id.recycler_dinner)
       {
           String category = "dinner";
           getSupportFragmentManager().beginTransaction().replace(R.id.container, new MealItemFragment().newInstance(category)).commit();
       }

       else if (id == R.id.recycler_snakes)
       {
           String category = "snakes";
           getSupportFragmentManager().beginTransaction().replace(R.id.container, new MealItemFragment().newInstance(category)).commit();
       }

       else if (id == R.id.recycler_acts)
       {
           String category = "acts";
           getSupportFragmentManager().beginTransaction().replace(R.id.container, new ActsItemFragment().newInstance(category)).commit();
       }

       else if (id == R.id.spin_products)
       {
           Intent intent = new Intent(this, MealProductsSpinActivity.class);
           startActivity(intent);
       }

       else if (id == R.id.helper)
       {
           Intent intent = new Intent(this, HelperActivity.class);
           startActivity(intent);
       }
/*   else if (id == R.id.milk_products)
       {
           //gotoRecyclerMilkProductds();
           Intent intent = new Intent(this, RecyclerMilkProductsActivity.class);
           startActivity(intent);
       }
       else if (id == R.id.fish_products)
       {
           //gotoRecyclerFishProductds();
           Intent intent = new Intent(this, RecyclerFishProductsActivity.class);
           startActivity(intent);
       }
       else if (id == R.id.meat_products)
       {
           //gotoRecyclerMeatProductds();
           Intent intent = new Intent(this, RecyclerMeatProductsActivity.class);
           startActivity(intent);
       }
       else if (id == R.id.bread_products)
       {
          // gotoRecyclerBreadProductds();
           Intent intent = new Intent(this, RecyclerBreadProductsActivity.class);
           startActivity(intent);
       }
       else if (id == R.id.popular_products)
       {
         //  gotoRecyclerPopularProductds();
           Intent intent = new Intent(this, RecyclerPopularProductsActivity.class);
           startActivity(intent);
       }

       else if (id == R.id.acts_products)
       {
         //  gotoRecyclerActsProductds();
           Intent intent = new Intent(this, RecyclerActsActivity.class);
           startActivity(intent);
       }*/



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View view) {
        //Toast.makeText(CalorieNavDrawerActivity.this, "The Breakfast", Toast.LENGTH_SHORT).show();
        String category = "";
        switch (view.getId())
        {
            case R.id.fabBreakfast:
                makeText(CalorieNavDrawerActivity.this, "The breakfast", Toast.LENGTH_SHORT).show();
                category = "breakfast";
                //getSupportFragmentManager().beginTransaction().replace(R.id.container, new MealItemFragment().newInstance(category)).commit();
                AddItem dialog = AddItem.newInstance(category);
                dialog.show(getSupportFragmentManager(),"Add Item");
                break;
            case R.id.fabLunch:
                makeText(CalorieNavDrawerActivity.this, "The lunch", Toast.LENGTH_SHORT).show();
                category = "lunch";
                AddItem dialog1 = AddItem.newInstance(category);
                dialog1.show(getSupportFragmentManager(),"Add Item");
                break;
            case R.id.fabDinner:
                makeText(CalorieNavDrawerActivity.this, "The dinner", Toast.LENGTH_SHORT).show();
                category = "dinner";
                AddItem dialog2 = AddItem.newInstance(category);
                dialog2.show(getSupportFragmentManager(),"Add Item");
                break;
            case R.id.fabSnakes:
                makeText(CalorieNavDrawerActivity.this, "The snakes", Toast.LENGTH_SHORT).show();
                category = "snakes";
                AddItem dialog3 = AddItem.newInstance(category);
                dialog3.show(getSupportFragmentManager(),"Add Item");
                break;

        }
    }
}

