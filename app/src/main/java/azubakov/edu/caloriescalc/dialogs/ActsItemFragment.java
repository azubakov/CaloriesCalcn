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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.adapters.ActsItemRecyclerViewAdapter;
import azubakov.edu.caloriescalc.models.ActsItem;

/*import tomerbu.edu.fabaddmeal.R;
import tomerbu.edu.fabaddmeal.models.MealItem;*/

/**
 * A fragment representing a list of Items.
 * <p/>
 * interface.
 */
public class ActsItemFragment extends Fragment {

    //private static final String ARG_MEALNAME = "Meal";
    private static final String ARG_ACTSNAME = "Acts";


    //Breakfast, supper, launch
    public static ActsItemFragment newInstance(String mealName) {


        Bundle args = new Bundle();
        args.putString(ARG_ACTSNAME, mealName);
        ActsItemFragment fragment = new ActsItemFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mealitem_list_acts, container, false);

        // Set the adapter
        //RecyclerView mealRecycler = (RecyclerView) view.findViewById(R.id.actsRecycler);
        RecyclerView actsRecycler = (RecyclerView) view.findViewById(R.id.actsRecycler);
        Context context = view.getContext();

        //mealRecycler.setLayoutManager(new LinearLayoutManager(context));
        actsRecycler.setLayoutManager(new LinearLayoutManager(context));

        //Get the argument category
        String category = getArguments().getString(ARG_ACTSNAME);
        //String category = "lunch";

        //final ArrayList<MealItem> meals = new ArrayList<>();
        final ArrayList<ActsItem> acts = new ArrayList<>();

        //final MealItemRecyclerViewAdapter adapter = new MealItemRecyclerViewAdapter(meals);
        /*FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String uid = currentUser.getUid();
        //DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("MilkProducts").child(uid);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("MilkProducts").child(uid);*/
        String UID1 = FirebaseAuth.getInstance().getCurrentUser().getUid();
        //FirebaseDatabase.getInstance().getReference().child("FishProducts").child(uid);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(UID1).child(category);

        final ActsItemRecyclerViewAdapter adapter = new ActsItemRecyclerViewAdapter(acts, ref);

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
           //public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            public boolean onMove(RecyclerView actsRecycler, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
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
                ActsItemRecyclerViewAdapter.ViewHolder holder = (ActsItemRecyclerViewAdapter.ViewHolder) viewHolder;

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
        helper.attachToRecyclerView(actsRecycler);
        actsRecycler.setAdapter(adapter);

        //FirebaseDatabase.getInstance().getReference().child(uid).child(category)
        String UID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase.getInstance().getReference().child(UID).
                child(category).addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    ActsItem realacts = child.getValue(ActsItem.class);
                    Toast.makeText(getActivity(), realacts.toString(), Toast.LENGTH_SHORT).show();
                    //meals.add(meal);
                    acts.add(realacts);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return view;
    }


}
