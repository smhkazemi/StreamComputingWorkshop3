package Distinct;

public interface DistinctInterface
{

    static int zeros(int v)
    {
        return Integer.numberOfTrailingZeros(v);
    }
    void addNewElementToTheCollection(Object newElement);
    double numberOfDistinctElements();
}