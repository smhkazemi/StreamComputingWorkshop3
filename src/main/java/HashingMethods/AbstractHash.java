package HashingMethods;

public class AbstractHash {

	public Integer getHashFor(Object key, Object rangeForHashingResult){
		return Integer.parseInt(key.toString()) % Integer.parseInt(rangeForHashingResult.toString());
	}
	
	public static int basicHashingFor(Object key){	    // if you only want the
	    return (key.hashCode() & 0x0000ffff);   // lower 16 bits
	}
}
