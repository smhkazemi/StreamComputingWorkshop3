public class UniversalHashTest {
    public static void main(String args[]){ //for testing
        if(args.length != 2){
            System.err.println("should be two arguments: lengthOfMembershipArray numberOfHashFunctionsToUse");
            System.exit(0);
        }
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        String ss[] = {"Tony","Matthias","Yadeesha","Shuo"};
        int m = 100;
        BloomFilter<String> sb = new BloomFilter(n,k);
        BloomFilter<Integer> si = new BloomFilter(n,k);
        for(String s : ss)
        {
            sb.insert(s);
        }
        for(String s : ss)
        {
            assert sb.query(s);
        }
        for(int i = 0;i < m; i += 3)
        {
            si.insert(i);
        }
        for(int i = 0;i < m; i++)
        {
            assert ((si.query(i)) && (i %3 != 0));
        }
    }
}
