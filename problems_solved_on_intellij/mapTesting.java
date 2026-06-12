package problems_solved_on_intellij;
import java.util.*;
public class mapTesting {
    static void main() {

        // this shows HashMap handles null values too.

        String[] arr = {"My", "Name", "is", null, "Ranjan", "Sharma", ""};
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(); // uses LinkedHashMap for preserving order
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], i);
        }
        map.put(null, null); // before this line Output => {My=0, Name=1, is=2, null=3, Ranjan=4, Sharma=5, =6}

        System.out.println(map);
    }
}
