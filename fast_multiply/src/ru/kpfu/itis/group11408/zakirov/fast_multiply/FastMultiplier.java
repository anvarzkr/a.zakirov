package ru.kpfu.itis.group11408.zakirov.fast_multiply;

/**
 * Created by Anvar on 16.02.2015.
 */
public class FastMultiplier {
    public static void main(String[] args) {
        int input = 16;

        boolean[][] halfs = getHalfs(input);

        for (boolean b[] : halfs) {
            for (boolean bo : b)
                System.out.print((bo) ? 1 : 0);
            System.out.println();
            System.out.println();
        }

    }

    public static boolean[][] getHalfs(int number){
        boolean[] leftBits = new boolean[16];
        boolean[] rightBits = new boolean[16];

        for (int i = 31, k = 0; i >= 0; i--, k++) {
            if (i > 15)
                leftBits[k] = (number & (1 << i)) != 0;
            else
                rightBits[k] = (number & (1 << i)) != 0;
            if (i == 16)
                k = -1;
        }

        return new boolean[][]{leftBits, rightBits};
    }
}
