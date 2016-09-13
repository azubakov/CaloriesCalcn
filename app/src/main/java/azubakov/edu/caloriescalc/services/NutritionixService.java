package azubakov.edu.caloriescalc.services;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ProgressBar;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import azubakov.edu.caloriescalc.adapters.NutritionixAdapter;
import azubakov.edu.caloriescalc.models.NutririonixParser;
import azubakov.edu.caloriescalc.models.Nutritionix;
/*import tomerbu.edu.recyclerweb.models.Reddit;
import tomerbu.edu.recyclerweb.models.RedditParser;
import tomerbu.edu.recyclerweb.utils.IOUtils;*/

/**
 * Usage Example from MainActivity:
 *
   NutritionixService service = new NutritionixService(tvJson);
   service.execute();
 */

public class NutritionixService extends AsyncTask<String, Integer, ArrayList<Nutritionix>> {

    private final RecyclerView rvReddits;
    private final ProgressBar progressBar;
    private final String searching;

    public NutritionixService(RecyclerView rvReddits, ProgressBar progressBar, String searching) {
        this.rvReddits = rvReddits;
        this.progressBar = progressBar;
        this.searching = searching;
    }

    @Override
    protected ArrayList<Nutritionix> doInBackground(String... params) {
        try {
            //URL url = new URL("https://www.reddit.com/.json");
            ////URL url = new URL("https://api.nutritionix.com/v1_1/search/cheddar%20cheese?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat&appId=765d3f1a&appKey=4f0b46bc1434f1a759333bcf25d9187c");
            URL url = new URL("https://api.nutritionix.com/v1_1/search/" + searching + "?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat&appId=765d3f1a&appKey=4f0b46bc1434f1a759333bcf25d9187c");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

            InputStream in = con.getInputStream();
            String data = azubakov.edu.caloriescalc.utils.IOUtils.getString(in);

            ArrayList<Nutritionix> nutritionixs = NutririonixParser.parse(data);

            return nutritionixs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Nutritionix> nutritionixs) {
        progressBar.setVisibility(View.GONE);
        //rvReddits.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        //rvReddits.setLayoutManager(new StaggeredGridLayoutManager());
        rvReddits.setAdapter(new NutritionixAdapter(rvReddits.getContext(), nutritionixs));
    }
}
