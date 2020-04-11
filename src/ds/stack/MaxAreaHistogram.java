package ds.stack;

import java.io.*;
import java.util.*;

public class MaxAreaHistogram {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        Stack<Integer> stack = new Stack();
        long area = 0, max_area = -1;
        stack.push(h[0]);
        for(int i=1; i<h.length; i++){
            if(h[i] >= h[stack.peek()]){
                stack.push(i);
            }
            else{
                while(h[i] < h[stack.peek()]){
                    int index = stack.pop();
                    area = h[index]*(i-index);
                    if(area > max_area)
                        max_area = area;
                }
            }
        }
        return max_area;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

