package com.example.app.util;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonLoader {
    private static final String TAG = "JsonLoader";

    /**
     * Charge un fichier JSON depuis assets
     * @param context Le contexte de l'application
     * @param fileName Le nom du fichier JSON (ex: "stars_data.json")
     * @return Le contenu du fichier JSON sous forme de String
     */
    public static String loadJSONFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Log.e(TAG, "Error loading JSON from assets", ex);
            return null;
        }
        return json;
    }

    /**
     * Parse le fichier JSON des stars
     * @param jsonString Le contenu JSON
     * @return Une liste de tableaux contenant [id, name, rating, imageResId, imageAssetName]
     */
    public static List<Object[]> parseStarsData(String jsonString) {
        List<Object[]> starsData = new ArrayList<>();
        
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray starsArray = jsonObject.getJSONArray("stars");
            
            for (int i = 0; i < starsArray.length(); i++) {
                JSONObject starObject = starsArray.getJSONObject(i);
                
                int id = starObject.getInt("id");
                String name = starObject.getString("name");
                double rating = starObject.getDouble("rating");
                String imageResId = starObject.optString("imageResId", "");
                String imageAssetName = starObject.optString("imageAssetName", "");
                
                starsData.add(new Object[]{id, name, (float)rating, imageResId, imageAssetName});
            }
        } catch (JSONException e) {
            Log.e(TAG, "Error parsing JSON", e);
        }
        
        return starsData;
    }
}

