import java.util.Arrays;

abstract class FilterOperation implements Operation {

	protected BlockGenerator block;

	public FilterOperation(BlockGenerator block){
		this.block = block;
	}

	public AsciiImage execute(AsciiImage img){


		int cnt = 0, block_med = 0;
		AsciiImage result = new AsciiImage(img);

		for(int g=0;g<result.getHeight();g++){
			for(int h=0;h<result.getWidth();h++){

				int[] values = block.getBlock(img, h, g); 
				block_med = filter(values);
				result.setPixel(h,g,result.getCharset().charAt(block_med));
			}
		}
		return result;
	}

	public abstract int filter(int[] values);
}
