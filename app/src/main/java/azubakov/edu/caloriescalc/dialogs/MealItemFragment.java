package azubakov.edu.caloriescalc.dialogs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.adapters.MealItemRecyclerViewAdapter;
import azubakov.edu.caloriescalc.models.MealItem;

/*import tomerbu.edu.fabaddmeal.R;
import tomerbu.edu.fabaddmeal.models.MealItem;*/

/**
 * A fragment representing a list of Items.
 * <p/>
 * interface.
 */
public class MealItemFragment extends Fragment {

    private static final String ARG_MEALNAME = "Meal";



    //Breakfast, supper, launch
    public static MealItemFragment newInstance(String mealName) {


        Bundle args = new Bundle();
        args.putString(ARG_MEALNAME, mealName);
        MealItemFragment fragment = new MealItemFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mealitem_list, container, false);

        // Set the adapter
        RecyclerView mealRecycler = (RecyclerView) view.findViewById(R.id.mealRecycler);
        Context context = view.getContext();

        mealRecycler.setLayoutManager(new LinearLayoutManager(context));

        //Get the argument category
        String category = getArguments().getString(ARG_MEALNAME);
        //String category = "lunch";

        final ArrayList<MealItem> meals = new ArrayList<>();

        String UID1 = FirebaseAuth.getInstance().getCurrentUser().getUid();
        //FirebaseDatabase.getInstance().getReference().child("FishProducts").child(uid);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(UID1).child(category);
        final MealItemRecyclerViewAdapter adapter = new MealItemRecyclerViewAdapter(meals,ref);

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            //public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            public boolean onMove(RecyclerView mealRecycler, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            //public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                ////Toast.makeText(CalorieRecyclerActivity.this, "sdf", Toast.LENGTH_SHORT).show();
                //remove from the arrayList
                //remove from the database
                //notify item removed(position)
                //int position = viewHolder.getAdapterPosition();
                MealItemRecyclerViewAdapter.ViewHolder holder = (MealItemRecyclerViewAdapter.ViewHolder) viewHolder;

                // ActsItemRecyclerViewAdapter.deleteByHolder(holder);
                adapter.deleteByHolder(holder);
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                float right = viewHolder.itemView.getRight();
                float top  = viewHolder.itemView.getTop();
                float bottom = viewHolder.itemView.getBottom();

                Drawable d = new ColorDrawable(Color.parseColor("#4CAF50"));
                d.setBounds((int) (right + dX), (int) top, (int) right, (int) bottom);
                d.draw(c);
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }


        });

        //helper.attachToRecyclerView(recyclerView);
        helper.attachToRecyclerView(mealRecycler);





        mealRecycler.setAdapter(adapter);


        //FirebaseDatabase.getInstance().getReference().child(uid).child(category)
        String UID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase.getInstance().getReference().child(UID).
                child(category).addListenerForSingleValueEvent(new ValueEventListener()
        {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    MealItem realmeal = child.getValue(MealItem.class);
//                    Toast.makeText(getActivity(), meal.toString(), Toast.LENGTH_SHORT).show();
                    meals.add(realmeal);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        /*  FirebaseDatabase.getInstance().getReference().child("UID").
                child(category).addListenerForSingleValueEvent(new ValueEventListener()
        {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    MealItem meal = child.getValue(MealItem.class);
                    meals.add(meal);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/

        return view;
    }


}
