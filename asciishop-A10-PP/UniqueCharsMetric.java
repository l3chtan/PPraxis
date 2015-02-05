public class UniqueCharsMetric implements Metric<AsciiImage> {

	public UniqueCharsMetric(){}
	
	public int distance(AsciiImage o1, AsciiImage o2){
		return Math.abs(o1.getUniqueChars()-o2.getUniqueChars());
	}
}
