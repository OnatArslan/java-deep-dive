package last_example;

import java.util.ArrayList;
import java.util.List;

public final class Amount {
    private final long cents;
    private final String currency;
    
    public Amount(long cents, String currency) {
        if (currency == null || cents < 0) {
            throw new IllegalArgumentException("invalid parameters given");
        }
        
        this.cents = cents;
        this.currency = currency;
    }
    
    public long getCents() {
        return cents;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public Amount add(Amount other) {
        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException("invalid currency");
        }
        
        return new Amount(this.cents + other.cents, this.currency);
        
    }
    
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        
        myList.addAll(List.of(1, 2, 3, 4, 5));
        System.out.println(myList);
        
        
    }
}