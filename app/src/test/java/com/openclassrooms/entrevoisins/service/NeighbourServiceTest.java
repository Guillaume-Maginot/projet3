package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void addNeighbourWithSuccess() {
        int count = 0;
        count = service.getNeighbours().size();

        Neighbour unVoisin = new Neighbour(999, "toto","bibi","123456789","youpi", "chabaglou");
        service.createNeighbour(unVoisin);
        assertEquals(count + 1, service.getNeighbours().size());
    }

    @Test
    public void addFavoriteWithSuccess() {
        int count = 0;
        count = service.getFavoriteNeighbours().size();
        assertEquals(count,0); // On vérifie que la liste des favoris est vide

        Neighbour unVoisin = new Neighbour(999, "toto","bibi","123456789","youpi", "chabaglou");
        List<Neighbour> neighbours = service.getNeighbours();
        neighbours.add(unVoisin);
        count = service.getFavoriteNeighbours().size();
        assertEquals(count,0); // On vérifie que la liste des favoris est vide
        // unVoisin.setIsFavorite(true);
        service.setFavoriteNeighbour(unVoisin, true);
        count = service.getFavoriteNeighbours().size();
        assertEquals(count,1);
    }
}
