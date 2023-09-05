/*
-----------------------------------------------------------------------------------------------------------------------
Repository: sorting-algorithms
Subject: Balloon Sort
Details: This code demonstrates the algorithm used in Balloon sort for sorting an array of Strings and integers
         in ascending and descending order.
-----------------------------------------------------------------------------------------------------------------------
*/

public class BalloonSort {
    /**
     * The main method is only used purely for demonstration purposes.
     * - Two arrays of type String and int are instantiated respectively.
     */
    public static void main(String[] args) {
        BalloonSort execute = new BalloonSort();

        String[] stringArray = {"Emily", "Benjamin", "Sophia", "Liam", "Olivia", "Noah", "Ava", "William",
                "Isabella", "James"};

        int[] intArray = {42, 7, 99, 13, 256, 46, 100, 505, 72, 1345};

        System.out.println("//------------------------");
        System.out.println("  BALLOON SORT FOR STRINGS");

        System.out.println("\n  Unsorted List:");
        execute.displayElements(stringArray);

        System.out.println("\n  Sorted List:");
        execute.balloonSort(stringArray);
        execute.displayElements(stringArray);

        System.out.println("//------------------------\n");

        System.out.println("//-------------------------");
        System.out.println("  BALLOON SORT FOR INTEGERS");

        System.out.println("\n  Unsorted List:");
        execute.displayElements(intArray);

        System.out.println("\n  Sorted List:");
        execute.balloonSort(intArray);
        execute.displayElements(intArray);

        System.out.println("//-------------------------");
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
    private void balloonSort(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareToIgnoreCase(array[j]) > 0) {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    } // end of balloonSort method
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Sorts a given array of integers in ascending order.
     * THINGS TO REMEMBER: Changing the inequality sign to "<" sets the array in descending order as long as "i" is
     *                     used first before "j" in the "if" statement.
     * - Some important notes are further explained at the end of the program.
     * @param array an array of type int
     */
    private void balloonSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    } // end of balloonSort method
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
     *   Balloon sort starts by checking the very first element of an array and compares it to the next elements up to
     *   the last element. Swapping occurs only if the conditional statement such as 7 > 6 is true (ascending order).
     *   After the swap, the first index will have a different element and will be compared again to the next elements.
     *   the first index will only increment if and only if the second index (i.e. second element to be compared at
     *   index "j") reaches the last index of the array. If the first index increments, this means that the first index
     *   shifts to the right which is one point higher than the first time the sorting is initiated.
     *
     *   This sorting algorithm is not officially a sorting algorithm or strictly speaking, it is not mentioned by
     *   other authors. However, it is still a good idea to learn about this sorting algorithm to broaden your
     *   knowledge about more sorting techniques to be able to efficiently sort data depending on the scenario you are
     *   given.
     *
     *   To get a better grasp of this so-called unofficial sorting method, a visualization is given below. You need
     *   not to fully have in mind the statements that involve incrementing or decrementing a variable since it is
     *   just a guide if you want to know what value the variables are at on one point of the sorting process.
     * //------------------------------------------------------------------------------------------------------------
     *   Visualization of how it works from a given array of four elements (8, 7, 9, 6) in ascending order
     *
     *   8     7     9     6   -> i = 0, j = 1
     *  [i]---[j]              -> is "i greater than j"? (8 > 7)
     *   7     8     9     6   -> swap the elements. increment "j" (j = 2)
     *  [i]---------[j]        -> is "i greater than j"? (7 > 9)
     *   7     8     9     6   -> retain position. increment "j" (j = 3)
     *  [i]---------------[j]  -> is "i greater than j"? (7 > 6)
     *   6     8     9     7   -> swap the elements. increment "j" (j = 4) [second loop stops so increment "i" (i = 1)]
     *
     *   6     8     9     7   -> i = 1, j = 2
     *        [i]---[j]        -> is "i greater than j"? (8 > 9)
     *   6     8     9     7   -> retain position. increment "j" (j = 3)
     *        [i]---------[j]  -> is "i greater than j"? (8 > 7)
     *   6     7     9     8   -> swap the elements. increment "j" (j = 4) [second loop stops so increment "i" (i = 2)]
     *
     *   6     7     9     8   -> i = 2, j = 3
     *              [i]---[j]  -> is "i greater than j"? (9 > 8)
     *   6     7     8     9   -> swap the elements. increment "j" (j = 4) [second loop stops so increment "i" (i = 3)]
     *                            (first loop stops since "i" reached the length of the array)
     *   6     7     8     9   -> sorting complete
     * //------------------------------------------------------------------------------------------------------------
     */
} // end of BalloonSort class
