package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ellipse {
    static double one = 1.000;
    public static void main(String[] args) throws FileNotFoundException {

        String path1 = args[0];
        File file1 = new File(path1);
        String path2 = args[1];
        File file2 = new File(path2);
        Scanner sc = new Scanner(file1);
        Scanner sc2 = new Scanner(file2);

        ArrayList<String> ellips_coord = new ArrayList<>();
        while (sc.hasNext()) {
            ellips_coord.add(sc.next());
        }

        double x = Double.parseDouble(ellips_coord.get(0));
        double y = Double.parseDouble(ellips_coord.get(1));
        double a = Double.parseDouble(ellips_coord.get(2));
        double b = Double.parseDouble(ellips_coord.get(3));


        while (sc2.hasNextDouble()) {
            double x1 = sc2.nextDouble();
            if (sc2.hasNextDouble()) {
                double y1 = sc2.nextDouble();
                System.out.println(  ellipse(x,y,a,b,x1,y1) );
            }
        }
sc.close();
        sc2.close();
    }

    static int ellipse(double x, double y, double a, double b, double x1, double y1){
        if ((   Math.pow((x-x1), 2) / Math.pow(a,2)  ) + (   Math.pow((y-y1), 2) / Math.pow(b,2)    ) == one  ){
            return 0;
        }
        else if ((   Math.pow((x-x1), 2) / Math.pow(a,2)  ) + (   Math.pow((y-y1), 2) / Math.pow(b,2)    ) < one  ){
            return 1;
        }
        else {
            return 2;
        }
    }



}
