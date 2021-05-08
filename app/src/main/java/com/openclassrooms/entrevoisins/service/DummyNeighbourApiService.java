package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();

    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        List<Neighbour> favorites = new ArrayList<>();

       for (Neighbour neighbour:neighbours) {
           if (neighbour.getIsFavorite() == true) {
               favorites.add(neighbour);
           }
       }
        return favorites;
    }

    // Modification pour les favorites
    @Override
    public void setFavoriteNeighbour(Neighbour neighbour, boolean isFavorite) {
        // La boucle for parcours la liste des voisins
        for (Neighbour voisin:neighbours) {
            // Si le voisin parcouru est égal au voisin passé en argument de la méthode (setFavoriteNeighbour) alors on positionne IsFavorite sur la valeur passée en paramètre
            if (neighbour.equals(voisin)) {
                voisin.setIsFavorite(isFavorite);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }
}
