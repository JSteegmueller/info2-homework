package main;

public class ComputationalGraph {

	public static void main(String[] args) {
		/* TODO: You can uncomment those blocks step by step to test your implementation
		 * The expected output is always shown as comment

		// Test Constants
		System.out.println("Test Constants:");
		ComputationalNode constant1 = new Constant(1);
		ComputationalNode constant2 = new Constant(2);
		System.out.println("constant1.toString(): " 
				+ constant1.toString()); // 1.0
		System.out.println("constant2.toString(): " 
				+ constant2.toString()); // 2.0
		System.out.println("constant1.evaluate(\"\") = " 
				+ constant1.evaluate("")); // 1.0
		System.out.println("constant2.evaluate(\"\") = "
				+ constant2.evaluate("")); // 2.0
		System.out.println("constant1.derivative(\"x\").toString() = " 
				+ constant1.derivative("x").toString()); // 0.0
		System.out.println("constant2.derivative(\"x\").toString() = " 
				+ constant2.derivative("x").toString()); // 0.0

		// Test Unknown
		System.out.println("\nTest Variables:");
		ComputationalNode x = new Variable("x");
		ComputationalNode y = new Variable("y");
		System.out.println("x.toString(): "
				+ x.toString()); // x
		System.out.println("y.toString(): " 
				+ y.toString()); // y
		System.out.println("x.evaluate(\"x = 42\") = " 
				+ x.evaluate("x = 42")); // 42.0
		System.out.println("y.evaluate(\"y = 42\") = " 
				+ y.evaluate("y = 42")); // 42.0
		System.out.println("x.derivative(\"x\").toString() = "
				+ x.derivative("x").toString()); // 1.0
		System.out.println("x.derivative(\"y\").toString() = "
				+ x.derivative("y").toString()); // 0.0
		System.out.println("y.derivative(\"x\").toString() = "
				+ x.derivative("x").toString()); // 0.0
		System.out.println("y.derivative(\"y\").toString() = "
				+ x.derivative("y").toString()); // 1.0

		// Test Add		
		System.out.println("\nTest Add:");
		ComputationalNode add = new Add(constant1, constant2);
		System.out.println("add.toString(): "
				+ add.toString()); // (1.0 + 2.0)
		System.out.println("add.evaluate(\"\"): "
				+ add.evaluate("")); // 3.0
		System.out.println("add.derivative(\"x\").toString() = "
				+ add.derivative("x").toString()); // (0.0 + 0.0)
		System.out.println("add.derivative(\"x\").cleanUp().toString() = "
				+ add.derivative("x").cleanUp().toString()); // 0.0
		
		// Test Subtract		
		System.out.println("\nTest Subtract:");
		ComputationalNode subtract = new Subtract(constant1, constant2);
		System.out.println("subtract.toString(): "
				+ subtract.toString()); // (1.0 - 2.0)
		System.out.println("subtract.evaluate(\"\"): "
				+ subtract.evaluate("")); // 1.0
		System.out.println("subtract.derivative(\"x\").toString() = "
				+ subtract.derivative("x").toString()); // (0.0 - 0.0)
		System.out.println("subtract.derivative(\"x\").cleanUp().toString() = "
				+ subtract.derivative("x").cleanUp().toString()); // 0.0
		
		// Test Multiply		
		System.out.println("\nTest Multiply:");
		ComputationalNode multiply = new Multiply(constant1, constant2);
		System.out.println("multiply.toString(): "
				+ multiply.toString()); // (1.0 * 2.0)
		System.out.println("multiply.evaluate(\"\"): "
				+ multiply.evaluate("")); // 2.0
		System.out.println("multiply.derivative(\"x\").toString() = "
				+ multiply.derivative("x").toString()); // (0.0 * 2.0 + 1.0 * 0.0)
		System.out.println("multiply.derivative(\"x\").cleanUp().toString() = "
				+ multiply.derivative("x").cleanUp().toString()); // 0.0
		
		// Test Power		
		System.out.println("\nTest Power:");
		ComputationalNode power = new Power(constant2, 4);
		System.out.println("power.toString(): "
				+ power.toString()); // 2^4
		System.out.println("power.evaluate(\"\"): "
				+ power.evaluate("")); // 16.0
		System.out.println("power.derivative(\"x\").toString() = "
				+ power.derivative("x").toString()); // 4.0 * 2.0^3.0 * 0.0
		System.out.println("power.derivative(\"x\").cleanUp().toString() = "
				+ power.derivative("x").cleanUp().toString()); // 0.0
		
		// Test Divide		
		System.out.println("\nTest Divide:");
		ComputationalNode divide = new Divide(constant1, constant2);
		System.out.println("divide.toString(): "
				+ divide.toString()); // 1.0 / 2.0
		System.out.println("divide.evaluate(\"\"): "
				+ divide.evaluate("")); // 0.5
		System.out.println("divide.derivative(\"x\").toString() = "
				+ divide.derivative("x").toString()); // (0.0 * 2.0 - 1.0 * 0.0) / 2.0^2.0
		System.out.println("divide.derivative(\"x\").cleanUp().toString() = "
				+ divide.derivative("x").cleanUp().toString()); // 0.0

		// Test a simple equation "10x^2 - 3x + 2"
		System.out.println("\nTest a simple equation \"10x^2 - 3x + 2\"");
		ComputationalNode simpleEquation = new Add(
				new Subtract(
						new Multiply(
								new Constant(10), new Power(x, 2)),
						new Multiply(new Constant(3), x)),
				new Constant(2));
		System.out.println("simpleEquation.toString(): " 
				+ simpleEquation.toString()); // ((10.0 * x^2.0 - 3.0 * x) + 2.0)
		System.out.println("simpleEquation.evaluate(\"x = 0\"): " 
				+ simpleEquation.evaluate("x = 0")); // 2.0
		System.out.println("simpleEquation.evaluate(\"x = 2.5\") = "
				+ simpleEquation.evaluate("x = 2.5")); // 57.0
		ComputationalNode dfdx = simpleEquation.derivative("x"); // derivative of simpleEquation
		System.out.println("dfdx.toString(): "
				+ dfdx.toString()); // (((0.0 * x^2.0 + 10.0 * 2.0 * x^1.0 * 1.0) - (0.0 * x + 3.0 * 1.0)) + 0.0)
		System.out.println("dfdx.cleanUp().toString(): "
				+ dfdx.cleanUp().toString()); // (10.0 * 2.0 * x - 3.0)
		dfdx = dfdx.cleanUp();
		System.out.println("dfdx.evaluate(\"x = 0\"): "
				+ dfdx.evaluate("x = 0")); // -3.0
		System.out.println("dfdx.evaluate(\"x = 2.5\"): "
				+ dfdx.evaluate("x = 2.5")); // 47.0
		
		// Test equation with two unknowns: "x^4 - 2y^3 + x - (2y + 1)"		
		System.out.println("\nTest a equation with two unknowns: \"x^4 - 2y^3 + x - (2y + 1)\"");
		ComputationalNode equation = new Subtract(
				new Add(
						new Subtract(
								new Power(x, 4),
								new Multiply(
										new Constant(2),
										new Power(y, 3))),
								x),
						new Add(
								new Multiply(
										new Constant(2),
										y),
								new Constant(1)));
		System.out.println("equation.toString(): " + equation.toString()); // (((x^4.0 - 2.0 * y^3.0) + x) - (2.0 * y + 1.0))
		dfdx = equation.derivative("x").cleanUp();  // derivative with respect to x
		ComputationalNode dfdy = equation.derivative("y").cleanUp();  // derivative with respect to y
		System.out.println("dfdx.toString(): " 
				+ dfdx.toString()); // (4.0 * x^3.0 + 1.0)
		System.out.println("dfdy.toString(): " 
				+ dfdy.toString()); // (0.0 - 2.0 * 3.0 * y^2.0) - 2.0)
		*/
		
		
		
		
		/* TODO: This is for the bonus task
		/////////////  Bonus   /////////////////
		// Test Sine(x)		
		System.out.println("\nTest Sine(x):");
		ComputationalNode sine = new Sine(x);
		System.out.println("sine.toString(): "
				+ sine.toString()); // sin(x)
		System.out.println("sine.evaluate(\"0\"): "
				+ sine.evaluate("x = 0")); // 0.0
		System.out.println("sine.derivative(\"x\").toString() = "
				+ sine.derivative("x").toString()); // 1.0 * sin(x)
		System.out.println("sine.derivative(\"x\").cleanUp().toString() = "
				+ sine.derivative("x").cleanUp().toString()); // sin(x)
		
		// Test Cosine(x)		
		System.out.println("\nTest Cosine(x):");
		ComputationalNode cosine = new Cosine(x);
		System.out.println("cosine.toString(): "
				+ cosine.toString()); // cos(x)
		System.out.println("cosine.evaluate(\"0\"): "
				+ cosine.evaluate("x = 0")); // 1.0
		System.out.println("cosine.derivative(\"x\").toString() = "
				+ cosine.derivative("x").toString()); //(0.0 - 1.0 * cos(x))
		System.out.println("cosine.derivative(\"x\").cleanUp().toString() = "
				+ cosine.derivative("x").cleanUp().toString()); // (0.0 - cos(x))
		
		// Test Ln(x)		
		System.out.println("\nTest Ln(x):");
		ComputationalNode ln = new Ln(x);
		System.out.println("ln.toString(): "
				+ ln.toString()); // ln(x)
		System.out.println("ln.evaluate(\"0\"): "
				+ ln.evaluate("x = 1")); // 0.0
		System.out.println("ln.derivative(\"x\").toString() = "
				+ ln.derivative("x").toString()); // 1.0 * 1.0 / x
		System.out.println("ln.derivative(\"x\").cleanUp().toString() = "
				+ ln.derivative("x").cleanUp().toString()); // 1.0 / x
		*/
	}

}
