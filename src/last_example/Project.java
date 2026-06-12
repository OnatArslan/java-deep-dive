package last_example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project {
    private final String id;        // final → kimlik değişmez, setter imkânsız
    private final String name;      // final → ad değişmez
    private String status;          // final değil → archive() ile kuralla değişir
    private final Instant createdAt;
    
    // ana constructor
    public Project(String id, String name, String status) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.status = Objects.requireNonNull(status, "status must not be null");
        if (name.isBlank() || status.isBlank()) {
            throw new IllegalArgumentException("name and status must not be blank");
        }
        this.createdAt = Instant.now();
    }
    
    // kolaylık constructor → yeni proje ACTIVE doğar
    public Project(String id, String name) {
        this(id, name, "ACTIVE");
    }
    
    // davranış method'u: status'u KURALLA değiştirir, keyfi setter yok
    public void archive() {
        if (status.equals("ARCHIVED")) {
            throw new IllegalStateException("project already archived");
        }
        this.status = "ARCHIVED";
    }
    
    // oku ama değiştirme → getter var, setter yok
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getStatus() {
        return status;
    }
    
    public Instant getCreatedAt() {
        return createdAt;
    }
    
    List<Integer> varName = new ArrayList<>();
    
    public static void main(String[] args) {
        Project newProject = new Project("Example id", "Example name", "Example status");
        
    }
    
    
}