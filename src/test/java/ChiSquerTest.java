import ServiceClasses.ChiSquare;

public class ChiSquerTest {
    public static void doTest() throws Exception {
        try {
            ChiSquare.doTest(new Integer[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                    new Integer[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        try {
            ChiSquare.doTest(new Integer[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                    new Integer[]{1, 1, 1, 10, 10, 1, 10, 10, 1, 10});
            throw new Exception("given: {1, 1, 1, 10, 10, 1, 10, 10, 1, 10}" + " expected to fail but passed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
