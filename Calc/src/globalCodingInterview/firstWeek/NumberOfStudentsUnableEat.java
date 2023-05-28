package globalCodingInterview.firstWeek;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfStudentsUnableEat {
    public static void main (String[] args) {
        int result = countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1});
        System.out.println(result);
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = createStudentQueue(students);
        Queue<Integer> sandwichesQueue = createSandwichesQueue(sandwiches);

        int topSandwich = sandwichesQueue.peek();

        while(!studentQueue.isEmpty()) {
            int topStudent = studentQueue.poll();
            if (topSandwich == topStudent) {
                sandwichesQueue.poll();
            } else {
                studentQueue.add(topStudent);
            }
        }
        return studentQueue.size();
    }


    public static Queue<Integer> createStudentQueue(int[] students) {
        Queue<Integer> studentQueue = new LinkedList<>();
        for (int student : students) {
            studentQueue.add(student);
        }

        return studentQueue;
    }

    public static Queue<Integer> createSandwichesQueue(int[] sandwiches) {
        Queue<Integer> sandwichesQueue = new LinkedList<>();
        for (int sandwiche : sandwiches) {
            sandwichesQueue.add(sandwiche);
        }

        return sandwichesQueue;
    }
}
