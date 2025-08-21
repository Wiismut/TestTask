package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MinSteps {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = args[0];
        File file = new File(filePath);
        Scanner scf = new Scanner(file);
        ArrayList<Integer> nums = new ArrayList<>();
        while (scf.hasNext()) {
            nums.add(scf.nextInt());
        }


        scf.close();
        System.out.println(stepCounter(nums));

    }
    static String stepCounter (ArrayList<Integer> nums ){
        int[] stepsArr = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++){
            int sumStep = 0;
            for(int j = 0; j < nums.size(); j++) {
                sumStep += Math.abs(nums.get(i) - nums.get(j));
            }
            stepsArr[i] = sumStep;
        }
        int min = stepsArr[0];
        for(int i = 0; i< stepsArr.length; i++){
            if(stepsArr[i] < min){
                min = stepsArr[i];
            }
        }
        if(min > 20){
            return "20 ходов не достаточно для приведения всех элементов массива к одному числу";
        } else{
        return String.valueOf(min); }
    }

}
