package Distinct;

public interface DistinctInterface
{

    static int zeros(int v)
    {
        return Integer.numberOfTrailingZeros(v); // builtin function
    }
    void add(Object o); // add a new element to the collection
    double distinct(); // return a double representing the number of distinct elements
}