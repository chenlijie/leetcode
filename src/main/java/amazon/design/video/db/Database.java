package amazon.design.video.db;

import amazon.design.video.Store;
import amazon.design.video.person.Customer;
import amazon.design.video.person.Employee;
import amazon.design.video.person.Manager;
import amazon.design.video.person.Seller;
import amazon.design.video.video.*;

import java.util.*;

public class Database {

    private List<Video> videos;
    private Map<String, Video> videoMap;
    private List<Customer> customers;
    private Map<Integer, Customer> customerMap;
    private Map<Integer, Employee> employees;
    private Store store;

    public Database(Store store) {
        this.store = store;
        videos = new ArrayList<>();
        videoMap = new HashMap<>();

        Video v1 = new Video("Movie-Action-001", "38374232", "Rings", Category.ACTION, "HUA NA", "", "Tom", "Ana, Ketty", 2018, 10.0, "R1-S2-L3", StockStatus.ON_SHELF, QualityType.BLU_RAY);
        Video v2 = new Video("Movie-Action-002", "383a42d2", "Die Hard", Category.ACTION, "HUA NA", "", "Tom", "Ana, Ketty", 2017, 10.0, "R2-S2-L3", StockStatus.RENTED, QualityType.HD);
        Video v3 = new Video("Movie-Action-004", "3a374232", "Taken", Category.ACTION, "HUA NA", "", "Jerry", "Ana, Ketty", 2018, 10.0, "R1-S1-L3", StockStatus.ON_SHELF, QualityType.BLU_RAY);
        Video v4 = new Video("Movie-Action-005", "3837g23e", "The Matrix", Category.ACTION, "HUA NA", "", "Alicia", "Ana, Ketty", 1999, 10.0, "R3-S4-L5", StockStatus.NOT_AVAILABLE, QualityType.HD);

        videos.add(v1);
        videos.add(v2);
        videos.add(v3);
        videos.add(v4);
        videoMap.put(v1.getId(), v1);
        videoMap.put(v2.getId(), v2);
        videoMap.put(v3.getId(), v3);
        videoMap.put(v4.getId(), v4);

        employees = new HashMap<>();

        Employee e1 = new Manager();
        e1.setId(1);
        e1.setFirstName("Lijie");
        e1.setLastName("Chen");
        e1.setStore(store);

        Employee e2 = new Seller();
        e2.setId(2);
        e2.setFirstName("Yun");
        e2.setLastName("Fan");
        e2.setStore(store);

        employees.put(1, e1);
        employees.put(2, e2);

        customers = new ArrayList<>();
        customerMap = new HashMap<>();

        Customer c1 = new Customer();
        c1.setId(1);
        c1.setFirstName("John");
        c1.setLastName("Simth");
        c1.setStore(store);

        Customer c2 = new Customer();
        c2.setId(2);
        c2.setFirstName("Nichol");
        c2.setLastName("Moz");
        c2.setPhone("263497123");
        c2.setStore(store);

        customers.add(c1);
        customers.add(c2);

        customerMap.put(c1.getId(), c1);
        customerMap.put(c2.getId(), c2);
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public boolean addVideo(Video video) {
        videos.add(video);
        return true;
    }

    public List<Customer> getAllCustomer() {
        return customers;
    }

    public List<Video> search(String videoName, String director, String actor, int yearFrom, int yearTo) {
        List<Video> ans = new ArrayList<>();

        for (Video v : videos) {
            if (videoName != null && videoName.contains(videoName)) {
                ans.add(v);
                break;
            }
        }
        return ans;
    }

    public List<Customer> searchCustomer(String firstName, String lastName, String email, String phone) {
        List<Customer> ans = new ArrayList<>();
        for (Customer c : customers) {
            if (firstName != null && c.getFirstName().contains(firstName)) {
                ans.add(c);
                break;
            }
            if (lastName != null && c.getLastName().contains(lastName)) {
                ans.add(c);
                break;
            }
            if (email != null && c.getEmail().equals(email)) {
                ans.add(c);
                break;
            }
            if (phone != null && c.getPhone().equals(phone)) {
                ans.add(c);
                break;
            }
        }
        return ans;
    }

    public void save(Customer customer, List<RentVideo> videos) {
//        customer.getRentList().addAll(videos);
    }

    public void delete(Customer customer, List<RentVideo> videos) {
        for (RentVideo v : videos) {
            for (Iterator<RentVideo> it = customer.getRentList().iterator(); it.hasNext(); ) {
                RentVideo next = it.next();
                if (next.getId().equals(v.getId())) {
                    it.remove();
                    break;
                }
            }
        }
    }
}
