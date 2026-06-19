package last_example;

public class Order {
    private String status;
    private String title;

    public Order(String status, String title) {
        this.status = status;
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }
}
