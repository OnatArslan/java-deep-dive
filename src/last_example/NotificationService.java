package last_example;

import java.util.List;
import java.util.Map;

public class NotificationService {
    // subscribers: mesaj tipi -> o tipe abone e-postalar
    private final Map<String, List<String>> subscribers;
    
    public NotificationService(Map<String, List<String>> subscribers) {
        this.subscribers = subscribers;
    }
    
    // ❌ bu method iki tasarım hatası içeriyor — düzelteceksin
    List<String> findRecipients(String messageType) {
        List<String> result = subscribers.get(messageType);
        if (result == null) {
            return List.of();
        }
        return result;
    }
    
    void notify(String email, String message) {
        System.out.println("to " + email + " : " + message);
    }
    
    void notify(List<String> emails, String message) {
        if (emails == null) {
            throw new IllegalArgumentException("emails can not be null");
        }
        for (String email : emails) {
            notify(email, message);
        }
        
    }
    
}
