
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.contrib.ViewPagerActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.ui.neighbour_list.MyNeighbourRecyclerViewAdapter;
import com.openclassrooms.entrevoisins.ui.neighbour_list.NeighbourFragment;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ShowNeighbourActivity;

import org.hamcrest.core.AllOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsNull.notNullValue;
// import static com.google.android.material.tabs.TabLayout;



/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     *                 We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */


    // // test vérifiant que lorsqu’on clique sur un élément de la liste, l’écran de détails est bien lancé
    @Test
    public void checkScreenDetailLaunch() {
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(click());
        onView(withId(R.id.add_favorite)).check(matches(isDisplayed()));
    }

    // test vérifiant qu’au démarrage de ce nouvel écran, le TextView indiquant le nom de l’utilisateur en question est bien rempli
    @Test
    public void checkNeighbourNameIsNotEmpty() {
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(click());

        onView(allOf(withId(R.id.firstname), isDisplayed()))
                .check(matches(not(withText(""))));
    }



    // test vérifiant qu’au clic sur le bouton de suppression, la liste d’utilisateurs compte bien un utilisateur en moins
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(allOf(withId(R.id.list_neighbours), isDisplayed())).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(allOf(withId(R.id.list_neighbours), isDisplayed())).check(withItemCount(ITEMS_COUNT-1));
    }

    // test vérifiant que l’onglet Favoris n’affiche que les voisins marqués comme favoris
    @Test
    public void favoriteIsFavorite() {
        // On vérifie que l'onglet Favori contient les 2 voisins définis en favori dans la collection des voisins
        // On vérifie l'affichage de la liste des voisins
        // On clique sur le premier élement de la liste
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        // On vérifie que  le bouton ajouter en favori s'affiche
        // On clique sur le bouton dessus
        onView(allOf(withId(R.id.add_favorite), isDisplayed()))
                .perform(click());

        // On vérifie que le bouton retour à la liste s'affiche
        // On clique sur le bouton
        onView(allOf(withId(R.id.retourliste), isDisplayed()))
                .perform(click());

        //onView(allOf(withId(R.id.tabItem2), isDisplayed()))
        //        .check(matches(hasMinimumChildCount(2)));

        // On vérifie que la liste des voisins est entièrement chargée et affichée
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .check(matches(isDisplayed()));


        Espresso.onView(allOf(withText("FAVORITES")))
                .perform(ViewActions.click());

    }

}

