import java.util.*;

public class test{
    public static void main(String[] args) {
        String str = "programming";
        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c); 
                result.append(c);
            }
        }
        System.out.println(seen);
    }
}
