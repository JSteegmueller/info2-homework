package main;

public class Node implements SortedFloatTree {
    private float element;
    private SortedFloatTree left;
    private SortedFloatTree right;

    public Node(float element, SortedFloatTree left, SortedFloatTree right) {
	this.element = element;
	this.left = left;
	this.right = right;
    }

    @Override
    public String asString() {
	String result = "";
	String leftString = left.asString();
	String rightString = right.asString();

	int leftWidth = maxLineWidth(leftString);
	int rightWidth = maxLineWidth(rightString);
	if (leftWidth == 0 && rightWidth > 0) // for trees that are out of balance
	    rightWidth = 3;
	// First line:
	String padding = " ".repeat(leftWidth);
	result = padding + Float.toString(element);
	int numberLength = Float.toString(element).length();
	padding = " ".repeat(rightWidth);
	result += padding + "\n";

	// Second line:
	if (leftWidth + rightWidth > 0) {
	    padding = " ".repeat(leftWidth / 2);
	    result += padding; // leading spaces
	    padding = "-".repeat(leftWidth - leftWidth / 2);
	    result += padding; // connection left
	    padding = " ".repeat(numberLength);
	    result += padding;
	    padding = "-".repeat(rightWidth - rightWidth / 2);
	    result += padding; // connection right
	    padding = " ".repeat(rightWidth / 2);
	    result += padding; // trailing spaces
	    result += "\n";

	    // Third line
	    padding = " ".repeat(Math.max(0, leftWidth - leftWidth / 2 - 1));
	    result += padding; // leading spaces
	    result += "|";
	    padding = " ".repeat(leftWidth / 2);
	    result += padding; // spaces to center
	    padding = " ".repeat(numberLength);
	    result += padding;
	    padding = " ".repeat(rightWidth / 2);
	    result += padding; // leading spaces (right)
	    result += "|";
	    padding = " ".repeat(Math.max(0, rightWidth / 2));
	    result += padding; // trailing spaces
	    result += "\n";

	    // childs
	    int startRightTree = leftWidth + numberLength;
	    if (leftWidth == 0) {
		startRightTree = numberLength + rightWidth / 2;
	    }
	    String joinedChilds = joinLines(leftString, rightString, startRightTree);
	    result += joinedChilds;
	}
	return result;
    }

    /**
     * Computes the length of the longest line in a String.
     * 
     * @param str The string with potentially multiple lines
     * @return The length of the longest line in the provided string.
     */
    private int maxLineWidth(String str) {
	int maxWidth = 0;
	for (String s : str.split("\n")) {
	    maxWidth = Math.max(maxWidth, s.length());
	}
	return maxWidth;
    }

    /**
     * Concatenates two strings line by line.
     * 
     * @param str1       First (left) string with potentially many lines
     * @param str2       Second (right) string with potentially many lines
     * @param rightStart Position where the second string starts. The first string
     *                   will be padded to this length.
     * @return A string that contains both, str1 and str2 next to each other.
     */
    private String joinLines(String str1, String str2, int rightStart) {
	String[] strings1 = str1.split("\n");
	String[] strings2 = str2.split("\n");

	String result = "";
	for (int i = 0; i < Math.min(strings2.length, strings1.length); i++) {
	    result += padToLength(strings1[i], rightStart) + strings2[i] + "\n";
	}
	for (int i = strings1.length; i < strings2.length; i++) {
	    result += padToLength("", rightStart) + strings2[i] + "\n";
	}
	for (int i = strings2.length; i < strings1.length; i++) {
	    result += padToLength(strings1[i], rightStart) + "\n";
	}

	return result;
    }

    /**
     * Appends spaces to pad a given string to a given length.
     * 
     * @param str    The string that will be padded.
     * @param length The length of the string after padding
     * @return The string str, but with the given length (padded on right side).
     */
    private String padToLength(String str, int length) {
	return String.format("%-" + length + "." + length + "s", str);
    }

    @Override
    public int depth() {
	// TODO: Compute the depth of the tree.
	return 0;
    }

    @Override
    public int nodeCount() {
	// TODO: Count the number of nodes in the tree.
	return 0;
    }

    @Override
    public boolean exists(float element) {
	// TODO: Check if an element exists in the tree.
	return false;
    }

    @Override
    public SortedFloatTree insert(float element) {
	// TODO: Create a tree, with the inserted element in the right place.
	return this;
    }
}
