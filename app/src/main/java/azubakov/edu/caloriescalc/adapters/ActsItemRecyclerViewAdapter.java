package azubakov.edu.caloriescalc.adapters;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.models.ActsItem;
import azubakov.edu.caloriescalc.models.MealItem;
import azubakov.edu.caloriescalc.models.MilkProducts;

/*import tomerbu.edu.fabaddmeal.R;
import tomerbu.edu.fabaddmeal.models.MealItem;*/


public class ActsItemRecyclerViewAdapter extends RecyclerView.Adapter<ActsItemRecyclerViewAdapter.ViewHolder> {

    //private final List<MealItem> mValues;
    private final List<ActsItem> mValues;
    ////public static List<ActsItem> mValues = null;
    private final DatabaseReference ref;
    ////public static  DatabaseReference ref;

    public ActsItemRecyclerViewAdapter(ArrayList<ActsItem> items, DatabaseReference ref) {
        //super(ActsItem.class, R.layout.milk_item, ActsItemRecyclerViewAdapter.class, ref);
        mValues = items;
        this.ref = ref;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_mealitem_acts, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
      //  holder.mItem = mValues.get(position);
      //  holder.mIdView.setText(mValues.get(position).getProductname());
      //  holder.mContentView.setText(mValues.get(position).getGrams() + "");*/
        ActsItem actsItem = mValues.get(position);
        //Convenience (Not used)
        holder.actsItem = actsItem;
        holder.tvTypeActivity.setText(actsItem.getTypeactivity());
        holder.tvMinuts.setText(actsItem.getMinuts() + "" + " min.");
        //holder.tvGrammes.setText(mValues.get(position).getKcal() + "");
        holder.tvCalories.setText(actsItem.getKcal() + "" + " KCal.");

        //Must do to support deletions
        holder.key = actsItem.getKey();
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.fabDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteByHolder(holder);

              /*  for (int i = 0; i < mValues.size(); i++) {
                    ActsItem item = mValues.get(i);
                    if (item.getKey().equals(holder.key)){
                        ref.child(holder.key).removeValue();
                        mValues.remove(i);
                        notifyItemRemoved(i);
                    }
                }*/
            }
        });
    }

    public void deleteByHolder(ViewHolder holder) {
        for (int i = 0; i < mValues.size(); i++) {
            ActsItem item = mValues.get(i);
            if (item.getKey().equals(holder.key)){
                ref.child(holder.key).removeValue();
                mValues.remove(i);
                notifyItemRemoved(i);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        String key;
        public final View mView;
       // public final TextView mIdView;
        //TextView tvNameProduct;
        TextView tvTypeActivity;
        //public final TextView mContentView;
        //TextView tvGrammes;
        TextView tvMinuts;
        //public MealItem mItem;
        TextView tvCalories;
        FloatingActionButton fabDelete;
        ActsItem actsItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            //mIdView = (TextView) view.findViewById(R.id.id);
            //mContentView = (TextView) view.findViewById(R.id.content);
            //tvNameProduct = (TextView) view.findViewById(R.id.tvNameProduct);
            tvTypeActivity = (TextView) view.findViewById(R.id.tvTypeActivity);
            tvMinuts = (TextView) view.findViewById(R.id.tvMinuts);
            tvCalories = (TextView) view.findViewById(R.id.tvCalories);
            fabDelete = (FloatingActionButton) view.findViewById(R.id.fabDelete);
        }


        @Override
        public String toString() {
            return "ViewHolder{" +
                    "mView=" + mView +
                    ", tvTypeActivity=" + tvTypeActivity +
                    ", tvMinuts=" + tvMinuts +
                    ", tvCalories=" + tvCalories +
                    '}';
        }
        /*  public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }*/
    }
}
