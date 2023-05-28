package test;

import java.util.LinkedList;
import java.util.Queue;

public class CountStudentsUnableToEat {
    public static void main(String[] args) {
//        int[] students = {1,1,1,0,0,1};
//        int[] sandwiches = {1,0,0,0,1,1};
        int[] students = {1,1,0,0};
        int[] sandwiches = {0,1,0,1};

        int unableToEat = countStudents(students, sandwiches);
        System.out.println("Number of students unable to eat lunch: " + unableToEat);
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = createStudentQueue(students);
        Queue<Integer> sandwichesQueue = createSandwichesQueue(sandwiches);
        int unchangedCount = 0;

        while(!studentQueue.isEmpty()) {
            int topSandwich = sandwichesQueue.peek();
            int topStudent = studentQueue.poll();
            if (topSandwich == topStudent) {
                sandwichesQueue.poll();
                unchangedCount = 0;
            } else {
                studentQueue.add(topStudent);
                unchangedCount++;
            }

            if (unchangedCount == studentQueue.size() && unchangedCount == sandwichesQueue.size()) {
                break;
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
