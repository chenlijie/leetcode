package amazon.design.video.person;

import amazon.design.video.Store;
import amazon.design.video.video.Video;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Person {

    protected EmployeeType type;
    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;
    protected Store store;

    public void login() {
        loginTime = LocalDateTime.now();
    }

    public void logout() {
        logoutTime = LocalDateTime.now();
    }

    public boolean addVideo(Video video) {
        return store.addVideo(video);
    }

    public boolean removeVideo(Video video) {
        return store.removeVideo(video);
    }

    public void modifyVideo(Video video) {
        store.removeVideo(video);
    }

    public List<Video> search(String videoName, String director, String actor, int yearFrom, int yearTo) {
        return store.serch(videoName, director, actor, yearFrom, yearTo);
    }

    public List<Employee> getEmployeeInformation() {
        return new ArrayList<>();
    }

    public Employee getEmployeeInformation(String employeeId) {
        return null;
    }

    public List<Customer> getAllCustomer() {
        return new ArrayList<>();
    }

    public List<Customer> getCustomer(String firstName, String lastName, String email, String phone) {
        return store.getCustomer(firstName, lastName, email, phone);
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDateTime getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(LocalDateTime logoutTime) {
        this.logoutTime = logoutTime;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
