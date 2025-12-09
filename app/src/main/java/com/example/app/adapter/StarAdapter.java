package com.example.app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.example.app.beans.Star;
import com.example.app.util.ImageLoader;

import java.util.List;

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> {
    private List<Star> stars;
    private OnStarClickListener listener;

    public interface OnStarClickListener {
        void onStarClick(Star star, int position);
    }

    public StarAdapter(List<Star> stars, OnStarClickListener listener) {
        this.stars = stars;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_star, parent, false);
        return new StarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder holder, int position) {
        Star star = stars.get(position);
        holder.bind(star);
    }

    @Override
    public int getItemCount() {
        return stars.size();
    }

    public void updateStar(int position, float newRating) {
        if (position >= 0 && position < stars.size()) {
            stars.get(position).setRating(newRating);
            notifyItemChanged(position);
        }
    }

    public void setStars(List<Star> stars) {
        this.stars = stars;
        notifyDataSetChanged();
    }

    public List<Star> getCurrentStars() {
        return stars;
    }

    class StarViewHolder extends RecyclerView.ViewHolder {
        private ImageView starImage;
        private TextView starName;
        private TextView starRating;

        public StarViewHolder(@NonNull View itemView) {
            super(itemView);
            starImage = itemView.findViewById(R.id.star_image);
            starName = itemView.findViewById(R.id.star_name);
            starRating = itemView.findViewById(R.id.star_rating);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onStarClick(stars.get(position), position);
                    }
                }
            });
        }

        public void bind(Star star) {
            starName.setText(star.getName());
            starRating.setText(String.format("Note moyenne: %.1f", star.getRating()));
            
            // Priorité: assets > drawable > image par défaut
            boolean imageLoaded = false;
            
            // Essayer de charger depuis assets d'abord
            if (star.getImageAssetName() != null && !star.getImageAssetName().isEmpty()) {
                imageLoaded = ImageLoader.loadFromAssets(itemView.getContext(), starImage, star.getImageAssetName());
            }
            
            // Si assets a échoué ou n'existe pas, utiliser drawable
            if (!imageLoaded) {
                if (star.getImageResId() != 0) {
                    ImageLoader.loadFromDrawable(starImage, star.getImageResId());
                } else {
                    // Image par défaut
                    starImage.setImageResource(R.drawable.star);
                }
            }
        }
    }
}

