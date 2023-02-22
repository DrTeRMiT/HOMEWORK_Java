package HW_1;
import java.util.Scanner;

public class HW_J_1 {

    public static void main(String[] args) {

        System.out.println(triangle(number()));
    }
    public static int number() {
           
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();
        in.close();
        
        return num;
    }

    
    public static int triangle(int n) {
        if(n==1)
            return 1;
        else
            return( n + triangle(n-1) );
    }

}

