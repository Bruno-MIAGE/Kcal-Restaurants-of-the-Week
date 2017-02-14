package fr.com.lunches_of_the_week;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    // ELEMENTS
    private MaterialEditText nbKcal;
    private MaterialEditText nbLunches;
    private FrameLayout boutonTrouver;
    private Button boutonAjouter;

    // VALUES
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

    private String givenNumberOfKcal;
    private String nbLunch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boutonTrouver = (FrameLayout) findViewById(R.id.bouton_valider);
        boutonAjouter = (Button) findViewById(R.id.bouton_nouveauRestaurant);
        nbKcal = (MaterialEditText) findViewById(R.id.nbKcal);
        nbLunches = (MaterialEditText) findViewById(R.id.nbLunches);

        // On récupère la liste des restaurants enregistrés et on vérifie si la liste est vide
        List<Restaurant> restaurants = Restaurant.listAll(Restaurant.class);

        if(restaurants.isEmpty()){
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
        }

        boutonTrouver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RestaurantsActivity.class);

                givenNumberOfKcal = nbKcal.getText().toString();
                nbLunch =nbLunches.getText().toString();

                if(!givenNumberOfKcal.isEmpty() && !nbLunch.isEmpty() ){
                    intent.putExtra("nbKcal",givenNumberOfKcal);
                    intent.putExtra("nbLunch",nbLunch);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this.getApplication(), "Veuillez remplir les champs",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
