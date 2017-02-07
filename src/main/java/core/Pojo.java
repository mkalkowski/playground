package core;

public class Pojo {
    private final String a;
    private final Integer b;

    public Pojo(String a, int b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }
    public Integer getB() {
        return b;
    }

    @Override
    public String toString() {
        return a + "_" + b;
    }
}