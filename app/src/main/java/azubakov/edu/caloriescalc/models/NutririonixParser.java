package azubakov.edu.caloriescalc.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class NutririonixParser {
    public static ArrayList<Nutritionix> parse(String json) throws JSONException {
        //ArrayList<Nutritionix> reddits = new ArrayList<>();
        ArrayList<Nutritionix> nutritionixs = new ArrayList<>();

        //JSONArray children = new JSONObject(json).getJSONObject("data").getJSONArray("children");
        //JSONArray children = new JSONObject(json).getJSONObject("data").getJSONArray("children");
        JSONArray hits = new JSONObject(json).getJSONArray("hits");


        for (int i = 0; i < hits.length(); i++) {
            JSONObject childObject = hits.getJSONObject(i);
            JSONObject childData = childObject.getJSONObject("fields");

            //String url = childData.getString("item_name");
            //String title = childData.getString("title");
            String productname = childData.getString("item_name");
            String calories = childData.getString("nf_calories");
            String fats = childData.getString("nf_total_fat");

            nutritionixs.add(new Nutritionix(productname,calories,fats));
        }
        return nutritionixs;
    }
}
