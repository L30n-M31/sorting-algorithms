/*
-----------------------------------------------------------------------------------------------------------------------
Repository: sorting-algorithms
Subject: Merge Sort
Details: This code demonstrates the algorithm used in merge sort for sorting an array of Strings and integers
         in ascending and descending order.
-----------------------------------------------------------------------------------------------------------------------
*/

public class MergeSort {
    /**
     * The main method is only used purely for demonstration purposes.
     * - Two arrays of type String and int are instantiated respectively.
     */
    public static void main(String[] args) {
        MergeSort execute = new MergeSort();

        String[] stringArray = {"Emily", "Benjamin", "Sophia", "Liam", "Olivia", "Noah", "Ava", "William",
                "Isabella", "James"};

        int[] intArray = {42, 7, 99, 13, 256, 46, 100, 505, 72, 1345};

        System.out.println("//----------------------");
        System.out.println("  MERGE SORT FOR STRINGS");

        System.out.println("\n  Unsorted List:");
        execute.displayElements(stringArray);

        System.out.println("\n  Sorted List:");
        execute.sort(stringArray, 0, stringArray.length - 1);
        execute.displayElements(stringArray);

        System.out.println("//----------------------\n");

        System.out.println("//-----------------------");
        System.out.println("  MERGE SORT FOR INTEGERS");

        System.out.println("\n  Unsorted List:");
        execute.displayElements(intArray);

        System.out.println("\n  Sorted List:");
        execute.sort(intArray, 0, intArray.length - 1);
        execute.displayElements(intArray);

        System.out.println("//-----------------------");
        System.exit(0);
    } // end of main method

//----------------------------------------------------------------------------------------------------------------------
    /**
     * Merges two sub-arrays of type String
     * THINGS TO REMEMBER: Changing the inequality sign to "<" sets the array in descending order as long as
     *                     "right[j]" is used first before "left[i]" in the "if" statement.
     * - Some important notes are further explained at the end of the program.
     * @param array an array of type String
     * @param l leftmost index of the array
     * @param m middlemost index of the array
     * @param r rightmost index of the array
     */
    private void merge(String[] array, int l, int m, int r) {
        // find the respective sizes of the two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // create the temp arrays
        String left[] = new String[n1];
        String right[] = new String[n2];

        // copy the data to the temp arrays
        for (int i = 0; i < n1; i++)
            left[i] = array[l + i];
        for (int j = 0; j < n2; j++)
            right[j] = array[m + 1 + j];

        // merge the temp arrays
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (right[j].compareToIgnoreCase(left[i]) > 0) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        } // end of while

        // copy the remaining elements of left[] if there are any
        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }

        // copy the remaining elements of right[] if there are any
        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
        }
    } // end of merge method

//----------------------------------------------------------------------------------------------------------------------
    /**
     * Merges two sub-arrays of type int
     * THINGS TO REMEMBER: Changing the inequality sign to "<" sets the array in descending order as long as
     *                     "right[j]" is used first before "left[i]" in the "if" statement.
     * - Some important notes are further explained at the end of the program.
     * @param array an array of type int
     * @param l leftmost index of the array
     * @param m middlemost index of the array
     * @param r rightmost index of the array
     */
    private void merge(int[] array, int l, int m, int r) {
        // find the respective sizes of the two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // create the temp arrays
        int left[] = new int[n1];
        int right[] = new int[n2];

        // copy the data to the temp arrays
        for (int i = 0; i < n1; i++)
            left[i] = array[l + i];
        for (int j = 0; j < n2; j++)
            right[j] = array[m + 1 + j];

        // merge the temp arrays
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (right[j] > left[i]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        } // end of while

        // copy the remaining elements of left[] if there are any
        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }

        // copy the remaining elements of right[] if there are any
        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
        }
    } // end of merge method
// ---------------------------------------------------------------------------------------------------------------------
    /**
     * The main function that sorts the array of type String by invoking the merge() method
     * @param array an array of type String
     * @param l leftmost index of the array
     * @param r rightmost index of the array
     */
    private void sort(String[] array, int l, int r) {
        if (l < r) {
            // find the middle point
            int m = l + (r - l) / 2;

            // sort the first and second halves
            sort(array, l, m);
            sort(array, m + 1, r);

            // merge the sorted halves
            merge(array, l, m, r);
        }
    } // end of sort method
//----------------------------------------------------------------------------------------------------------------------
    /**
     * The main function that sorts the array of type int by invoking the merge() method
     * @param array an array of type int
     * @param l leftmost index of the array
     * @param r rightmost index of the array
     */
    private void sort(int[] array, int l, int r) {
        if (l < r) {
            // find the middle point
            int m = l + (r - l) / 2;

            // sort the first and second halves
            sort(array, l, m);
            sort(array, m + 1, r);

            // merge the sorted halves
            merge(array, l, m , r);
        }
    } // end of sort method
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
     *   Explanation to be added as soon as I have the time to do it on my free time.
     */
//----------------------------------------------------------------------------------------------------------------------
} // end of MergeSort class
