
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ellipse {
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

        int x = Integer.parseInt(ellips_coord.get(0));
        int y = Integer.parseInt(ellips_coord.get(1));
        int a = Integer.parseInt(ellips_coord.get(2));
        int b = Integer.parseInt(ellips_coord.get(3));


        while (sc2.hasNextInt()) {
            int x1 = sc2.nextInt();
            if (sc2.hasNextInt()) {
                int y1 = sc2.nextInt();
                System.out.println(  ellipse(x,y,a,b,x1,y1) );
            }
        }
sc.close();
        sc2.close();
    }

    static int ellipse(int x, int y, int a, int b, int x1, int y1){
        if ((   Math.pow((x-x1), 2) / Math.pow(a,2)  ) + (   Math.pow((y-y1), 2) / Math.pow(b,2)    ) == 1  ){
            return 0;
        }
        else if ((   Math.pow((x-x1), 2) / Math.pow(a,2)  ) + (   Math.pow((y-y1), 2) / Math.pow(b,2)    ) < 1  ){
            return 1;
        }
        else {
            return 2;
        }
    }



}
