package meituan.jungel;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class XieCheng01 {

    static int[] arr = new int[2];
    static HashSet<Integer> set = new HashSet<>();
    static int[] divingBoard(int a,int b,int k) {


        arr[0]=a;
        arr[1]=b;
        helper(0,k);
        int[] result = new int[set.size()];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Integer integer : set) {
            queue.add(integer);
        }

        int i =0;
        while (queue.size()!=0) {
           result[i] = queue.remove();
           i++;
        }

        return result;
    }

    private static void helper(int res, int k) {

        if (k==0) {

            set.add(res);
            return;

        }

        for (int i : arr) {

            helper(res+i,k-1);

        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(JSON.toJSONString(divingBoard(a,b,k)));


    }


}