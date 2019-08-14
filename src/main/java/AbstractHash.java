public class AbstractHash {

    public int getHashFor(Integer sampledNumber, Integer samplingArraySize){
        return sampledNumber.hashCode();
    }

    public static int basicHash(Object key){
        return (key.hashCode() & 0x0000ffff);
    }
}
