
public class Main {
    public static void main(String[] args) throws Exception {
        ChiSquareTest.doTest();
        ReserviorTest.doTest();
        BloomFilterTest.doTest(args);
        UniversalHashTest.doTest();
        MorrisCounterTest.doTest(args);
    }
}
