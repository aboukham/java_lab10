package lab10;

import java.util.Scanner;

public class StandardDeviation{

    public static double arrayAverage(double[] arr){
        int     sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum / arr.length;
    }

    public static void main(String[] args){
        Scanner     input = new Scanner(System.in);
        int         size;
        double[]    arr;
        double      sd = .0;
        double      avg;

       System.out.println("Enter size of array:");
       size = input.nextInt();
       arr = new double[size];
        System.out.println("Enter " + size + " real numbers:");
       for (int i = 0; i < size; i++)
           arr[i] = input.nextDouble();
       avg = arrayAverage(arr);
       for (int i = 0; i < size; i++){
           sd += Math.pow((arr[i] - avg), 2);
       }
       sd = Double.parseDouble(String.format("%.3f", Math.sqrt(sd / size)));
       System.out.println("The standard deviation of entered values is: sd = " + sd);
    }
}
