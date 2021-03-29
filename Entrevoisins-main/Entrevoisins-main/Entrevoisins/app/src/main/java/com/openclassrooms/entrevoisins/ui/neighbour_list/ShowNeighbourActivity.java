package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowNeighbourActivity extends AppCompatActivity {
    private static Neighbour mNeighbour;

    // Navigate fait la jonction entre l'activité showneighbour.class

    public static void navigate(FragmentActivity activity, Neighbour neighbour) {
        mNeighbour = neighbour; // On récupère ici le neighbour séléctionné
        // L'intent est une description abstraite d'une opération à réaliser
        Intent intent = new Intent(activity, ShowNeighbourActivity.class);

        //TODO : Découvrir comment on passe un élément (Neighbour) à une autre activity, via un intent

        // L'intent permet de démarrer l'activity ShowNeighbourActivity.class
        // La méthode startActivity lance la méthode onCreate
        ActivityCompat.startActivity(activity, intent, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Le setContentView cherche et déclenche le layout activity_show_neighbour
        setContentView(R.layout.activity_show_neighbour);

        displayNeighbour(mNeighbour);

        FloatingActionButton button;

        button = (FloatingActionButton) findViewById(R.id.retourliste);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // ListNeighbourActivity();
                finish();
            }

            public void ListNeighbourActivity() {
                Intent intent = new Intent(ShowNeighbourActivity.this, ListNeighbourActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton btnFavorite;

        btnFavorite = (FloatingActionButton) findViewById(R.id.add_favorite);
        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNeighbour.getIsFavorite() == false) {
                    mNeighbour.setIsFavorite(true);
                }
                else
                {
                if (mNeighbour.getIsFavorite() == true) {
                    mNeighbour.setIsFavorite(false);
                } else {
                    mNeighbour.setIsFavorite(true);
                }}
            }

            });
    }

    // Déclaration d'une méthode privée qui attend un objet de type Neighbour
    private void displayNeighbour(Neighbour neighbour) {
        final TextView tvFirstName = (TextView) findViewById(R.id.firstname);
        // Je défini le texte de tvFirstName par le contenu renvoyé par getName.
        tvFirstName.setText(neighbour.getName());

        final TextView tvTelephone = (TextView) findViewById(R.id.phoneNumber);
        tvTelephone.setText(neighbour.getPhoneNumber());

        final TextView tvaddress_neigh = (TextView) findViewById(R.id.address_neigh);
        tvaddress_neigh.setText(neighbour.getAddress());

        // final TextView tvfacebook = (TextView) findViewById(R.id.facebook);
        // tvfacebook.setText(neighbour.());

        final TextView tvaboutme = (TextView) findViewById(R.id.aboutme);
        tvaboutme.setText(neighbour.getAboutMe());

    }







    }



