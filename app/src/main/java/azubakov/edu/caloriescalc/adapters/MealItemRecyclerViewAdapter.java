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

/*import tomerbu.edu.fabaddmeal.R;
import tomerbu.edu.fabaddmeal.models.MealItem;*/


public class MealItemRecyclerViewAdapter extends RecyclerView.Adapter<MealItemRecyclerViewAdapter.ViewHolder> {

    private final List<MealItem> mValues;
    private final DatabaseReference ref;

    public MealItemRecyclerViewAdapter(ArrayList<MealItem> items, DatabaseReference ref) {
        mValues = items;
        this.ref = ref;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_mealitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
      //  holder.mItem = mValues.get(position);
      //  holder.mIdView.setText(mValues.get(position).getProductname());
      //  holder.mContentView.setText(mValues.get(position).getGrams() + "");*/
        MealItem mealItem = mValues.get(position);
        //Conveniance (Not used)
        holder.mealItem = mealItem;
        holder.tvNameProduct.setText(mValues.get(position).getProductname());
        holder.tvGrammes.setText("Weight: " + mValues.get(position).getGrams() + "" + " gr.");
        //holder.tvGrammes.setText(mValues.get(position).getKcal() + "");
        holder.tvProteins.setText("Proteins: " +mValues.get(position).getProteins() + "" + " gr. ");
        holder.tvFats.setText("Fats: " + mValues.get(position).getFats() + "" + " gr. ");
        holder.tvCarbohydrates.setText("Carbohydrates: " + mValues.get(position).getCarbohydrates() + "" + " gr. ");
        holder.tvCalories.setText("Calories: " + mValues.get(position).getKcal() + "" + " Kcal.");

        //Must do to support deletions
        holder.key = mealItem.getKey();
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.fabDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteByHolder(holder);
            }
        });
    }

    public void deleteByHolder(ViewHolder holder) {
        for (int i = 0; i < mValues.size(); i++) {
            MealItem item = mValues.get(i);
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
        TextView tvNameProduct;
        //public final TextView mContentView;
        TextView tvGrammes;
        TextView tvProteins;
        TextView tvFats;
        TextView tvCarbohydrates;
        //public MealItem mItem;
        TextView tvCalories;
        FloatingActionButton fabDelete;
        MealItem mealItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            //mIdView = (TextView) view.findViewById(R.id.id);
            //mContentView = (TextView) view.findViewById(R.id.content);
            tvNameProduct = (TextView) view.findViewById(R.id.tvNameProduct);
            tvGrammes = (TextView) view.findViewById(R.id.tvGrammes);
            tvProteins = (TextView) view.findViewById(R.id.tvProteins);
            tvFats = (TextView) view.findViewById(R.id.tvFats);
            tvCarbohydrates = (TextView) view.findViewById(R.id.tvCarbohydrates);
            tvCalories = (TextView) view.findViewById(R.id.tvCalories);
            fabDelete = (FloatingActionButton) view.findViewById(R.id.fabDelete);
        }

        @Override
        public String toString() {
            return "ViewHolder{" +
                    "key='" + key + '\'' +
                    ", mView=" + mView +
                    ", tvNameProduct=" + tvNameProduct +
                    ", tvGrammes=" + tvGrammes +
                    ", tvProteins=" + tvProteins +
                    ", tvFats=" + tvFats +
                    ", tvCarbohydrates=" + tvCarbohydrates +
                    ", tvCalories=" + tvCalories +
                    ", fabDelete=" + fabDelete +
                    ", mealItem=" + mealItem +
                    '}';
        }



        /*   @Override
        public String toString() {
            return "ViewHolder{" +
                    "mView=" + mView +
                    ", tvNameProduct=" + tvNameProduct +
                    ", tvGrammes=" + tvGrammes +
                    ", tvCalories=" + tvCalories +
                    '}';
        }*/
        /*  public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }*/
    }
}
