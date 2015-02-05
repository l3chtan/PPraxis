public class XBlockGenerator extends BlockGenerator {


	public XBlockGenerator(int edge){
		super(edge);
	}
	
	public int getPixel(AsciiImage img, int x, int y){
	
		if((x>=0 && y>=0) && (x<img.getWidth() && y<img.getHeight())){
			return img.getCharset().indexOf(img.getPixel(x,y));
		}

		return img.getCharset().length()-1;
	}
}
