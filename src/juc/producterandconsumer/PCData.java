package juc.producterandconsumer;

public class PCData {
    private final int intData;
    public PCData(int d) {
        this.intData = d;
    }

    public int getIntData() {
        return intData;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "intData=" + intData +
                '}';
    }
}
