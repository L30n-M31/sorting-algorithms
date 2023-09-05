/*
------------------------------------------------------------------------------------------------------------------------
Repository: sorting-algorithms
Subject: Selection Sort
Details: This code demonstrates the algorithm used in Selection sort for sorting an array of Strings and integers
         in ascending and descending order.
------------------------------------------------------------------------------------------------------------------------
*/

public class SelectionSort {
    /**
     * In this code, the main method is only used purely for demonstration purposes.
     * - Two arrays of type String and int are instantiated respectively.
     */
    public static void main(String[] args) {
        SelectionSort execute = new SelectionSort();

        String[] stringArray = {"Emily", "Benjamin", "Sophia", "Liam", "Olivia", "Noah", "Ava", "William",
                "Isabella", "James"};

        int[] intArray = {42, 7, 99, 13, 256, 46, 100, 505, 72, 1345};

        System.out.println("//--------------------------");
        System.out.println("  SELECTION SORT FOR STRINGS");

        System.out.println("\n  Unsorted List:");
        execute.displayElements(stringArray);

        System.out.println("\n  Sorted List:");
        execute.selectionSort(stringArray);
        execute.displayElements(stringArray);

        System.out.println("//--------------------------\n");

        System.out.println("//---------------------------");
        System.out.println("  SELECTION SORT FOR INTEGERS");

        System.out.println("\n  Unsorted List:");
        execute.displayElements(intArray);

        System.out.println("\n  Sorted List:");
        execute.selectionSort(intArray);
        execute.displayElements(intArray);

        System.out.println("//---------------------------");
        System.exit(0);
    } // end of main method
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Sorts a given array of Strings in ascending order.
     * THINGS TO REMEMBER: Changing the inequality sign to "<" sets the array in descending order as long as "i" is
     *                     used first before "j" in the "if" statement.
     * - Some important notes are further explained at the end of the program.
     * @param array an array of type String
     */
    private void selectionSort(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex].compareToIgnoreCase(array[j]) > 0)
                    minIndex = j;
            }
            String temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    } // end of selectionSort method
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Sorts a given array of integers in ascending order.
     * THINGS TO REMEMBER: Changing the inequality sign to "<" sets the array in descending order as long as "i" is
     *                     used first before "j" in the "if" statement.
     * - Some important notes are further explained at the end of the program.
     * @param array an array of type int
     */
    private void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j])
                    minIndex = j;
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    } // end of selectionSort method
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
     * //-------------------------------------------------------------------------------------------------------------
     *   Selection sort starts by setting the minIndex equal to the first element of the array while the second element
     *   to be evaluated is determined by the lowest or highest element in the array depending on if it will be
     *   sorted in ascending or descending order starting from the first element moving to the right. The first for
     *   loop is in charge of setting the first element while the second for loop is in charge of determining the
     *   highest or lowest value. This two loops that sets the value of the array at minIndex and the array of the
     *   lowest element (ascending) enables the algorithm to swap the two.
     *
     *   It might be confusing at first, but this sorting algorithm will be easy to understand after a couple of
     *   implementations and deep analyzing. Basically, the sorting algorithm evaluates which among the elements
     *   is fit to be the element at the minimum index of the array. The sorting algorithm first sets the first element
     *   as the minIndex and evaluates the elements at it's right. In a scenario where the array will be sorted in
     *   ascending order, the algorithm will set a new minIndex upon confirming that the current element of the
     *   minIndex is indeed greater than the other element of the array and swaps the two. The newly established
     *   minIndex will again be checked on the elements at it's right, and it goes on as the sorting process is done.
     *   Another interesting fact is that if you noticed, the behavior of the bubble sort wherein it stores the highest
     *   value to the last index of the array and continues to store the second-highest value besides it is actually
     *   the same with this sorting method but backwards. Instead of storing the highest value on the last index of the
     *   array, the method actually finds the lowest element and stores it to the very first index of the array and
     *   continues to do so.
     *
     *   To get a better grasp of this rather confusing explanation, a visualization is given below. You need not to
     *   fully have in mind the statements that involve incrementing or decrementing a variable since it is just a
     *   guide if you want to know what value the variables are at on one point of the sorting process.
     * //-------------------------------------------------------------------------------------------------------------
     *   Visualization of how it works from a given array of four elements (8, 7, 9, 6) in ascending order
     *
     *   8     7     9     6   -> i = 0, j = 1
     *  [m]                    -> set minimum index to the value of "i" (minIndex = 0)
     *   8     7     9     6
     *  [m]---[j]              -> is "m greater than j"? (8 > 7)     Note: [m] is the minIndex here
     *   8     7     9     6   -> set the new minIndex equal to the index at "j". increment "j" (j = 2)
     *        [m]---[j]        -> is "m greater than j"? (7 > 9)     Note: [m] is the minIndex here
     *   8     7     9     6   -> retain the value of minIndex. increment "j" (j = 3)
     *        [m]---------[j]  -> is "m greater than j"? (7 > 6)     Note: [m] is the minIndex here
     *   8     7     9     6   -> set the new minIndex equal to the index at "j". increment "j" (j = 4)
     *  [i]---------------[m]  -> stop the second loop since j < 3 is false and swap the index at "i" and "m"
     *   6     7     9     8   -> the lowest value is in the correct position. increment "i" (i = 1)
     *
     *   6     7     9     8   -> i = 1, j = 2
     *        [m]              -> set minimum index to the value of "i" (minIndex = 1)
     *   6     7     9     8
     *        [m]---[j]        -> is "m greater than j"? (7 > 9)     Note: [m] is the minIndex here
     *   6     7     9     8   -> retain the value of minIndex. increment "j" (j = 3)
     *        [m]---------[j]  -> is "m greater than j"? (7 > 8)     Note: [m] is the minIndex here
     *   6     7     9     8   -> retain the value of minIndex. increment "j" (j = 4)
     *      [m & i]            -> stop the second loop since j < 3 is false. Don't swap since "m" and "i" are the same.
     *   6     7     9     8   -> the next lowest value is in the correct position. increment "i" (i = 2)
     *
     *   6     7     9     8   -> i = 2, j = 3
     *              [m]        -> set minimum index to the value of "i" (minIndex = 2)
     *   6     7     9     8
     *              [m]---[j]  -> is "m greater than j"? (9 > 8)     Note: [m] is the minIndex here
     *   6     7     9     8   -> set the new minIndex equal to the index at "j". increment "j" (j = 4)
     *              [i]---[m]  -> stop the second loop since j < 3 is false and swap the index at "i" and "m"
     *   6     7     8     9   -> the last lowest value is in the correct position. increment "i" (i = 3)
     *                            [stop the first loop since i < array.length - 1 is false]
     *   6     7     8     9   -> sorting complete
     * //-------------------------------------------------------------------------------------------------------------
     */
} // end of SelectionSort class
