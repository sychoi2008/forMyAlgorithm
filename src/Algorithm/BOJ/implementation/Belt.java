package Algorithm.BOJ.implementation;

public class Belt {
    static int [] temp;
    public static void main(String[] args) {
        temp = new int []{1,2};
        for(int i=0; i<temp.length; i++) System.out.print(temp[i]);
        System.out.println();
        change();
        for(int i=0; i<temp.length; i++) System.out.print(temp[i]);
    }

    static void change() {
        int [] temp1 = {3,4};
        temp = temp1;
    }
}
