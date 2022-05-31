public class SortAnArray {
    public static void main(String[] args) {

    }

    public static int[] sortArray(int[] nums) {
        //create an array to store possible nums[i]
        int[] temp = new int[100001];

        //increase temp[i]
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i] + 50000]++;
        }

        //iterate temp[]
        int[] sorted = new int[nums.length];
        int index = 0;

        for (int i = 0; i < temp.length; i++) {
            while (temp[i] > 0) {
                sorted[index] = (i - 50000);
                index += 1;
                temp[i] -= 1;
            }
        }

        //return
        return sorted;


    }
}