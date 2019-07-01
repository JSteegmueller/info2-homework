package main;

public class Pair implements IntegerList {

    public IntegerList rest;
    public int element;

    public Pair(int element, IntegerList rest) {
        this.rest = rest;
        this.element = element;
    }

    @Override
    public void print() {
        System.out.print(element + " ");
        rest.print();
    }

    @Override
    public int length() {
        return 1 + rest.length();
    }

    @Override
    public IntegerList append(int element) {
        return new Pair(this.element, rest.append(element));
    }

    @Override
    public int get(int index) throws Exception {
        if (index > length() - 1) throw new Exception("Index out of bounds");

        if (index == 0) {
            return element;
        } else {
            return rest.get(index - 1);
        }
    }

    @Override
    public IntegerList insert(int element, int index) throws Exception {
        if (index > length() - 1) throw new Exception("Index out of bounds");

        if (index == 0) {
            return new Pair(element, new Pair(this.element, rest));
        } else {
            return new Pair(this.element, rest.insert(element, index - 1));
        }
    }

    @Override
    public IntegerList deleteElement(int index) throws Exception {
        if (index > length() - 1) throw new Exception("Index out of bounds");


        if (index == 0) {
            return rest;
        } else {
            return new Pair(element, rest.deleteElement(index - 1));
        }

    }

    @Override
    public IntegerList reversed() {
        IntegerList revRest = rest.reversed();
        return revRest.append(element);
    }

    @Override
    public IntegerList extend(IntegerList other) {
        return new Pair(element, rest.extend(other));
    }

    @Override
    public int min() {
        return (element < rest.min()) ? element : rest.min();
    }

    @Override
    public boolean isSorted() {

        return (rest.isSorted() && element < rest.min());
    }
}
