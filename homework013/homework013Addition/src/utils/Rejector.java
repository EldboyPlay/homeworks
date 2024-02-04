package utils;

public class Rejector<T> {
    private ByCondition<T> condition;

    public Rejector(ByCondition<T> condition) {
        this.condition = condition;
    }

    public boolean reject(T value) {
        return !condition.test(value);
    }
}
