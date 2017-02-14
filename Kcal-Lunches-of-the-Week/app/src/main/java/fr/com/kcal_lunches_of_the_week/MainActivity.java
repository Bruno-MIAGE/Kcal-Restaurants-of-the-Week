package fr.com.kcal_lunches_of_the_week;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

/*
      ___           ___           ___           ___           ___
     /\  \         /\  \         /\__\         /\__\         /\  \
    /::\  \       /::\  \       /:/  /        /::|  |       /::\  \
   /:/\:\  \     /:/\:\  \     /:/  /        /:|:|  |      /:/\:\  \
  /::\~\:\__\   /::\~\:\  \   /:/  /  ___   /:/|:|  |__   /:/  \:\  \
 /:/\:\ \:|__| /:/\:\ \:\__\ /:/__/  /\__\ /:/ |:| /\__\ /:/__/ \:\__\
 \:\~\:\/:/  / \/_|::\/:/  / \:\  \ /:/  / \/__|:|/:/  / \:\  \ /:/  /
  \:\ \::/  /     |:|::/  /   \:\  /:/  /      |:/:/  /   \:\  /:/  /
   \:\/:/  /      |:|\/__/     \:\/:/  /       |::/  /     \:\/:/  /
    \::/__/       |:|  |        \::/  /        /:/  /       \::/  /
     ~~            \|__|         \/__/         \/__/         \/__/
      ___           ___           ___           ___           ___       ___
     /\__\         /\  \         /\  \         /\  \         /\__\     /\  \          ___
    /:/  /        /::\  \       /::\  \       /::\  \       /:/  /    /::\  \        /\  \
   /:/  /        /:/\:\  \     /:/\:\  \     /:/\:\  \     /:/  /    /:/\:\  \       \:\  \
  /:/__/  ___   /::\~\:\  \   /::\~\:\  \   /::\~\:\  \   /:/  /    /:/  \:\__\      /::\__\
  |:|  | /\__\ /:/\:\ \:\__\ /:/\:\ \:\__\ /:/\:\ \:\__\ /:/__/    /:/__/ \:|__|  __/:/\/__/
  |:|  |/:/  / \:\~\:\ \/__/ \/_|::\/:/  / \/__\:\/:/  / \:\  \    \:\  \ /:/  / /\/:/  /
  |:|__/:/  /   \:\ \:\__\      |:|::/  /       \::/  /   \:\  \    \:\  /:/  /  \::/__/
   \::::/__/     \:\ \/__/      |:|\/__/        /:/  /     \:\  \    \:\/:/  /    \:\__\
    ~~~~          \:\__\        |:|  |         /:/  /       \:\__\    \::/__/      \/__/
                   \/__/         \|__|         \/__/         \/__/     ~~

Contraintes :
> Pas de repas en double dans un restaurant
> nombre de repas variables
> quantité de calories optimale se rapprochant au plus du chiffre demandé à + ou - 15%

 */
public class MainActivity extends AppCompatActivity {

    private String kebab = "Kebab de chez Didier";
    private String legume = "Assiette de légumes de chez les filles";
    private String bigmac = "BigMac";
    private String pasta = "Plat de nouilles asiatiques";
    private String jaja = "Jaja : cuisine de bistrot chic";
    private String philosophes = "Les philosophes : produits locaux";
    private String chaise = "La Chaise au Plafond : café brasserie";
    private String monjul = "Monjul : plats créatifs";

    private Double kebabKcal = 8800.0;
    private Double legumeKcal = 12.0;
    private Double bigmacKcal = 323.0;
    private Double pastaKcal = 281.0;
    private Double jajaKcal = 581.0;
    private Double philosophesKcal = 468.0;
    private Double chaiseKcal = 488.0;
    private Double monjulKcal = 168.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ENREGISTREMENT DU JEU DE DEMONSTRATION DANS LA BDD
        Restaurant restauKebab = new Restaurant(kebabKcal, kebab);
        Restaurant restauLegume = new Restaurant(legumeKcal, legume);
        Restaurant restauBigmac = new Restaurant(bigmacKcal, bigmac);
        Restaurant restauPasta = new Restaurant(pastaKcal, pasta);
        Restaurant restauJaja = new Restaurant(jajaKcal, jaja);
        Restaurant restauPhilosophes = new Restaurant(philosophesKcal, philosophes);
        Restaurant restauChaise = new Restaurant(chaiseKcal, chaise);
        Restaurant restauMonjul = new Restaurant(monjulKcal, monjul);

        restauKebab.save();
        restauLegume.save();
        restauBigmac.save();
        restauPasta.save();
        restauJaja.save();
        restauPhilosophes.save();
        restauChaise.save();
        restauMonjul.save();

        // On récupère la liste des restaurants enregistrés
        List<Restaurant> restaurants = Restaurant.listAll(Restaurant.class);

        for(Restaurant r : restaurants){
            System.out.println("Test : " + r.getDescription() + " - " + r.getCalories());
        }









    }
}
