/*
------------------------------------------------------------------------------------------------------------------------
Repository: sorting-algorithms
Subject: Bubble Sort
Details: This code demonstrates the algorithm used in Bubble sort for sorting an array of Strings and integers
         in ascending and descending order.
------------------------------------------------------------------------------------------------------------------------
*/

public class BubbleSort {
    /**
     * In this code, the main method is only used purely for demonstration purposes.
     * - Two arrays of type String and int are instantiated respectively.
     */
    public static void main(String[] args) {
        BubbleSort execute = new BubbleSort();

        String[] stringArray = {"Emily", "Benjamin", "Sophia", "Liam", "Olivia", "Noah", "Ava", "William",
                "Isabella", "James"};

        int[] intArray = {42, 7, 99, 13, 256, 46, 100, 505, 72, 1345};

        System.out.println("//-----------------------");
        System.out.println("  BUBBLE SORT FOR STRINGS");

        System.out.println("\n  Unsorted List:");
        execute.displayElements(stringArray);

        System.out.println("\n  Sorted List:");
        execute.bubbleSort(stringArray);
        execute.displayElements(stringArray);

        System.out.println("//-----------------------\n");

        System.out.println("//------------------------");
        System.out.println("  BUBBLE SORT FOR INTEGERS");

        System.out.println("\n  Unsorted List:");
        execute.displayElements(intArray);

        System.out.println("\n  Sorted List:");
        execute.bubbleSort(intArray);
        execute.displayElements(intArray);

        System.out.println("//------------------------");
    } // end of main method
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Sorts a given array of Strings in ascending order.
     * THINGS TO REMEMBER: Changing the inequality sign to "<" sets the array in descending order as long as "j" is
     *                     used first before "j + 1" in the "if" statement.
     * - Some important notes are further explained at the end of the program.
     * @param array an array of type String
     */
    private void bubbleSort(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareToIgnoreCase(array[j + 1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array [j + 1] = temp;
                }
            }
        }
    } // end of bubbleSort method
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Sorts a given array of integers in ascending order.
     * THINGS TO REMEMBER: Changing the inequality sign to "<" sets the array in descending order as long as "j" is
     *                     used first before "j + 1" in the "if" statement.
     * - Some important notes are further explained at the end of the program.
     * @param array an array of type int
     */
    private void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    } // end of bubbleSort method
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Displays all the elements of an array.
     * @param array an array of type String
     */
    private void displayElements(String[] array) {
        int elementNumber = 1;
        for (String element : array) {
            System.out.println("  " + elementNumber + ". " + element);
            elementNumber++;
        }
    } // end of displayElements method
// ---------------------------------------------------------------------------------------------------------------------
    /**
     * Displays all the elements of an array.
     * @param array an array of type String
     */
    private void displayElements(int[] array) {
        int elementNumber = 1;
        for (int element : array) {
            System.out.println("  " + elementNumber + ". " + element);
            elementNumber++;
        }
    } // end of displayElements method
// ---------------------------------------------------------------------------------------------------------------------
    /**
     * //-------------------------------------------------------------------------------------------------------------
     *   Bubble sort starts by checking the very first element of an array and compares it to the next element at it's
     *   right. Swapping occurs only if the conditional statement such as 7 > 6 is true (ascending order). After the
     *   swap, the checking goes one step to the right. This means that the next two elements will be the next values
     *   to be checked by the sorting algorithm. If the last element is reached, the highest element (ascending order)
     *   is stored at the very last index of the array and will force the algorithm to decrease the highest index to be
     *   evaluated. As far as the bubble sort algorithm is concerned, the program does not need to re-evaluate the
     *   highest element due to the fact that it is already stored in the proper location.
     *
     *   The bubble sort is a bit tricky due to the fact that both the bubble sort and balloon sort algorithms
     *   have the same structure. The only difference in the bubble sort is that "i" is not being used in the swapping
     *   of elements, but rather "j + 1". This is because the second for loop sets "j" equal to 0 while only executing
     *   the stated loop as long as "j" is less than the length of the array minus the value of "i" and minus the 1.
     *   Therefore, upon the first execution of the loop, the values of "i" and "j" are both 0. It is pointless
     *   to evaluate array[i] and array[j] together since they both have the same indexes. To remedy this, "i" is
     *   disregarded and replaced by "j" as the new "i" and "j + 1" being the new "j". To sum it up,
     *   array[i] > array[j] ([0] > [0]) becomes array[j] > array[j + 1] ([0] > [1]) in the conditional
     *   statement.
     *
     *   To get a better grasp of this tricky sorting method, a visualization is given below. You need not to fully
     *   have in mind the statements that involve incrementing or decrementing a variable since it is just a guide if
     *   you want to know what value the variables are at on one point of the sorting process.
     * //-------------------------------------------------------------------------------------------------------------
     *   Visualization of how it works from a given array of four elements (8, 7, 9, 6) in ascending order
     *
     *   8     7     9     6   -> i = 0, j = 0
     *  [j]---[1]              -> is "j greater than j + 1"? (8 > 7)     Note: [1] is [j + 1] here
     *   7     8     9     6   -> swap the elements. increment "j" (j = 1)
     *        [j]---[1]        -> is "j greater than j + 1"? (8 > 9)     Note: [1] is [j + 1] here
     *   7     8     9     6   -> retain position. increment "j" (j = 2)
     *              [j]---[1]  -> is "j greater than j + 1"? (9 > 6)     Note: [1] is [j + 1] here
     *   7     8     6     9   -> the highest value is in the correct position. increment "j" (j = 3)
     *                            [stop the second loop since j < 3 is false]. increment "i" (i = 1)
     *
     *   7     8     6     9   -> i = 1, j = 0 (highest index to be checked is reduced to 1, j < 2).
     *  [j]---[1]              -> is "j greater than j + 1"? (7 > 8)     Note: [1] is [j + 1] here
     *   7     8     6     9   -> retain position. increment "j" (j = 1)
     *        [j]---[1]        -> is "j greater than j + 1"? (8 > 6)     Note: [1] is [j + 1] here
     *   7     6     8     9   -> the next highest value is in the correct position. increment "j" (j = 2)
     *                            [stop the second loop since j < 2 is false]. increment "i" (i = 2)
     *
     *   7     6     8     9   -> i = 2, j = 0 (highest index to be checked is reduced to 1, j < 1).
     *  [j]---[1]              -> is "j greater than j + 1"? (7 > 6)     Note: [1] is [j + 1] here
     *   6     7     8     9   -> the next highest value is in the correct position. increment "j" (j = 1)
     *                            [stop the second loop since j < 1 is false]. increment "i" (i = 3)
     *                            [stop the first loop since i < array.length - 1 is false]
     *   6     7     8     9   -> sorting complete
     * //-------------------------------------------------------------------------------------------------------------
     */
} // end of BubbleSort class
