package amazon.design.video.video;

public class Video {

    public Video() {
    }

    public Video(String id, String upc, String name, Category category, String company, String description, String director, String actors, int year, double price, String location, StockStatus status, QualityType type) {
        this.id = id;
        this.upc = upc;
        this.name = name;
        this.category = category;
        this.company = company;
        this.description = description;
        this.director = director;
        this.actors = actors;
        this.year = year;
        this.price = price;
        this.location = location;
        this.status = status;
        this.type = type;
    }

    private String id;
    private String upc;
    private String name;
    private Category category;
    private String company;
    private String description;
    private String director;
    private String actors;
    private int year;
    private double price;
    private String location;
    private StockStatus status;
    private QualityType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public StockStatus getStatus() {
        return status;
    }

    public void setStatus(StockStatus status) {
        this.status = status;
    }

    public QualityType getType() {
        return type;
    }

    public void setType(QualityType type) {
        this.type = type;
    }
}
