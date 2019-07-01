package main;

public class Main {
    public static void main(String[] args) {
	IntegerList list = new Pair(0, new Pair(1, new Pair(2, new Pair(30, new Pair(4, new EmptyList())))));

	// Print initial State of list
	System.out.println("Current List:");
	list.print();

	// print length of list
	System.out.println("Length: " + list.length());

	// Test the get function
	try {
	    System.out.println("list.get(0): " + list.get(0));
	    System.out.println("list.get(1): " + list.get(1));
	    System.out.println("list.get(2): " + list.get(2));
	    System.out.println("list.get(3): " + list.get(3));
	    System.out.println("list.get(4): " + list.get(4));
	    System.out.println("list.get(4): " + list.get(5)); // should throw exception
	} catch (Exception e) {
	    e.printStackTrace();
	}

	// Test the append function
	System.out.println("list.append(8): ");
	list.append(8).print();

	// Test the insert function
	try {
	    System.out.println("list.insert(8, 0): ");
	    list.insert(8, 0).print();
	    System.out.println("list.insert(8, 1): ");
	    list.insert(8, 1).print();
	    System.out.println("list.insert(8, 2): ");
	    list.insert(8, 2).print();
	    System.out.println("list.insert(8, 3): ");
	    list.insert(8, 3).print();
	    System.out.println("list.insert(8, 4): ");
	    list.insert(8, 4).print();
	    System.out.println("list.insert(8, 5): ");
	    list.insert(8, 5).print();
	    System.out.println("list.insert(8, 6): ");
	    list.insert(8, 6).print(); // should throw exception
	} catch (Exception e) {
	    e.printStackTrace();
	}

	// Test reverse function
	System.out.println("list.reversed(): ");
	list.reversed().print();

	// Test extend function
	System.out.println("list.extend(list): ");
	list.extend(list).print();

	// Test delete function
	try {
	    System.out.println("list.delete(0):");
	    list.deleteElement(0).print();
	    System.out.println("list.delete(1):");
	    list.deleteElement(1).print();
	    System.out.println("list.delete(2):");
	    list.deleteElement(2).print();
	    System.out.println("list.delete(3):");
	    list.deleteElement(3).print();
	    System.out.println("list.delete(4):");
	    list.deleteElement(4).print();
	    System.out.println("list.delete(5):");
	    list.deleteElement(5).print(); // should throw exception
	} catch (Exception e) {
	    e.printStackTrace();
	}

	// Test minimum Function
	System.out.println("list.min(): " + list.min());

	// Test isSorted Function
	System.out.println("list.isSorted():" + list.isSorted());
	System.out.println("list.reversed.isSorted():" + list.reversed().isSorted());

    }

}
