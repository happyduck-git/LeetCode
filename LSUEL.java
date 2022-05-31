import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LSUEL {
    public static void main(String[] args) {

        int[] students = {0, 0, 1, 1, 1, 0, 1, 1};
        int[] sandwiches = {1, 0, 0, 0, 1, 1, 1, 0};
        System.out.println(countStudents(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        List<Integer> studentList = Arrays.stream(students).boxed().collect(Collectors.toList());
        List<Integer> sandwichList = Arrays.stream(sandwiches).boxed().collect(Collectors.toList());

        LinkedList<Integer> studentLinked = new LinkedList<>(studentList);
        LinkedList<Integer> sandwichLinked = new LinkedList<>(sandwichList);

        int zeros = 0;
        int ones = 0;
        int zeros1 = 0;
        int ones1 = 0;

        for (int i = 0; i < studentLinked.size(); i++) {
            if (studentLinked.get(i) == 0) {
                zeros += 1;
            }
            if (studentLinked.get(i) == 1) {
                ones += 1;
            }
        }
        for (int i = 0; i < sandwichLinked.size(); i++) {
            if (sandwichLinked.get(i) == 0) {
                zeros1 += 1;
            }
            if (sandwichLinked.get(i) == 1) {
                ones1 += 1;
            }
        }

        //수량이 같은 경우
//        if (ones == ones1) {
//            return 0;
//        }

        //수량이 다른 경우
        for (int sandwich : sandwichLinked) {
            if (sandwich == 0) {
                if (zeros == 0) {
                    return ones;
                }
                zeros -= 1;
            } else {
                if (ones == 0) {
                    return zeros;
                }
                ones -= 1;
            }
        }
        return 0;
//
//        while(zeros1 != 0 && ones1 != 0 && zeros != 0 && ones != 0) {
//            if(studentLinked.get(0) == sandwichLinked.get(0)) {
//                if(studentLinked.get(0) == 1) {
//                    ones -= 1;
//                    ones1 -= 1;
//                } else {
//                    zeros -= 1;
//                    zeros1 -= 1;
//                }
//                studentLinked.poll();
//                sandwichLinked.poll();
//            } else {
//                studentLinked.offer(studentLinked.poll());
//            }
//        }
//
//        return studentLinked.size();

    }

}
