import java.util.Random;
import java.util.Scanner;

public class LineOfDominoes {
    public static void main(String[] args) {

        System.out.println("Enter in maximum pip size:");
        Scanner sc = new Scanner(System.in);
        int maxPipSize =  sc.nextInt();
        System.out.println("Enter in a random seed:");
        int seed = sc.nextInt();

        DominoSet d = new DominoSet(maxPipSize);


        System.out.println("Starting set");
        d.shuffle(seed);
        System.out.println(d);
        d.sortList();
        System.out.println("Final set");
        System.out.println(d);
        System.out.println("Number of dominoes left: " + d.getRemovedCount());


    }
}
