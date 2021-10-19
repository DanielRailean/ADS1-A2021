public class E implements Comparable<E>{


    public E(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public int compareTo(E o) {
        if(o.getValue() == getValue()) return 0;
        else if(o.getValue()>getValue()) return -1;
        else return 1;
    }
}
