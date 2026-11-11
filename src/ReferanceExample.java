import java.util.ArrayList;
import java.util.List;

public class ReferanceExample {

    private List<String> names;

    public ReferanceExample(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
//        return names;
        return List.copyOf(this.names); // defensive copy
    }

    public static void main(String[] args) {
        ReferanceExample referanceExample = new ReferanceExample(new ArrayList<>(List.of("Sam", "Tom")));

        List<String> otherList =referanceExample.getNames();
        otherList.add("Cat");
        System.out.println(referanceExample.getNames()); // [Sam, Tom, Cat] encapsulation failed in here
                                                        // fix of this issue is return defansive copy

    }
}
