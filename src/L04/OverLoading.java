package L04;

import java.util.Arrays;

public class OverLoading {
static int count =0;
    public OverLoading() {
    }

    public OverLoading(int a) {
        System.out.println("Hello");
    }

    public OverLoading(float b) {
        System.out.println("barak");
    }
    public OverLoading(float b,int a) {
        System.out.println("barak");
    }

    void print(int a,int b){
        System.out.println(a+b);
    }

    void print(String a,String b){
        System.out.println(a+b);
    }
}


class TestOverLoading{


    public static void main(String[] args) {
        OverLoading o = new OverLoading();
        int[] a = {1,2,3,4,5,6,7};
        int[][] a1 = {{1,2,3,4,5,6,7},{8,9,10,11,12,13}};
        System.out.println(a);
        System.out.println(a1);



    }
}
