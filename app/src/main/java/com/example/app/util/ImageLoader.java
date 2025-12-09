package com.example.app.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class ImageLoader {
    
    /**
     * Charge une image depuis le dossier assets
     * @param context Le contexte de l'application
     * @param imageView L'ImageView où afficher l'image
     * @param imageName Le nom du fichier image dans assets (ex: "leonardo.png")
     * @return true si l'image a été chargée avec succès, false sinon
     */
    public static boolean loadFromAssets(Context context, ImageView imageView, String imageName) {
        try {
            InputStream is = context.getAssets().open(imageName);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                is.close();
                return true;
            }
            is.close();
        } catch (IOException e) {
            // Image non trouvée dans assets, retourner false
            return false;
        }
        return false;
    }
    
    /**
     * Charge une image depuis les ressources drawable
     * @param imageView L'ImageView où afficher l'image
     * @param resId L'ID de la ressource drawable
     */
    public static void loadFromDrawable(ImageView imageView, int resId) {
        if (resId != 0) {
            imageView.setImageResource(resId);
        }
    }
}

