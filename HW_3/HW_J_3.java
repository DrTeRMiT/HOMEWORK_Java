package HW_3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class HW_J_3 {
    
    public static void main(String[] args) {
        ThreadLocalRandom randomNum = ThreadLocalRandom.current();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(randomNum.nextInt(0, 10));
        }
        System.out.printf("Array: %s\n", arr);
        ArrayList<Integer> res = mergeSort(arr);
        System.out.println(res);
    }

    private static ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
        int lMin;
        int rMin;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        if (array.size() == 1) {
            return array;
        }
        for (int i = 0; i < array.size(); i++) {
            if (i < (array.size() + 1) / 2) {
                left.add(array.get(i));
            } else {
                right.add(array.get(i));
            }
        }
        left = mergeSort(left);
        right = mergeSort(right);
        ArrayList<Integer> res = new ArrayList<>();
        while (left.size() > 0 || right.size() > 0) {
            if (left.size() > 0) {
                lMin = Collections.min(left);
                if (right.size() > 0) {
                    rMin = Collections.min(right);
                } else if (left.size() > 1) {
                    lMin = Collections.max(left);
                    rMin = Collections.min(left);
                } else {
                    res.add(lMin);
                    return res;
                }
            } else if (right.size() > 1) {
                lMin = Collections.max(right);
                rMin = Collections.min(right);
            } else {
                rMin = Collections.min(right);
                res.add(rMin);
                return res;
            }
            if (lMin < rMin) {
                res.add(lMin);
                if (left.size() > 0) {
                    left.remove((Object) lMin);
                } else {
                    right.remove((Object) rMin);
                }
            } else if (lMin > rMin) {
                res.add(rMin);
                if (right.size() > 0) {
                    right.remove((Object) rMin);
                } else {
                    left.remove((Object) rMin);
                }

            } else {
                res.add(lMin);
                left.remove((Object) lMin);
            }
        }
        System.out.println(res);
        return res;
    }
}
