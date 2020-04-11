package ds.stack;

import java.io.*;
import java.util.*;

public class MaxAreaHistogram {

    static long largestRectangle(int[] h) {
        Stack<Integer> stack = new Stack();
        long area = 0, max_area = -1;
        int index, sIndex=0, i=0;
        stack.push(0);
        for(i=1; i<h.length; i++){
            if(stack.isEmpty() || h[i] >= h[stack.peek()]){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && h[i] < h[stack.peek()]) {
                    index = stack.pop();
                    area = h[index]*(stack.isEmpty()? i: i- stack.peek()-1);
                    if(area > max_area)
                        max_area = area;
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            index = stack.pop();
            if(!stack.isEmpty())
                sIndex = stack.peek();
            else
                sIndex = -1;
            area = h[index]*(i-sIndex-1);
            if(area > max_area)
                max_area = area;
        }
        return max_area;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int[] h = new int[n];

        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }

        long result = largestRectangle(h);
        System.out.println(result);
        scanner.close();
    }
}

