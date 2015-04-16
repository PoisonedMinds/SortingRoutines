package sortingroutines;

import javax.swing.*;

/**
 * @title SortingRoutines
 * @author Steven Biro
 * @teacher Mr. J. Carron
 * @date 9-Apr-2015 9:21:13 PM
 * @purpose The purpose of this program is to sort numbers 8 different ways
 */
public class SortingRoutines {

    public static void main(String[] args) {
        int type, direction, amount;//generate random numbers
        amount = Integer.parseInt(JOptionPane.showInputDialog("How many random numbers do you want to generate."));
        int nums[] = new int[amount], temp[] = new int[amount];
        System.out.print("The unsorted list is: ");//output the unsorted list
        for (int i = 0; i < amount; i++) {
            nums[i] = (int) (Math.random() * 1001);
            System.out.print(nums[i] + ", ");
        }
//gather info about how the numbers are to be sorted
        String buttons[] = {"Selection Sort", "Bubble Sort", "Insertion Sort", "Quick Sort"}, buttons2[] = {"Ascending", "Descending"};
        type = JOptionPane.showOptionDialog(null, "What algorithim do you want the numbers sorted with?", "Sorting Routines",
                JOptionPane.PLAIN_MESSAGE, 3, null, buttons, buttons[3]);
        direction = JOptionPane.showOptionDialog(null, "How would you like to sort the numbers?", "Sorting Routines",
                JOptionPane.PLAIN_MESSAGE, 3, null, buttons2, buttons2[0]);
        if (type == 0) {//execute different sorting algorithims 
            selectionSort(nums);
        } else if (type == 1) {
            bubbleSort(nums);
        } else if (type == 2) {
            insertionSort(nums);
        } else {
            quickSort(nums, 0, nums.length - 1);
        }
        if (direction == 1) {//switch direction of array if the user click descending
            for (int i = 0; i < amount; i++) {
                temp[i] = nums[amount - 1 - i];
            }
            nums = temp;
        }

        System.out.print("\nThe sorted list is: ");//output the sorted list
        for (int i = 0; i < amount; i++) {
            System.out.print(nums[i] + ", ");
        }
    }
//method that switches the place of 2 numbers in an int array

    public static void switchPlace(int nums[], int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
//method that calls switchPlaces if a smaller number is found before a larger one

    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {//cycle through all numbers
            for (int j = i + 1; j < nums.length; j++) {//cycle through all numbers to compare to
                if (nums[i] > nums[j]) {//compare the numbers
                    switchPlace(nums, i, j);
                }
            }
        }
    }
//method that call switchPlace if a smaller number is found after a larger one.

    private static void bubbleSort(int[] nums) {
        boolean check = false;//check to track when the algorithim is done
        for (int j = 1; j < nums.length; j++) {

            for (int i = 0; i < nums.length - 1; i++) {//cycle through all numbers
                if (nums[i] > nums[i + 1]) {//compare numbers
                    switchPlace(nums, i, i + 1);//call switchPlace
                    check = true;//trip the boolean check
                }
            }
            if (check == false) {
                break;//break if the method is doing nothing
            }
        }

    }
//method that iterates through the array, sorting it relative to the srounding number each time until the array is completely sorted

    private static void insertionSort(int[] nums) {
        int num, index;
        for (int i = 1; i < nums.length; i++) {//cycle through the second index to the last index
            index = i;
            num = nums[i];//stored number
            while (index > 0 && nums[index - 1] > num) {//if the index is before
//0 and the number that comes before tat index is great then the current one, move that number to the left 
                nums[index] = nums[index - 1];
                index--;
            }
            nums[index] = num;//place the stored number in the correct spot
        }

    }

    public static void quickSort(int nums[], int start, int end) {
        if (start < end) {//continue if the section is greater than 1
            int numb = split(nums, start, end);//find the place of a number
            quickSort(nums, start, numb - 1);//redo this with the number whoes spot was found
            quickSort(nums, numb + 1, end);

        }

    }

    public static int split(int nums[], int start, int end) {
        boolean left = true;//bolean to track which side to move
        int number = nums[start];//store number
        while (start < end) {//while the size is greater than 1
            if (left == true) {
                while ((nums[end] >= number) && (start < end)) {//while the number 
//at the end is larger or equal to the stored number and the section is greater than 1
                    end--;//make the section smaller
                }
                nums[start] = nums[end];//set the number at the start to the number at the end,because it is no longer bigger
                left = false;
            } else {
                while ((nums[start] <= number) && (start < end)) {//while the numner
//at the start is smaller or equal to the stored number and the section is larger than 1
                    start++;//make the section smaller
                }
                nums[end] = nums[start];//set the number at the start to the end, because it is no longer smaller
                left = true;
            }
        }
        nums[start] = number;//place the stored number in the correct spot
        return start;//return this spot
    }
}
