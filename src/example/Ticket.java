package example;

import java.time.Instant;

public class Ticket {
    private long id;
    private String title;
    private Instant createdAt;
    
    
    public Ticket(long id, String title) {
        // we did null check here
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title is required");
        }
        
        this.title = title;
        this.id = id;
        this.createdAt = Instant.now();
    }
    
}
















































