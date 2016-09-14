package azubakov.edu.caloriescalc.dialogs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.activity.MealSummaryActivity;
import azubakov.edu.caloriescalc.models.ActsItem;
import azubakov.edu.caloriescalc.models.MealItem;
import azubakov.edu.caloriescalc.models.MealSummary;

/**
 * A simple {@link Fragment} subclass.
 */

public class MealSummaryFragment extends Fragment {


    private static final String ARG_CATEGORY = "Category";
    private String category;
    private ImageView ivImage;
    private TextView tvCalories;
    private TextView tvCategoryName;
    private TextView tvGramOfProducts;
    private TextView tvProteins;
    private TextView tvFats;
    private TextView tvCarbohydrates;
    private TextView tvNameOfProduct;
    private TextView tvCalSumDayCal;
    private ArrayList<MealItem> meals;
    private ArrayList<ActsItem> acts;
    public static Double SumDayBreakfast;
    public static Double SumDayLunch;
    public static Double SumDayDinner;
    public static Double SumDaySnakes;
    public static Double SumDayActs;
    public static Double SumDayBreakfastGrams;
    public static Double SumDayBreakfastProteins;
    public static Double SumDayBreakfastFats;
    public static Double SumDayBreakfastCarbohydrates;
    public static Double SumDayLunchGrams;
    public static Double SumDayLunchProteins;
    public static Double SumDayLunchFats;
    public static Double SumDayLunchCarbohydrates;
    public static Double SumDayDinnerGrams;
    public static Double SumDayDinnerProteins;
    public static Double SumDayDinnerFats;
    public static Double SumDayDinnerCarbohydrates;
    public static Double SumDaySnakesGrams;
    public static Double SumDaySnakesProteins;
    public static Double SumDaySnakesFats;
    public static Double SumDaySnakesCarbohydrates;
    public static Double SumDayActsMinuts;
    public static long CountBreakfast;
    public static long CountLunch;
    public static long CountDinner;
    public static long CountSnakes;
    public static long CountActs;
    Double SumDayCal;
    MealSummary summary;

    /*    interface getData()
        void setListener(){

        }*/
    public static MealSummaryFragment newInstance(String category) {
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, category);
        MealSummaryFragment fragment = new MealSummaryFragment();
        fragment.setArguments(args);
        fragment.summary = new MealSummary(0, 0, 0, 0, 0, 0, 0, 0, category);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_meal_summary, container, false);

        category = getArguments().getString(ARG_CATEGORY);


        ivImage = (ImageView) v.findViewById(R.id.ivCategory);
        tvCalories = (TextView) v.findViewById(R.id.tvCalories);
        tvCategoryName = (TextView) v.findViewById(R.id.tvCategoryName);
        tvGramOfProducts = (TextView) v.findViewById(R.id.tvGramOfProducts);
        tvProteins = (TextView) v.findViewById(R.id.tvProteins);
        tvFats = (TextView) v.findViewById(R.id.tvFats);
        tvCarbohydrates = (TextView) v.findViewById(R.id.tvCarbohydrates);
        tvCalSumDayCal = (TextView) v.findViewById(R.id.tvCalSumDayCal);

        //TODO:
        //Get the data from fire base. do some calculations. put the data in the imageView and textviews\
        if (category.equals("breakfast")) {
            ivImage.setImageResource(R.drawable.breakfast);
            tvCategoryName.setText("Breakfast");
        }

        if (category.equals("lunch")) {
            ivImage.setImageResource(R.drawable.salad1);
            tvCategoryName.setText("Lunch");
        }

        if (category.equals("dinner")) {
            ivImage.setImageResource(R.drawable.salad2);
            tvCategoryName.setText("Dinner");
        }

        if (category.equals("snakes")) {
            ivImage.setImageResource(R.drawable.salad3);
            tvCategoryName.setText("Snakes");
        }

        if (category.equals("acts")) {
            ivImage.setImageResource(R.drawable.breakfast);
            tvCategoryName.setText("Phisical activity");
        }


        ////  final MealItemRecyclerViewAdapter adapter = new MealItemRecyclerViewAdapter(meals);
        ////  mealRecycler.setAdapter(adapter);

        String UID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        meals = new ArrayList<>();
        acts = new ArrayList<>();
        FirebaseDatabase.getInstance().getReference().child(UID).
                child(category).addListenerForSingleValueEvent(new ValueEventListener() {
            double grams = 0;
            double cal = 0;
            double proteins = 0;
            double fats = 0;
            double carbohydrates = 0;
            long count = 0;
            double calact;
            double minutsact;
            //String act;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                count = dataSnapshot.getChildrenCount();
                int idx = 0;
                int idx1 = 0;
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    MealItem meal = child.getValue(MealItem.class);
                    if (category.equals("acts")) {
                        ActsItem act = child.getValue(ActsItem.class);
                        acts.add(act);
                        //   Toast.makeText(getActivity(), act.toString(), Toast.LENGTH_SHORT).show();
                        idx1++;
                        if (idx1 == count) {
                            for (ActsItem t : acts) {
                                minutsact += t.getMinuts();
                                calact += t.getKcal();
                            }
                        }
                    }
                    meals.add(meal);
                    idx++;
                    if (idx == count) {
                        for (MealItem m : meals) {
                            grams += m.getGrams();
                            proteins += m.getProteins();
                            fats += m.getFats();
                            carbohydrates += m.getCarbohydrates();
                            cal += m.getKcal();
                        }
                    }
                }

                if (category.equals("breakfast")) {
                    SumDayBreakfast = cal;
                    SumDayBreakfastGrams = grams;
                    SumDayBreakfastProteins = proteins;
                    SumDayBreakfastFats = fats;
                    SumDayBreakfastCarbohydrates = carbohydrates;
                    CountBreakfast = count;
                }
                if (category.equals("lunch")) {
                    SumDayLunch = cal;
                    SumDayLunchGrams = grams;
                    SumDayLunchProteins = proteins;
                    SumDayLunchFats = fats;
                    SumDayLunchCarbohydrates= carbohydrates;
                    CountLunch = count;
                }
                if (category.equals("dinner")) {
                    SumDayDinner = cal;
                    SumDayDinnerGrams = grams;
                    SumDayDinnerProteins = proteins;
                    SumDayDinnerFats = fats;
                    SumDayDinnerCarbohydrates = carbohydrates;
                    CountDinner = count;
                }
                if (category.equals("snakes")) {
                    SumDaySnakes = cal;
                    SumDaySnakesGrams = grams;
                    SumDaySnakesProteins = proteins;
                    SumDaySnakesFats = fats;
                    SumDaySnakesCarbohydrates = carbohydrates;
                    CountSnakes = count;
                }

                if (category.equals("acts")) {
                    SumDayActs = calact;
                    SumDayActsMinuts = minutsact;
                    CountActs = count;
                }



                summary.setSumCalories(cal);
                summary.setSumGrams(grams);
                summary.setSumProteins(proteins);
                summary.setSumFats(fats);
                summary.setSumCarbohydrates(carbohydrates);
                summary.setSumActs(calact);
                summary.setSumMinActs(minutsact);
                summary.setCount((int) count);





                MealSummaryActivity  activity = (MealSummaryActivity) getActivity();
                activity.addMealSummary(summary);



                tvCalories.setText(String.format(Locale.ENGLISH, "Calories are: %.2f cal.", cal));
                tvGramOfProducts.setText(String.format(Locale.ENGLISH, "Weight is: %.1f gr.", grams));
                if (category.equals("acts")) {
                    tvGramOfProducts.setText(String.format(Locale.ENGLISH, "%.1f min.", minutsact));
                }
                tvProteins.setText(String.format(Locale.ENGLISH, "Proteins are: %.2f gr.", proteins));
                tvFats.setText(String.format(Locale.ENGLISH, "Fats are: %.2f gr.", fats));
                tvCarbohydrates.setText(String.format(Locale.ENGLISH, "Sugar is: %.2f gr.", carbohydrates));
                //Toast.makeText(MealSummaryFragment.this, ""+ cal, Toast.LENGTH_SHORT).show();
                //  tvCalSumDayCal.setText(String.format(Locale.ENGLISH, "%.1f", sumcal));

              /*  if (category.equals("breakfast")) {
                    SumDayBreakfast = cal;
                    SumDayBreakfastGrams = grams;
                    CountBreakfast = count;
                }
                if (category.equals("lunch")) {
                    SumDayLunch = cal;
                    SumDayLunchGrams = grams;
                    CountLunch = count;
                }
                if (category.equals("dinner")) {
                    SumDayDinner = cal;
                    SumDayDinnerGrams = grams;
                    CountDinner = count;
                }
                if (category.equals("snakes")) {
                    SumDaySnakes = cal;
                    SumDaySnakesGrams = grams;
                    CountSnakes = count;
                }

                if (category.equals("acts")) {
                    SumDayActs = calact;
                    SumDayActsMinuts = minutsact;
                    CountActs = count;
                }*/
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return v;
    }
}
