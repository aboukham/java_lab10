package lab10;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DailyTemperatures {
    private static final int[] MONTHS_LENGTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] MONTHS_NAMES = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
        };
    public static void setTemperatures(double[] arr, DecimalFormat df){
        Random  rand = new Random();
        for (int i = 0; i < arr.length; i++){
            arr[i] = Double.parseDouble(df. format(rand.nextDouble() * 80));
        }
    }

    public static double[] findMaxMin(double[] arr){
        double max = arr[0];
        double min = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (max < arr[i])
                max = arr[i];
            else if (min > arr[i])
                min = arr[i];
        }
        return (new double[]{min, max});
    }

    public static double calcAverage(double[] arr){
        double sum = 0.0;
        for (double ele : arr)
            sum += ele;
        return sum / arr.length;
    }

    public static double[] sliceSubArray(double[] arr, int start, int end){
        double[]    subArr = new double[end - start];
        for (int i = start, j = i; i < end; i++){
            subArr[i - j] = arr[i];
        }
        return subArr;
    }

    public static void main(String[] args){
        double[]            temperatures = new double[365];
        double[]            minMax = new double[2];
        DecimalFormat       df = new DecimalFormat("0.00");
        Scanner             input = new Scanner(System.in);

        setTemperatures(temperatures, df);
        System.out.println(Arrays.toString(temperatures));
        minMax = findMaxMin(temperatures);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("The coldest temperature of the year is: " + minMax[0] + " Fahrenheit");
        System.out.println("The hottest temperature of the year is: " + minMax[1] + " Fahrenheit");
        System.out.println("----------------------------------------------------------------------------");
        for (int i = 0, start = 0; i < MONTHS_LENGTH.length; i++){
            double[]    month = sliceSubArray(temperatures, start, start + MONTHS_LENGTH[i]);
            minMax = findMaxMin(month);
            double avg = Double.parseDouble(df.format(calcAverage(month)));
            double difference = Double.parseDouble(df.format(minMax[1] - minMax[0]));
            System.out.println("The average temperature of " + MONTHS_NAMES[i] + " is: " + avg + " Fahrenheit");
            System.out.println("The difference between the hottest and coldest days of " + MONTHS_NAMES[i] + " is: " + difference + " Fahrenheit");
            start += MONTHS_LENGTH[i];
        }
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Enter a month number 1-12:");
        int mnth = input.nextInt();
        System.out.println("Enter a day number 1-31:");
        int day = input.nextInt();
        int index = day;
        for (int i = 1; i < mnth; i++) {
            index += MONTHS_LENGTH[i];
        }
        System.out.println("The according temperature to the entered day is:" + temperatures[index - 1] + " Fahrenheit");
       // System.out.println(Arrays.stream(arr).max());
        //System.out.println();
    }
}
