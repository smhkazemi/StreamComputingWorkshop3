class BloomFilterTest {
    static void doTest(String[] args) throws Exception { //for testing
        if(args.length != 2){
            System.err.println("should be two arguments: lengthOfMembershipArray numberOfHashFunctionsToUse");
            System.exit(0);
        }
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        String[] ss = {"Tony", "Matthias", "Yadeesha", "Shuo"};
        int m = 100;
        BloomFilter<String> sb = new BloomFilter(n,k);
        BloomFilter<Integer> si = new BloomFilter(n,k);
        for(String s : ss)
        {
            sb.insert(s);
            if(!sb.query(s))
                throw new Exception("!si.query(s)");
        }
        for(int i = 0;i < m; i += 3)
        {
            si.insert(i);
            if(!si.query(i))
                throw new Exception("!si.query(i)");
        }
    }
}
