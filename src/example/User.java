package example;

import java.time.Instant;

public class User {
    private long id;
    private String name;
    private Instant createdAt;


    protected User(){

    }

    public User(long id, String name, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
