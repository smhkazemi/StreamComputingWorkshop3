import java.util.Random;

class Reservoir{
	private Object[] sampleArray;
	private Random randomGenerator;
	private int lastIndexOnSampleArrayToInsert;
	private int numberOfSeenItemsInStream;
	
	Reservoir(int sampleNum){
		sampleArray = new Object[sampleNum];
		lastIndexOnSampleArrayToInsert = 0;
		numberOfSeenItemsInStream = 0;
		randomGenerator = new Random();
		randomGenerator.setSeed(1234567890);
	}
	
	void considerItem(Object toConsider){
		numberOfSeenItemsInStream++;
		if(lastIndexOnSampleArrayToInsert < sampleArray.length)
		{
			sampleArray[lastIndexOnSampleArrayToInsert] = toConsider;
			lastIndexOnSampleArrayToInsert++;
		}
		int randomlyGeneratedIndex = randomGenerator.nextInt(numberOfSeenItemsInStream);
		if(randomlyGeneratedIndex < sampleArray.length)
		{
			sampleArray[randomlyGeneratedIndex] =  toConsider;
		}
	}
	
	Object[] report()
	{
		Object[] resualt = new Object[lastIndexOnSampleArrayToInsert];
		System.arraycopy(sampleArray, 0, resualt, 0, lastIndexOnSampleArrayToInsert);
		return resualt;
	}
}
