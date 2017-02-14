package fr.com.kcal_lunches_of_the_week;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class RestaurantsActivity extends AppCompatActivity {
    private Double givenNumberOfKcal;
    private Integer nbLunch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        // On récupère les valeurs données par l'utilisateur
        Intent intent = getIntent();
        nbLunch = Integer.parseInt(getIntent().getStringExtra("nbLunch"));
        givenNumberOfKcal = Double.parseDouble(getIntent().getStringExtra("nbKcal"));

        // On récupère la liste des restaurants enregistrés et on vérifie si la liste est vide
        List<Restaurant> restaurants = Restaurant.listAll(Restaurant.class);

        // ALGORITHME Subset sum :
        // récupération des jeux de repas se rapprochant à plus ou moins 15% de la valeur donnée par l'utilisateur "givenNumberOfKcal"

        // Liste des Résultats
        final HashSet<List<Restaurant>> resultats = new HashSet<>();

        // On récupère la liste des restaurants enregistrés
        restaurants = Restaurant.listAll(Restaurant.class);
        subsetRestaurants(givenNumberOfKcal, nbLunch, resultats, restaurants);

        int total = 0 ;
        Iterator<List<Restaurant>> it = resultats.iterator();
        while (it.hasNext()) {
            List<Restaurant> a = it.next();
            total = 0;
            for(Restaurant b : a){
                System.out.println("description : " + b.getDescription());
                System.out.println("calories : " + b.getCalories());
                total+=b.getCalories();
            }
            System.out.println("total : " + total);
            System.out.println("---------------------------------");
        }
    }

    public static void subsetRestaurants(double givenNumberOfKcal, double nbLunch, HashSet<List<Restaurant>> resultats, List<Restaurant> restaurants){
        if (restaurants.size() == 0) {
            return;
        }

        // Somme des calories afin de vérifier si un ensemble de restaurant s'approche du nombre de calories demandé
        double kcalSum = 0;

        // On somme les calories de tous les restaurants
        for (Restaurant restauSum : restaurants) {
            kcalSum += restauSum.getCalories();
        }

        // On vérifie si la somme s'approche de la valeur voulue à + ou - 15% et que l'on a bien le nombre de repas souhaité
        if (kcalSum < givenNumberOfKcal + ((givenNumberOfKcal / 100) * 15)
                && kcalSum > givenNumberOfKcal - ((givenNumberOfKcal / 100) * 15)
                && restaurants.size() == nbLunch ) {
            resultats.add(new ArrayList<>(restaurants));
        }

        // On parcours l'arbre en passant la liste de restaurants "subset" dans les différents scopes
        for (int i = 0; i < restaurants.size(); i++) {
            final List<Restaurant> subset = new ArrayList<>(restaurants);
            subset.remove(i);
            subsetRestaurants(givenNumberOfKcal, nbLunch, resultats, subset);
        }
    }
}
