package azubakov.edu.caloriescalc.adapters;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.models.DaySumCalories;
import azubakov.edu.caloriescalc.utils.FirebaseRecyclerAdapter;

/*import tomer.edu.firedemo1.R;
import tomer.edu.firedemo1.models.Todo;
import tomer.edu.firedemo1.utils.FirebaseRecyclerAdapter;*/

/**
 * 1) create an inner class of the viewHolder
 */
public class ResultsDairyRecyclerAdapter extends FirebaseRecyclerAdapter<DaySumCalories, ResultsDairyRecyclerAdapter.ResultsDairyViewHolder> {

    private final DatabaseReference ref;
    boolean isEnabled = true;

    public ResultsDairyRecyclerAdapter(DatabaseReference ref) {
        super(DaySumCalories.class, R.layout.results_dairy_item, ResultsDairyViewHolder.class, ref);
        this.ref = ref;

    }

    @Override
    protected void populateViewHolder(final ResultsDairyViewHolder viewHolder, final DaySumCalories model, final int position) {
        viewHolder.tvDate.setText(model.getDate());
        viewHolder.tvSumCalBreakfast.setText("Breakfast " + model.getSumbreakfast().toString() + " Kcal.");
        viewHolder.tvSumCalLunch.setText("Lunch " + model.getSumlunch().toString() + " Kcal.");
        viewHolder.tvSumCalDinner.setText("Dinner " + model.getSumdinner().toString() + " Kcal.");
        viewHolder.tvSumCalSnakes.setText("Snakes " + model.getSumsnakes().toString() + " Kcal.");
        viewHolder.tvSumCalActs.setText("Acts " + model.getSumacts().toString() + " Kcal.");
        viewHolder.tvSumProteins.setText("Proteins " + model.getSumdayproteins().toString() + " Gr.");
        viewHolder.tvSumFats.setText("Fats " + model.getSumdayfats().toString() + " Gr.");
        viewHolder.tvSumCarbohydrates.setText("Carbohydrates " + model.getSumdaycarbohydrates().toString() + " Gr.");
        viewHolder.tvDaySumCal.setText("DaySumCal " + model.getDaysumcal().toString() + " Kcal.");

        viewHolder.fabDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getRef(position).removeValue();
                ref.child(viewHolder.key).removeValue();
            }
        });
    }

//Firebase.ViewHolder... String key
    public static class ResultsDairyViewHolder extends RecyclerView.ViewHolder {
        String key;
        TextView tvDate;
        TextView tvSumCalBreakfast;
        TextView tvSumCalLunch;
        TextView tvSumCalDinner;
        TextView tvSumCalSnakes;
        TextView tvSumCalActs;
        TextView tvSumProteins;
        TextView tvSumFats;
        TextView tvSumCarbohydrates;
        TextView tvDaySumCal;
        FloatingActionButton fabDelete;

        public ResultsDairyViewHolder(View itemView) {
            super(itemView);

            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvSumCalBreakfast = (TextView) itemView.findViewById(R.id.tvSumCalBreakfast);
            tvSumCalLunch = (TextView) itemView.findViewById(R.id.tvSumCalLunch);
            tvSumCalDinner = (TextView) itemView.findViewById(R.id.tvSumCalDinner);
            tvSumCalSnakes = (TextView) itemView.findViewById(R.id.tvSumCalSnakes);
            tvSumCalActs = (TextView) itemView.findViewById(R.id.tvSumCalActs);
            tvSumProteins = (TextView) itemView.findViewById(R.id.tvSumProteins);
            tvSumFats = (TextView) itemView.findViewById(R.id.tvSumFats);
            tvSumCarbohydrates = (TextView) itemView.findViewById(R.id.tvSumCarbohydrates);
            tvDaySumCal = (TextView) itemView.findViewById(R.id.tvDaySumCal);
            fabDelete = (FloatingActionButton) itemView.findViewById(R.id.fabDelete);
        }
    }
}
