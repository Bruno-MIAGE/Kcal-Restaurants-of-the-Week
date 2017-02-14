package fr.com.kcal_lunches_of_the_week;

import com.orm.SugarRecord;

/**
 * Created by Bruno VERALDI on 14/02/2017.
 */

public class Restaurant extends SugarRecord {
    Double calories;
    String description;

    public Restaurant() {
    }

    public Restaurant(Double calories, String description) {
        this.calories = calories;
        this.description = description;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
