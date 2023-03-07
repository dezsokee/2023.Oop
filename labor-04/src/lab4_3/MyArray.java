package lab4_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MyArray {
    private int length;
    private double elements[];

    public MyArray (int length)
    {
        this.length = length;
        elements = new  double[length];
    }

    public MyArray(double[] elements)
    {
        this.elements = elements;
        this.length = elements.length;
    }

    public MyArray (MyArray array)
    {
        this.length = array.length;
        this.elements = array.elements;
    }

    public MyArray (String file)
    {
        try (Scanner scanner = new Scanner(new File(file))){
            double actual_elements[] = new double[0];

            int i = 0;

            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                if (i == 0)
                {
                    this.length = Integer.parseInt(line.trim());
                    actual_elements = new double[this.length];
                    i++;
                }
                else
                {
                    String[] items = line.split(" ");
                    for (int j = 0; j < this.length; j++) {
                        actual_elements[j] = Double.parseDouble(items[j].trim());
                    }
                }
            }
            this.elements = actual_elements;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void fillRandom (double a, double b)
    {
        for (int i = 0; i < this.length; i++) {
            Random random = new Random();
            elements[i] = a + (b - a) * random.nextDouble();
        }
    }

    double mean ()
    {
        double sum = 0;

        for (int i = 0; i < this.length; i++) {
            sum += elements[i];
        }
        return sum / length;
    }

    double stddev()
    {
        double mean = mean();
        double sum = 0;

        for (int i = 0; i < this.length; i++) {
            sum += (elements[i] - mean) * (elements[i] - mean);
        }

        return Math.sqrt(sum / this.length);
    }

    void sort ()
    {
        Arrays.sort(elements);
    }

    void print(String text)
    {
        System.out.print(text);

        for (int i = 0; i < this.length; i++)
        {
            System.out.print(elements[i] + " ");
        }

        System.out.println();
    }
}
