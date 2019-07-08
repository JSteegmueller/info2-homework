package main;

import java.util.List;

import jdk.nashorn.api.tree.ForInLoopTree;

public class Generics {
	public static void main(String[] args) {
		List<Integer> list = new GenericList<Integer>();

		// Test adding elements
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		printList(list);
		// result:
		// List has size: 10
		// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,

		// Test adding elements via addAll
		List<Integer> otherList = new GenericList<Integer>();
		for (int i = 10; i < 20; i++) {
			otherList.add(i);
		}
		list.addAll(otherList);
		printList(list);
		// result:
		// List has size: 20
		// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,

		// Test adding element at specific location
		list.add(10, 100);
		printList(list);
		// result:
		// List has size: 21
		// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 100, 10, 11, 12, 13, 14, 15, 16, 17, 19, 19,

		// Test clear()
		list.clear();
		printList(list);
		// result:
		// List has size: 0
		//

		// Test contains()
		System.out.println("list.contains(42): " + list.contains(42)); // false
		System.out.println("list.contains(5): " + list.contains(5)); // false
		System.out.println("otherList.contains(0): " + otherList.contains(0)); // false
		System.out.println("otherList.contains(10): " + otherList.contains(10)); // true
		System.out.println("otherList.contains(15): " + otherList.contains(15)); // true

		// Test containsAll
		List<Integer> contains = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("otherList.containsAll([1,2,3,4,5,6,7,8,9,10]): " + otherList.containsAll(contains)); // false
		contains = List.of(10, 11, 12);
		System.out.println("otherList.containsAll([10, 11, 12]): " + otherList.containsAll(contains)); // true
		contains = List.of(10, 11, 12, 21);
		System.out.println("otherList.containsAll([10, 11, 12, 21]): " + otherList.containsAll(contains)); // false

		// Test get()
		try {
			list.get(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Correct! list is empty so we can not get any element");
			System.out.println("Exception says: " + e.getMessage());			
		}
		System.out.println("otherList.get(0): " + otherList.get(0)); // 10
		
		// Test indexOf()
		System.out.println("list.indexOf(42): " + list.indexOf(42)); // -1
		System.out.println("otherList.indexOf(42): " + otherList.indexOf(42)); // -1
		System.out.println("otherList.indexOf(19): " + otherList.indexOf(19)); // 9
		
		// Test isEmpty()
		System.out.println("list.isEmpty(): " + list.isEmpty()); // true
		System.out.println("otherList.isEmpty(): " + otherList.isEmpty()); // false
		
		// Test remove()
		try {
			list.remove(2);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Correct! You can not remove stuff from emtpy list.");
			System.out.println("Exception says: " + e.getMessage());			
		}
		otherList.remove(4);
		printList(otherList);
		// result:
		// List has size: 9
		// 10, 11, 12, 13, 15, 16, 17, 18, 19, 
		
		// Test removeAll()
		List<Integer> remove = List.of(10, 11, 12);
		otherList.removeAll(remove);
		printList(otherList);
		// result:
		// List has size: 6
		// 13, 15, 16, 17, 18, 19, 
		
		// Test set()
		otherList.set(4, 42);
		printList(otherList);
		// result:
		// List has size: 6
		// 13, 15, 16, 17, 42, 19,
		
		// Test sublist()
		List<Integer> sublist = otherList.subList(1, 4);
		printList(sublist); // 15, 16, 17,
		// manipulate sublist and see if main list also changed
		sublist.set(0, 88);  // sets first element in sublist
		printList(otherList);
		// result:
		// List has size: 6
		// 13, 88, 16, 17, 42, 19, 
		
		// Test toArray()
		System.out.println("toArray():");
		Object[] arr = otherList.toArray();		
		for (int i = 0; i < otherList.size(); i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.print("\n");
		// result: 
		// 13, 88, 16, 17, 42, 19, 
		
		// Test the toArray() with parameter
		Integer[] arr1 = new Integer[20];
		System.out.println("toArray(arr1):");
		arr1 = otherList.toArray(arr1);
		for (int i = 0; i < otherList.size(); i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.print("\n");
		// result: 
		// 13, 88, 16, 17, 42, 19, 
	}

	private static <T> void printList(List<T> list) {
		System.out.println("List has size: " + list.size()); // tests size()
		for (T elt : list) {  // For each loop uses iterator() of list.
			System.out.print(elt);
			System.out.print(", ");
		}
		System.out.print("\n");
	}

}
