package main;

public class EmptyTree implements SortedFloatTree {

    public EmptyTree() {
    }

    @Override
    public String asString() {
        return "";
    }

    @Override
    public int depth() {
        // TODO
        return 0;
    }

    @Override
    public int nodeCount() {
        // TODO
        return 0;
    }

    @Override
    public boolean exists(float element) {
        // TODO
        return false;
    }

    @Override
    public SortedFloatTree insert(float element) {
        // TODO
        return new Node(element, this, this);
    }

}
