package oop.labor01;

public class Main {
    public static void main(String[] args) {
        System.out.println("Labor 1 - 1. feladat");
        System.out.println("Dezso Szabolcs");

        System.out.println("Labor 1 - 2. feladat");
        String name = "Dezso Szabolcs";
        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.charAt(i));
        }

        System.out.println("Labor 1 - 3. feladat");

        String name2 = "Joe Donald Biden";
        String[] splitName = name2.split(" ");

        for (int i = 0; i < splitName.length; i++) {
            System.out.println("\t" + splitName[i]);
        }

        System.out.println("Labor 1 - 4. feladat");
        String word = "TREE";

        for (int i = 0; i < word.length(); i++) {
            System.out.println(word.substring(0, i+1));
        }
        System.out.println();

        System.out.println("Labor 1 - 5. feladat");

        double[] x = {7, 1, -3, 45, 9};
        System.out.println("Max element: " + maxElement(x));
        System.out.println();

        System.out.println("Labor 1 - 6. feladat");

        int order = 0;
        System.out.println("In the " + order + " position the bit is: " + getBit(13,order));
        System.out.println();

        System.out.println("Labor 1 - 7. feladat");
        System.out.println("The number of 1 bits in the number: " + countBits(13));
        System.out.println();

        System.out.println("Labor 1 - 8. feladat");
        System.out.println("The mean of the array is: " + mean(x));
        System.out.println();

        System.out.println("Labor 1 - 9. feladat");
        System.out.println("The devitation of the array is: " + stdev(x));
        System.out.println();

        System.out.println("Labor 1 - 10. feladat");
        System.out.println("The two largest element of the array is");
        double[] max_element = max2(x);

        for (int i = 0; i < max_element.length; i++) {
            System.out.print(max_element[i] + " ");
        }
        System.out.println();

    }

    public static byte getBit(int number, int order)
    {
        if (order < 0 || order > 32)
        {
            return -1;
        }
        else
        {
            return (byte)(number >> order & 1);
        }
    }

    public static double maxElement(double array[]) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int countBits(int number) {
        int sum = 0;

        while (number != 0)
        {
            if (number % 2 == 1)
            {
                sum ++;
            }
            number /= 2;
        }
        return sum;
    }

    public static double mean(double array[])
    {
        if (array.length == 0)
        {
            return Double.NaN;
        }

        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum / array.length;
    }

    public static double stdev(double array[])
    {
        double mean = mean(array);
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += (array[i] - mean) * (array[i] - mean);
        }

        double stdev = Math.sqrt(sum / array.length);

        return stdev;
    }

    public static double[] max2(double[] array){
        double[] max = {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY};
        if( array.length == 0 ){
            return max;
        }
        else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] > max[0])
                {
                    if (max[1] < max[0])
                    {
                        double v = max[1];
                        max[1] = max[0];
                        max[0] = v;
                    }
                    max[0] = array[i];

                }
                else if (array[i] > max[1])
                {
                    max[1] = array[i];
                }
            }
        }
        return max;
    }
}
