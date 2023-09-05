/*
------------------------------------------------------------------------------------------------------------------------
Repository: sorting-algorithms
Subject: Insertion Sort
Details: This code demonstrates the algorithm used in Insertion sort for sorting an array of Strings and integers
         in ascending and descending order.
------------------------------------------------------------------------------------------------------------------------
 */

public class InsertionSort {
    /**
     * In this code, the main method is only used purely for demonstration purposes.
     * - Two arrays of type String and int are instantiated respectively.
     */
    public static void main(String[] args) {
        InsertionSort execute = new InsertionSort();

        String[] stringArray = {"Emily", "Benjamin", "Sophia", "Liam", "Olivia", "Noah", "Ava", "William",
                "Isabella", "James"};

        int[] intArray = {42, 7, 99, 13, 256, 46, 100, 505, 72, 1345};

        System.out.println("//--------------------------");
        System.out.println("  INSERTION SORT FOR STRINGS");

        System.out.println("\n  Unsorted List:");
        execute.displayElements(stringArray);

        System.out.println("\n  Sorted List:");
        execute.insertionSort(stringArray);
        execute.displayElements(stringArray);

        System.out.println("//--------------------------\n");

        System.out.println("//---------------------------");
        System.out.println("  INSERTION SORT FOR INTEGERS");

        System.out.println("\n  Unsorted List:");
        execute.displayElements(intArray);

        System.out.println("\n  Sorted List:");
        execute.insertionSort(intArray);
        execute.displayElements(intArray);

        System.out.println("//---------------------------");
        System.exit(0);
    } // end of main method
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Sorts a given array of Strings in ascending order.
     * THINGS TO REMEMBER: Changing the inequality sign to "<" sets the array in descending order as long as "j" is
     *                     used first before "key" in the "if" statement.
     * - Some important notes are further explained at the end of the program.
     * @param array an array of type String
     */
    private void insertionSort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            String key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].compareToIgnoreCase(key) > 0) {
                array[j + 1] = array[j];
                j -= 1;
            }
            array[j + 1] = key;
        }
    } // end of insertionSort method
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Sorts a given array of integers in ascending order.
     * THINGS TO REMEMBER: Changing the inequality sign to "<" sets the array in descending order as long as "j" is
     *                     used first before "key" in the "if" statement.
     * - Some important notes are further explained at the end of the program.
     * @param array an array of type int
     */
    private void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j -= 1;
            }
            array[j + 1] = key;
        }
    } // end of insertionSort method
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
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Displays all the elements of an array.
     * @param array an array of type int
     */
    private void displayElements(int[] array) {
        int elementNumber = 1;
        for (int element : array) {
            System.out.println("  " + elementNumber + ". " + element);
            elementNumber++;
        }
    } // end of displayElements method
//----------------------------------------------------------------------------------------------------------------------
    /**
     * //------------------------------------------------------------------------------------------------------------
     *   Insertion sort starts by checking the very first element of an array and compares it to the next element at
     *   it's right. Swapping occurs only if the conditional statement such as 7 > 6 is true (ascending order). After
     *   the swap, there is actually a while loop inside the for loop which executes to decrement the value of "j" if
     *   the condition is met (j >= 0 && array[i] > key). This causes the next element to shift to the left, so
     *   checking and swapping of elements continue now to the left as long as the while condition is met. If the while
     *   loop equates to false, the swapping continues again to the right since "i" would be incremented which is part
     *   of the for loop.
     *
     *   The insertion sort is interesting since the sorting behavior is almost identical to that of a bubble sort. The
     *   only difference between the two sorting algorithms is that bubble sort has a uni directional behavior
     *   (only goes to the right), whereas the insertion sort has a bidirectional behavior kind of like an uno reverse
     *   card where the direction changes. This means that the insertion sort has the ability to sort values going to
     *   the right then at some points, sort the elements going to the left depending on the conditional statement
     *   set in the while loop as stated in the previous paragraph.
     *
     *   To get a better grasp of this fun and interesting sorting method, a visualization is given below. You need
     *   not to fully have in mind the statements that involve incrementing or decrementing a variable since it is
     *   just a guide if you want to know what value the variables are at on one point of the sorting process.
     * //------------------------------------------------------------------------------------------------------------
     *   Visualization of how it works from a given array of five elements (8, 7, 9, 6) in ascending order
     *
     *   8     7     9     6   -> i = 1; j = 0
     *  [j]---[i]              -> is "j greater than i"? (8 > 7)
     *   7     8     9     6   -> swap the elements. decrement "j" (j = -1) [while loop stops so increment "i" (i = 2)]
     *        [j]---[i]        -> is "j greater than i"? (8 > 9)
     *   7     8     9     6   -> retain position. increment "i" (i = 3)
     *              [j]---[i]  -> is "j greater than i"? (9 > 6)
     *   7     8     6     9   -> swap the elements. decrement "j" (j = 1)
     *        [j]---[1]        -> is "j greater than [1]"? (8 > 6)     Note: [1] is [j + 1] here
     *   7     6     8     9   -> swap the elements. decrement "j" (j = 0)
     *  [j]---[1]              -> is "j greater than [1]"? (7 > 6)     Note: [1] is [j + 1] here
     *   6     7     8     9   -> swap the elements, decrement "j" (j = -1) [stop while loop since j <= 0], and
     *                            increment "i" (i = 4) [stop for loop since i < array.length is false].
     *   6     7     8     9   -> sorting complete
     * //------------------------------------------------------------------------------------------------------------
     */
} // end of InsertionSort class
