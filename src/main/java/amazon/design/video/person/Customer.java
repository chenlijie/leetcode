package amazon.design.video.person;

import amazon.design.video.Store;
import amazon.design.video.video.RentVideo;
import amazon.design.video.video.Video;

import java.util.List;

public class Customer extends Person {

    public Customer() {
    }

    private Store store;
    private List<RentVideo> rentList;
    private double totalPrice = 0.0;
    private double balance = 0.0;

    public double rentVideos(List<RentVideo> videos) {
        store.rentVideos(this, videos);
        System.out.println(this.getFirstName() + " rents below videos:");
        for (RentVideo v : videos) {
            System.out.println(v.getName());
        }

        double price = calculatePrice(videos) + balance;
        System.out.println("You need pay $ " + price);
        return price;
    }

    private double calculatePrice(List<RentVideo> videos) {
        double sum = 0.0;
        for (RentVideo v : videos) {
            sum += v.getPrice();
        }
        return sum;
    }

    public double returnVideos(List<Video> videos) {

        return 0.0;
    }


    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<RentVideo> getRentList() {
        return rentList;
    }

    public void setRentList(List<RentVideo> rentList) {
        this.rentList = rentList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
