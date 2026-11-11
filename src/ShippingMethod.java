import java.util.HashMap;
import java.util.Map;

public enum ShippingMethod {
    SLOW("SL", "Slow shipping", 10_000),
    FAST("FS", "Fast shipping", 20_000),
    FROMSTORE("STR", "From store", 0)
    ;

    private static final Map<String, ShippingMethod> BY_CODE;

    private final String code; // all fields must be final because we are creating them in class (3 of them)
    private final String desc;
    private final long priceInCents;


    ShippingMethod(String code, String desc, long priceInCents) {
        this.code = code;
        this.desc = desc;
        this.priceInCents = priceInCents;
    }


    static {
        Map<String, ShippingMethod> byCode = new HashMap<>();

        for (var m : ShippingMethod.values()) {
            if (byCode.put(m.code, m) != null) {
                throw new IllegalArgumentException("duplicate value");
            }
        }
        BY_CODE = Map.copyOf(byCode); // encapsulation
    }


    public long forFee(long fee) {



        return switch (this) {
            case SLOW -> fee >= 500000 ? 0 : fee;
            case FAST -> fee;
            case FROMSTORE -> 0;
        };
    }

    public static ShippingMethod fromCode(String code) {
        ShippingMethod sm = BY_CODE.get(code);
        if (sm == null) {
            throw new IllegalArgumentException("invalid code given");
        }
        return sm;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public long getPriceInCents() {
        return priceInCents;
    }
}
