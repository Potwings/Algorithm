import java.util.Scanner;

public class test {


    public static int getNum(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }

        return getNum(num - 1) + getNum(num - 2);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        System.out.println(getNum(num));
    }


}
