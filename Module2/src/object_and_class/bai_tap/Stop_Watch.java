package object_and_class.bai_tap;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Stop_Watch {
    public static class Stopwatch {
        private long startTime;
        private long endTime;

        public long getStartTime() {
            return this.startTime;
        }

        public long getEndTime() {
            return this.endTime;
    }

        public long start() {
            System.out.println(java.time.LocalTime.now());
            return this.startTime = System.currentTimeMillis();
        }

        public long stop() {
            System.out.println(java.time.LocalTime.now());
            return this.endTime = System.currentTimeMillis();
        }

        public long getElapsedTime() {
            return getEndTime() - getStartTime();
        }
    }

    public static void main(String[] args) {
        Stopwatch stopWatch = new Stopwatch();
        int[] array = new int[100000];
        Random random = new Random();
        for (int i = 0 ; i < array.length ; i++){
            array[i] = random.nextInt(10000);
        }
        stopWatch.start();
        for (int j = 0 ; j < array.length ; j++){
            int min = array[j];
            for (int z = j + 1 ; z < array.length ; z++){
                if (min > array[z]){
                    int swap = min;
                    min = array[z];
                    array[z] = swap;
                }
            }
        }
        stopWatch.stop();
        System.out.println("Time to sort: " + stopWatch.getElapsedTime() + " Milisecond");
    }
}
