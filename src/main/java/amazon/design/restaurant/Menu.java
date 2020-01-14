package amazon.design.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    List<Food> desserts;
    List<Food> entrees;
    List<Food> nonAlcohols;
    List<Food> alcohols;

    public Menu() {
        desserts = new ArrayList<>();
        entrees = new ArrayList<>();
        nonAlcohols = new ArrayList<>();
        alcohols = new ArrayList<>();
    }

    public void add(Food food) {
        switch (food.category) {
            case DESSERT:
                desserts.add(food);
                break;
            case ENTREE:
                entrees.add(food);
                break;
            case NON_ALCOHOL:
                nonAlcohols.add(food);
                break;
            case ALCOHOL:
                alcohols.add(food);
                break;
            default:
                break;
        }
    }

    public void delete(Food food) {
        switch (food.category) {
            case DESSERT:
                desserts.remove(food);
                break;
            case ENTREE:
                desserts.remove(food);
                break;
            case NON_ALCOHOL:
                nonAlcohols.remove(food);
                break;
            case ALCOHOL:
                alcohols.remove(food);
                break;
            default:
                break;
        }
    }

}
