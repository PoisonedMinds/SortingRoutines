package sortingroutines;

import javax.swing.*;

/**
 * @title SortingRoutines
 * @author Steven Biro
 * @teacher Mr. J. Carron
 * @date 9-Apr-2015 9:21:13 PM
 * @purpose The purpose of this program is to
 */
public class SortingRoutines {

    public static void main(String[] args) {
        int type, direction, amount;
        amount = Integer.parseInt(JOptionPane.showInputDialog("How many random numbers do you want to generate."));
        int nums[] = new int[amount], temp[] = new int[amount];
        System.out.print("The unsorted list is: ");
        for (int i = 0; i < amount; i++) {
            nums[i] = (int) (Math.random() * 1001);
            System.out.print(nums[i] + " ");
        }

        String buttons[] = {"Selection Sort", "Bubble Sort", "Insertion Sort", "Quick Sort"}, buttons2[] = {"Ascending", "Descending"};
        type = JOptionPane.showOptionDialog(null, "What algorithim do you want the numbers sorted with?", "Sorting Routines",
                JOptionPane.PLAIN_MESSAGE, 3, null, buttons, buttons[3]);
        direction = JOptionPane.showOptionDialog(null, "How would you like to sort the numbers?", "Sorting Routines",
                JOptionPane.PLAIN_MESSAGE, 3, null, buttons2, buttons2[0]);
        if (type == 0) {
            selectionSort(nums);
        } else if (type == 1) {
            bubbleSort(nums);
        } else if (type == 2) {
            insertionSort(nums);
        } else {
            quickSort(nums);
        }
        if (direction == 1) {
            for (int i = 0; i < amount; i++) {
                temp[i] = nums[amount-1-i];
            }
            nums = temp;
        }

        System.out.print("\nThe sorted list is: ");
        for (int i = 0; i < amount; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    public static void switchPlace(int nums[], int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    switchPlace(nums, i, j);
                }
            }
        }
    }

    private static void bubbleSort(int[] nums) {
        int counter;
        do {
            counter = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    switchPlace(nums, i, i + 1);
                }
                counter++;
            }
        } while (counter != 0);

    }

    private static void insertionSort(int[] nums) {
        int num,index;
        for (int i =1;i<nums.length;i++) {
            index=i;
            num=nums[i];
            while (index>0&&nums[index-1]>num) {
                nums[index]=nums[index-1];                
                index--;                
            }
            nums[index]=num;
        }
    
    }

    private static void quickSort(int[] nums) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
