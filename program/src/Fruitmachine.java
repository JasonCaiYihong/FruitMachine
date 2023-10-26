import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fruitmachine {
    private String select(){
        Random random=new Random();
        List<String>patterns=new ArrayList<>();
        patterns.add("apple");
        patterns.add("banana");
        patterns.add("grape");
        int index= random.nextInt(patterns.size());
        String pattern= patterns.get(index);
        return pattern;
    }


    private void game(){
        String a=select();
        String b=select();
        String c=select();
        System.out.println(a+" "+b+" "+c);
    }


    public static void main(String[] args) {
        Fruitmachine fruitmachine=new Fruitmachine();
        fruitmachine.game();
    }
}
