package main;

public interface SortedFloatTree {
    /**
     * Creates a String representation of the tree that can be printed to the
     * console
     * 
     * @return A String representation of the tree.
     */
    public String asString();

    /**
     * Computes the depth of the tree.
     * 
     * @return Depth of the tree.
     */
    public int depth();

    /**
     * Computes the total number of nodes in the Tree. The tree must be traversed
     * completely for this task.
     * 
     * @return The number of nodes in the Tree.
     */
    public int nodeCount();

    /**
     * Checks if a given element is stored in the Tree. Use the fact that the tree
     * is sorted!
     * 
     * @param element The element that is being searched for.
     * @return True if element is found, false otherwise.
     */
    public boolean exists(float element);

    /**
     * Inserts a new element into the sorted tree. Make sure that the tree is sorted
     * afterwards. This does not change the tree, but creates a new one instead! You
     * don't have to balance the tree.
     * 
     * @param element The new element that will be added to the tree.
     * @return A new tree, that holds the new element at the correct position.
     */
    public SortedFloatTree insert(float element);
}
