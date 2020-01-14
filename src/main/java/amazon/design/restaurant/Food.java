package amazon.design.restaurant;

public class Food {

    int foodId;
    String name;
    String description;
    Category category;
    double price;
    boolean isVege;

    public Food(int foodId, String name, String description, Category category, double price, boolean isVege) {
        this.foodId = foodId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.isVege = isVege;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isVege() {
        return isVege;
    }

    public void setVege(boolean vege) {
        isVege = vege;
    }
}
