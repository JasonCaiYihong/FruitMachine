import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FruitMachine {

    private String select() {
        Random rand = new Random();
        List<String> patterns = new ArrayList<>();
        patterns.add("apple");
        patterns.add("banana");
        patterns.add("grape");
        patterns.add("orange");
        patterns.add("lemon");
        patterns.add("cash");
        int index = rand.nextInt(patterns.size());
        String pattern = patterns.get(index);
        return pattern;
    }

    public int game() {
        int score = 0;
        String a = select();
        String b = select();
        String c = select();
        System.out.println(a + " " + b + " " + c);
        if ((a.equals("cash")) && (b.equals("cash")) && (c.equals("cash"))) {
            score = 5;
        } else if ((a.equals(b)) && (a.equals(c))) {
            score = 3;
        } else if ((a.equals(b)) || (a.equals(c)) || (b.equals(c))) {
            score = 1;
        }
        return score;
    }
}
