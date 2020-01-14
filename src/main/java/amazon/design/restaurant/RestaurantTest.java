package amazon.design.restaurant;

import amazon.design.restaurant.staff.Chef;
import amazon.design.restaurant.staff.Waitress;

import java.util.Arrays;

public class RestaurantTest {

    public static void main(String[] args) {
        Restaurant r = new Restaurant();

        Waitress w1 = (Waitress)r.waitresses.get(1);
        w1.checkIn(1);
        w1.placeOrder(1, Arrays.asList(1, 4, 9));

        Chef c1 = (Chef)r.chefs.get(1);
        c1.preparingOrder();
        c1.preparingOrder();

        w1.checkOut(1);

    }
}
