package amazon.design.video;

import amazon.design.video.person.Customer;
import amazon.design.video.person.Employee;
import amazon.design.video.video.*;

import java.util.ArrayList;
import java.util.List;

public class VideoStoreTest {

    public static void main(String[] args) {
        Store store = new Store();
        Employee manager = store.login(1);
        Employee seller = store.login(2);

        manager.getEmployeeInformation();
        seller.getEmployeeInformation();

        List<Customer> customer = seller.getCustomer("John", null, null, null);
        List<Video> videos = seller.search("Matrix", null, null, 0, 0);

        List<RentVideo> rentVideoList = new ArrayList<>();
        for (Video v : videos) {
            RentVideo r = new RentVideo();
            r.setId(v.getId());
            r.setActors(v.getActors());
            r.setCompany(v.getCompany());
            r.setCategory(v.getCategory());
            r.setDescription(v.getDescription());
            r.setName(v.getName());
            r.setYear(v.getYear());
            r.setUpc(v.getUpc());
            r.setType(v.getType());
            r.setDirector(v.getDirector());
            r.setPrice(v.getPrice());
            r.setLocation(v.getLocation());
            rentVideoList.add(r);
        }
        customer.get(0).rentVideos(rentVideoList);

        Video v1 = new Video("Movie-Action-001", "38374232", "Rings", Category.ACTION, "HUA NA", "", "Tom", "Ana, Ketty", 2018, 10.0, "R1-S2-L3", StockStatus.ON_SHELF, QualityType.BLU_RAY);
        System.out.println(v1.getCategory().getParent());
    }
}
