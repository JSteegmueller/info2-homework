package main;

public class EmptyList implements IntegerList {

    @Override
    public void print() {
        System.out.println("end");
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public IntegerList append(int element) {
        return new Pair(element, this);
    }

    @Override
    public int get(int index) throws Exception {
        throw new Exception("Oh shit, you shouldn't be here. I'm empty!");
    }

    @Override
    public IntegerList insert(int element, int index) throws Exception {
        if(index > 0) throw new Exception("I am empty, not possible!");
        if (index == 0) {
            return new Pair(element, this);
        } else return this;
    }

    @Override
    public IntegerList deleteElement(int index) throws Exception {
        if (index > -1) throw new Exception("I cant delete I'm empty, sorry sorry");
        return this;
    }

    @Override
    public IntegerList reversed() {
        return this;
    }

    @Override
    public IntegerList extend(IntegerList other) {
        return other;
    }

    @Override
    public int min() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isSorted() {
        return true;
    }
}
