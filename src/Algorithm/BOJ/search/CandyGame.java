package Algorithm.BOJ.search;

import java.util.*;
import java.io.*;


public class CandyGame {
    static char [][] candy;
    static int leg;
    static int result;

    public static void swap(int i, int j, int n_i, int n_j) {
        char temp = candy[i][j];
        candy[i][j] = candy[n_i][n_j];
        candy[n_i][n_j] = temp;
    }

    public static int checkRow() {
        int count = 1;
        int row_max = 0;
        char check;

        for(int i=0; i<leg; i++) {

            check = candy[i][0];
            //System.out.println("i : "+i+" "+check);
            for(int j=1; j<leg; j++) {
                if(candy[i][j] == check) {
                    //System.out.println("checkRow 함수 실행 중 : "+i+ " " + j);
                    count++;
                } else {
                    //System.out.println(count);
                    row_max = Math.max(row_max, count);
                    count = 1;
                    check = candy[i][j];
                }

            }
            row_max = Math.max(row_max, count);
            count = 1;

        }

        return row_max;
    }
    public static int checkCol() {
        int count = 1;
        int col_max = 0;

        for(int i=0; i<leg; i++) {
            char check = candy[0][i];
            for(int j=1; j<leg; j++) {
                if(candy[j][i] == check) {
                    count++;
                } else {
                    col_max = Math.max(col_max, count);
                    count = 1;
                    check = candy[j][i];
                }

            }
            col_max = Math.max(col_max, count);
            count=1;

        }

        return col_max;
    }
    public static boolean isRange(int row, int col) {
        return (row>=0 && row< leg) && (col >= 0 && col < leg);
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        leg = Integer.parseInt(br.readLine());
        candy = new char [leg][leg];

        for(int i=0; i<leg; i++) {
            String str = br.readLine();
            char [] temp = str.toCharArray();
            for(int j=0; j<leg; j++) {
                candy[i][j] = temp[j];
            }
        }

        int [][] dir = {{-1, 0}, {0, -1}};
        //int [][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i=0; i<leg; i++) {
            for(int j=0; j<leg; j++) {
                for(int [] d : dir) {
                    int n_i = i+d[0];
                    int n_j = j+d[1];
                    if(isRange(n_i, n_j)) {
                        if(candy[i][j] != candy[n_i][n_j]) {
                            //System.out.println("i : "+i+" j : "+j+" n_i : "+n_i+" n_j : "+n_j);
                            char o_ij = candy[i][j];
                            char o_n = candy[n_i][n_j];
                            //System.out.println("swap 전 : "+candy[i][j]+ " "+ candy[n_i][n_j]);
                            swap(i, j, n_i, n_j);
                            //System.out.println("swap 후 : "+candy[i][j]+ " "+ candy[n_i][n_j]);
                            //System.out.println("checkRow : " + checkRow());
                            //System.out.println("checkCol : " + checkCol());
                            int temp_row = checkRow();
                            int temp_col = checkCol();
                            int temp_res = Math.max(temp_row, temp_col);

                            result = Math.max(result, temp_res);
                            //System.out.println(result);
                            swap(i, j, n_i, n_j);
                            //System.out.println("원래대로로 : "+candy[i][j]+ " "+ candy[n_i][n_j]);

                        }
                    }
                }
            }
        }
        System.out.println(result);

    }


}