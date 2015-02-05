
public class SymmetricBlockGenerator extends BlockGenerator{


	public SymmetricBlockGenerator(int edge){
		super(edge);
	}

	public int getPixel(AsciiImage img, int x, int y){
	
	
		int i = 0, j = 0;

		i = x;
		j = y;

		if(x<0){
			i = Math.abs(x+1);			
		} else if(x>=img.getWidth()){
			i = 2*img.getWidth()-x-1;
		}

		if(y<0){
			j = Math.abs(y+1);
		} else if(y>=img.getHeight()){
			j = 2*img.getHeight()-y-1;
		}

		return img.getCharset().indexOf(img.getPixel(i,j));
	}
}
