package com.example.app.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.example.app.adapter.StarAdapter;
import com.example.app.beans.Star;
import com.example.app.service.StarService;

import java.util.List;

public class ListActivity extends AppCompatActivity implements StarAdapter.OnStarClickListener {
    private RecyclerView recyclerView;
    private StarAdapter adapter;
    private StarService starService;
    private List<Star> allStars;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        starService = StarService.getInstance();
        starService.initialize(this);
        allStars = starService.findAll();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StarAdapter(allStars, this);
        recyclerView.setAdapter(adapter);

        setupSearchView();
    }

    private void setupSearchView() {
        searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterStars(newText);
                return true;
            }
        });
    }

    private void filterStars(String query) {
        List<Star> filtered;
        if (query.isEmpty()) {
            filtered = allStars;
        } else {
            filtered = starService.filterByName(query);
        }
        adapter.setStars(filtered);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_share) {
            shareApp();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareApp() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
        shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text));
        startActivity(Intent.createChooser(shareIntent, getString(R.string.share_app)));
    }

    @Override
    public void onStarClick(Star star, int position) {
        showRatingDialog(star, position);
    }

    private void showRatingDialog(Star star, int position) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_rating);
        dialog.setTitle(getString(R.string.rating_dialog_title));

        RatingBar ratingBar = dialog.findViewById(R.id.rating_bar);
        EditText ratingEditText = dialog.findViewById(R.id.rating_edit_text);
        Button saveButton = dialog.findViewById(R.id.btn_save);
        Button cancelButton = dialog.findViewById(R.id.btn_cancel);

        ratingBar.setRating(star.getRating());
        ratingEditText.setText(String.valueOf(star.getRating()));

        ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser) -> {
            if (fromUser) {
                ratingEditText.setText(String.valueOf(rating));
            }
        });

        saveButton.setOnClickListener(v -> {
            try {
                float newRating = Float.parseFloat(ratingEditText.getText().toString());
                if (newRating < 0 || newRating > 5) {
                    Toast.makeText(this, "La note doit être entre 0 et 5", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Mettre à jour la star dans le service
                star.setRating(newRating);
                starService.update(star);
                
                // Trouver la position actuelle dans la liste filtrée
                List<Star> currentList = adapter.getCurrentStars();
                int currentPosition = -1;
                for (int i = 0; i < currentList.size(); i++) {
                    if (currentList.get(i).getId() == star.getId()) {
                        currentPosition = i;
                        break;
                    }
                }
                
                if (currentPosition != -1) {
                    adapter.updateStar(currentPosition, newRating);
                } else {
                    // Si la star n'est plus dans la liste filtrée, rafraîchir toute la liste
                    filterStars(searchView.getQuery().toString());
                }
                
                dialog.dismiss();
                Toast.makeText(this, "Note mise à jour", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Valeur invalide", Toast.LENGTH_SHORT).show();
            }
        });

        cancelButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}

