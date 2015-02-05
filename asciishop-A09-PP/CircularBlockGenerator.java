public class CircularBlockGenerator extends BlockGenerator{


	public CircularBlockGenerator(int edge){
		super(edge);
	}

	public int getPixel(AsciiImage img, int x, int y){


		int i = 0, j = 0;

		i = x;
		j = y;

		if(x<0){
			i = img.getWidth()+x;			
		} else if(x>=img.getWidth()){
			i = Math.abs(x-img.getWidth());
		}

		if(y<0){
			j = img.getHeight()+y;
		} else if(y>=img.getHeight()){
			j = Math.abs(y-img.getHeight());
		}

		return img.getCharset().indexOf(img.getPixel(i,j));
	}
}
