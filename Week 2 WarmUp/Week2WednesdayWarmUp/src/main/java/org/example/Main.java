package org.example;


public class Main {
    public static void main(String[] args) {
// setting the range to start at 1, end at 20 and count upwards
        for (int i = 1; i <= 20; i++) {
            //this will check for this even numbers by dividing by 2
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        int oddNumber = 0;
        while (oddNumber <= 19) {

            oddNumber++;
            //this will check for even #
            if (oddNumber % 2 == 0) {
                continue;
            }
            System.out.println(oddNumber);
        }

    }
}