public class CircArr {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int n2 = Integer.parseInt(args[2]);
        int m2 = Integer.parseInt(args[3]);
        int i = 1;
        int j = 1;
        StringBuilder output1 = new StringBuilder();
        StringBuilder output2 = new StringBuilder();
        boolean stop1 = false;
        boolean stop2 = false;
        do{
            if(!stop1){
                output1.append(i);
                i = (i + m - 1);
                if(i > n){
                    i -= n;
                }
                if (i == 0) {
                    i = n;
                }
                if (i == 1){
                    stop1 = true;
                }
            }

            if(!stop2){
                output2.append(j);
                j = (j + m2 - 1);
                if(j > n2){
                    j -= n2;
                }
                if (j == 0) {
                    j = n2;
                }
                if (j == 1){
                    stop2 = true;
                }
            }

        }
        while (!stop1 || !stop2);

        System.out.print(output1.append(output2));

    }
}