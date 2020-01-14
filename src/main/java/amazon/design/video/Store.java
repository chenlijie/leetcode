package amazon.design.video;

import amazon.design.video.db.Database;
import amazon.design.video.person.Customer;
import amazon.design.video.person.Employee;
import amazon.design.video.video.RentVideo;
import amazon.design.video.video.Video;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {

    private LocalTime openTime;
    private LocalTime closeTime;
    private Map<Integer, Employee> employees;
    private Database db;

    public Store() {
        db = new Database(this);
        openTime = LocalTime.of(8, 0, 0);
        closeTime = LocalTime.of(21, 0, 0);
        employees = new HashMap<>();
        System.out.println("Store operation from " + openTime.toString() + " to " + closeTime.toString());
    }

    public Employee login(int employeeId) {
        //go to db fetch employee information by employeeId
        //create Employee instance and add to employees list
        Employee e = db.getEmployee(employeeId);
        employees.put(employeeId, e);
        return e;
    }

    public void logout(String employeeId) {

    }

    public boolean addVideo(Video video) {
        return db.addVideo(video);
    }

    public boolean removeVideo(Video video) {

        return false;
    }

    public void modifyVideo(Video video) {

    }

    public List<Employee> getEmployeeInformation() {
        return new ArrayList<>(employees.values());
    }

    public Employee getEmployeeInformation(int employeeId) {
        return employees.get(employeeId);
    }

    public List<Customer> getAllCustomer() {
        return db.getAllCustomer();
    }

    public List<Customer> getCustomer(String firstName, String lastName, String email, String phone) {
        return db.searchCustomer(firstName, lastName, email, phone);
    }

    public void rentVideos(Customer customer, List<RentVideo> videos) {
//        List<RentVideo> rentVideoList = new ArrayList<>();
//
//        for (Video v : videos) {
//            RentVideo r = new RentVideo();
//            r.setId(v.getId());
//            r.setActors(v.getActors());
//            r.setCompany(v.getCompany());
//            r.setCategory(v.getCategory());
//            r.setDescription(v.getDescription());
//            r.setName(v.getName());
//            r.setYear(v.getYear());
//            r.setUpc(v.getUpc());
//            r.setType(v.getType());
//            r.setDirector(v.getDirector());
//            r.setPrice(v.getPrice());
//            r.setLocation(v.getLocation());
//            rentVideoList.add(r);
//        }

        db.save(customer, videos);
    }

    public void returnVideos(Customer customer, List<RentVideo> videos) {
        db.delete(customer, videos);
    }

    public Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<Integer, Employee> employees) {
        this.employees = employees;
    }

    public List<Video> serch(String videoName, String director, String actor, int yearFrom, int yearTo) {
        return db.search(videoName, director, actor, yearFrom, yearTo);
    }
}
