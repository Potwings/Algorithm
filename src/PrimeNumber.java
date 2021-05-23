import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int start = scanner.nextInt();

        int finish = scanner.nextInt();


        for (int i = start; i >= finish; i++) {

            int root = (int) (Math.sqrt(i));

            for (int j = 0; i >= root; j++) {

                List<Integer> numList = new ArrayList<>();

                if (i % j != 0) {

                    continue;


                } else {
                    break;
                }//end if

            }//end for

        }//end for


    }
}
