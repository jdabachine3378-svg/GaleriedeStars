package com.example.app.service;

import android.content.Context;

import com.example.app.R;
import com.example.app.beans.Star;
import com.example.app.dao.IDao;
import com.example.app.util.JsonLoader;

import java.util.ArrayList;
import java.util.List;

public class StarService implements IDao<Star> {
    private List<Star> stars;
    private static StarService instance;
    private Context context;

    private StarService() {
        stars = new ArrayList<>();
    }

    public void initialize(Context context) {
        this.context = context;
        initStars();
    }

    public static StarService getInstance() {
        if (instance == null) {
            instance = new StarService();
        }
        return instance;
    }

    private void initStars() {
        // Essayer de charger depuis le fichier JSON
        if (context != null) {
            String jsonString = JsonLoader.loadJSONFromAsset(context, "stars_data.json");
            if (jsonString != null && !jsonString.isEmpty()) {
                List<Object[]> starsData = JsonLoader.parseStarsData(jsonString);
                if (starsData != null && !starsData.isEmpty()) {
                    for (Object[] data : starsData) {
                        int id = (Integer) data[0];
                        String name = (String) data[1];
                        float rating = (Float) data[2];
                        String imageResIdName = (String) data[3];
                        String imageAssetName = (String) data[4];
                        
                        int resId = getResourceId(imageResIdName, "drawable", context.getPackageName());
                        
                        // Si resId est 0, utiliser le drawable par défaut selon l'ID
                        if (resId == 0) {
                            resId = getDefaultDrawableForId(id);
                        }
                        
                        if (imageAssetName != null && !imageAssetName.isEmpty()) {
                            stars.add(new Star(id, name, rating, resId, imageAssetName));
                        } else {
                            stars.add(new Star(id, name, rating, resId));
                        }
                    }
                    return; // Succès, on sort
                }
            }
        }
        
        // Fallback: Utiliser les données par défaut avec les drawables existants
        stars.add(new Star(1, "Leonardo DiCaprio", 4.5f, R.drawable.star_1));
        stars.add(new Star(2, "Jennifer Lawrence", 4.7f, R.drawable.star_2));
        stars.add(new Star(3, "Tom Hanks", 4.8f, R.drawable.star_3));
        stars.add(new Star(4, "Meryl Streep", 4.9f, R.drawable.star_4));
        stars.add(new Star(5, "Brad Pitt", 4.6f, R.drawable.star_5));
        stars.add(new Star(6, "Emma Stone", 4.4f, R.drawable.star_6));
        stars.add(new Star(7, "Robert Downey Jr.", 4.5f, R.drawable.star_7));
        stars.add(new Star(8, "Scarlett Johansson", 4.6f, R.drawable.star_8));
        stars.add(new Star(9, "Denzel Washington", 4.7f, R.drawable.star_9));
        stars.add(new Star(10, "Natalie Portman", 4.5f, R.drawable.star_10));
    }

    /**
     * Retourne le drawable par défaut selon l'ID de la star
     */
    private int getDefaultDrawableForId(int id) {
        switch (id) {
            case 1: return R.drawable.star_1;
            case 2: return R.drawable.star_2;
            case 3: return R.drawable.star_3;
            case 4: return R.drawable.star_4;
            case 5: return R.drawable.star_5;
            case 6: return R.drawable.star_6;
            case 7: return R.drawable.star_7;
            case 8: return R.drawable.star_8;
            case 9: return R.drawable.star_9;
            case 10: return R.drawable.star_10;
            default: return R.drawable.star;
        }
    }

    /**
     * Obtient l'ID d'une ressource par son nom
     */
    private int getResourceId(String resourceName, String resourceType, String packageName) {
        try {
            return context.getResources().getIdentifier(resourceName, resourceType, packageName);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public boolean create(Star o) {
        return stars.add(o);
    }

    @Override
    public boolean delete(Star o) {
        return stars.remove(o);
    }

    @Override
    public boolean update(Star o) {
        Star star = findById(o.getId());
        if (star != null) {
            star.setName(o.getName());
            star.setRating(o.getRating());
            star.setImageResId(o.getImageResId());
            star.setImageAssetName(o.getImageAssetName());
            return true;
        }
        return false;
    }

    @Override
    public Star findById(int id) {
        for (Star star : stars) {
            if (star.getId() == id) {
                return star;
            }
        }
        return null;
    }

    @Override
    public List<Star> findAll() {
        return stars;
    }

    public List<Star> filterByName(String query) {
        List<Star> filtered = new ArrayList<>();
        String lowerQuery = query.toLowerCase();
        for (Star star : stars) {
            if (star.getName().toLowerCase().contains(lowerQuery)) {
                filtered.add(star);
            }
        }
        return filtered;
    }
}

