package main;

public interface IntegerList {

    /**
     * Prints current list to System.out, e.g.: 0, 1, 2, 3, 4,
     */
    public void print();

    /** Returns length of list */
    public int length();

    /**
     * Appends an element to the end of the list.
     * 
     * @param element: Element to append to the end of the list
     * @return A new List with the appended element
     */
    public IntegerList append(int element);

    /**
     * Get the indexed element of the list. Similar to array access.
     * 
     * @param index: Index of the element that is retrieved.
     * @return The element at position @see index.
     * @throws Exception If list does not hold enough elements for desired index.
     */
    public int get(int index) throws Exception;

    /**
     * Insert an element at a specific element of an Array.
     * 
     * @param element Element to add at the position index.
     * @param index   The position where the index will be found later in the list.
     * @return A list where the element was added at the position of the given
     *         index.
     * @throws Exception If list does not hold enough elements to insert the element
     *                   at the desired position.
     */
    public IntegerList insert(int element, int index) throws Exception;

    /**
     * Removes the element from the given position.
     * 
     * @param index Index of the element to remove
     * @return List where the given element was removed.
     * @throws Exception If the list does not have a element at the specified
     *                   position.
     */
    public IntegerList deleteElement(int index) throws Exception;

    /**
     * Reverses the list.
     * 
     * @return A new list that is the reversed representation of this one.
     */
    public IntegerList reversed();

    /**
     * Extends the List by another List.
     * 
     * @param other The other list that is added at the end of this list.
     * @return A new list where the other list was appended to this list.
     */
    public IntegerList extend(IntegerList other);

    /**
     * Finds the minimum element in the List.
     * 
     * @return The smallest element in the List.
     */
    public int min();

    /**
     * Checks if the List is sorted or not.
     * 
     * @return True if list is sorted, False otherwise.
     */
    public boolean isSorted();
}
