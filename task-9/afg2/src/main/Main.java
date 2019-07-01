package main;

public class Main {

    public static void main(String[] args) {
        SortedFloatTree tree = new Node(3.0f,
                new Node(1.0f, new Node(0.0f, new EmptyTree(), new EmptyTree()),
                        new Node(2.0f, new EmptyTree(), new EmptyTree())),
                new Node(5.0f, new Node(4.0f, new EmptyTree(), new EmptyTree()),
                        new Node(6.0f, new EmptyTree(), new EmptyTree())));
        // Show initial status of tree
        System.out.println(tree.asString());

        //TODO Comment-in to test your code:
        // Test depth
        System.out.println("tree.depth(): " + tree.depth());

        // Test nodecount
        System.out.println("tree.nodecount(): " + tree.nodeCount());

        // Test exists
        System.out.println("tree.exists(0): " + tree.exists(0));
        System.out.println("tree.exists(2): " + tree.exists(2));
        System.out.println("tree.exists(4): " + tree.exists(4));
        System.out.println("tree.exists(6): " + tree.exists(6));
        System.out.println("tree.exists(8): " + tree.exists(8));
        System.out.println("tree.exists(2.2): " + tree.exists(2.2f));

        // Test insert
        tree = tree.insert(3.5f).insert(-1.f).insert(8);
        System.out.println(tree.asString());
        // Tree from slides
        SortedFloatTree tree1 = new EmptyTree();
        tree1 = tree1.insert(25).insert(8).insert(32).insert(5).insert(2).insert(6).insert(13).insert(11).insert(19)
                .insert(26).insert(30).insert(31).insert(38).insert(36).insert(41);
        System.out.println(tree1.asString());
        // Same tree out of balance (also from slides)
        SortedFloatTree tree2 = new EmptyTree();
        tree2 = tree2.insert(2).insert(5).insert(6).insert(8).insert(11).insert(13).insert(19).insert(25).insert(26)
                .insert(30).insert(31).insert(32).insert(36).insert(38).insert(41);
        System.out.println(tree2.asString());

        // Another tree that is out of balance in the other direction
        SortedFloatTree tree3 = new EmptyTree();
        tree3 = tree3.insert(4).insert(3).insert(2).insert(1);
        System.out.println(tree3.asString());

    }

}
