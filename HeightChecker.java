import java.util.Arrays;
public class HeightChecker {
    public static void main(String[] args) {
        int answer = heightChecker(new int[]{1, 1, 4, 2, 1, 3});
        System.out.println(answer);
    }

    public static int heightChecker(int[] heights) {


        //find max height
        int max = 0;
        for (int height : heights) {
            if (height > max) {
                max = height;
            }
        }
        //make a sorted array by heights
        int[] temp = new int[max + 1];
        for (int i = 0; i < heights.length; i++) {
            temp[heights[i]]++;
        }
        System.out.println(Arrays.toString(temp));

        int[] expected = new int[heights.length];
        int index = 0;
        for (int i = 1; i < max + 1; i++) {
            while (temp[i] > 0) {
                expected[index] = i;
                temp[i] -= 1;
                index += 1;
            }

        }
        System.out.println(Arrays.toString(expected));
        //find out heights[i] != expected[i]
        int countUnmatch = 0;
        for (int i = 0; i < expected.length; i++) {
            if (heights[i] != expected[i]) {
                countUnmatch += 1;
            }
        }

        return countUnmatch;

    }

}
