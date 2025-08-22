package day05;

import java.util.Arrays;

public class Lotto {

    public int[] result() {
        int[] arr = new int[6];

        for (int i = 0; i < 6; i++) {
            arr[i] = (int)( Math.random() * 45 ) + 1;
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        Lotto lt = new Lotto();
        System.out.println(Arrays.toString(lt.result()));
    }
}
