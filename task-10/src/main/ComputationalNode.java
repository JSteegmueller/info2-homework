package main;

import java.util.Map;

public interface ComputationalNode {
	/** Evaluates the Node with the given unknowns.
	 * 
	 * @param unknowns A comma separated list of unknowns. E.g.
	 * "x = 2, y=12.22"
	 * @return The evaluated result of the node.
	 * @throws IllegalArgumentException if not all unknowns are given.
	 */
	double evaluate(String unknowns);
	
	/** Evaluates the Node with the given unknowns.
	 * 
	 * @param unknowns A Map of unknowns. If there was an unknown "x" it could be accessed with:
	 * unknowns.get("x")
	 * @return The evaluated result of the node.
	 * @throws IllegalArgumentException if not all unknowns are given.

	 */
	double evaluate(Map<String, Double> unknowns);
	
	/** Creates a new Node that represents the derivative of this node with respect to the given unknown.
	 * 
	 * @param unknown Compute the derivative with respect to this unknown.
	 * @return A new Node that represents the derivative of this node.
	 */
	ComputationalNode derivative(String unknown);
	
	/** Turns the node into a string. The operation is represented as operator.
	 * For example the Add node with parameters 2 and 5 would return "2 + 5".
	 * @return A string that describes the computation of this node.
	 */
	String toString();
	
	/** Cleans up the graph by removing unnecessary nodes. For example
	 * 0 * x^2 + 1 * x^1 - x^0  turns into x - 1
	 * Note: Some things can not easily be cleaned up like:
	 * 		 (0 - 1) - subtraction from zero (is needed for negative numbers)
	 * 		 2.0 * 3.0 * y^2.0 -  Multiplication of constants that are arranged such that not both
	 * 		 (2*(3*y^2))    	  children of the multiplication are constants.
	 * 		 Ignore those cases.
	 * @return A new, clean ComputationalNode. 
	 */
	ComputationalNode cleanUp();

	/** Is the node a zero. Only true for constant with value = 0.
	 * 
	 * @return true if node is a constant with value = 0.
	 */
	boolean isZero();
	
	/** Is the node a one. Only true for constant with value = 1.
	 * 
	 * @return true if node is a constant with value = 1.
	 */
	boolean isOne();

	/** Equals testet ob ein objekt einem anderen gleicht.
	 * ACHTUHNG: Diese Methode wird für die Unit Tests gebraucht,
	 * muss aber NICHT von Hand implementiert werden.
	 * Sie können die Methode von Eclipse generiren lassen nachdem Sie ihre Klasse fertig haben:
	 * Rechtsklick im code -> "Source" -> "generate hashCode() and equals()"
	 */
	public boolean equals(Object obj);
	public int hashCode();
}
