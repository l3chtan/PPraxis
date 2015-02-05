public abstract class BlockGenerator{

	private int edge;

	public BlockGenerator(int edge){
		this.edge = edge;
	}

	public int[] getBlock(AsciiImage img, int x, int y){
		int[] values = new int[edge*edge];	
		int cnt = 0;

		for(int m=x-(edge/2);m<=x+(edge/2);m++){
			for(int n=y-(edge/2);n<=y+(edge/2);n++){
				values[cnt] = getPixel(img, m, n);
				cnt++;
			}
		}
		return values;
	}

	public abstract int getPixel(AsciiImage img, int x, int y);
}
