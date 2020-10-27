package com.company;

public class construct_the_rectangle {
    public static void test() {
        int test = 37;
        System.out.println(new construct_the_rectangle().constructRectangle(test));
    }
    public int[] constructRectangle(int area) {
        int ka = (int)Math.sqrt(area);
        if (ka * ka == area) {
            return new int[]{ka, ka};
        }
        for (int i = ka; i >= 1; i --) {
            if (area % ka == 0) {
                return new int[] { area / i, i};
            }
        }
        return new int[] {area, 1};
    }
}
