public class ReplicateBlockGenerator extends BlockGenerator {


	public ReplicateBlockGenerator(int edge){
		super(edge);
	}


	public int getPixel(AsciiImage img, int x, int y){

		int res = 0;

		if((x>=0 && y>=0) && (x<img.getWidth() && y<img.getHeight())){
			res = img.getCharset().indexOf(img.getPixel(x,y));
					} else {
						int i = x, j = y;

						if(x<0){
							i = 0;			
						} else if(x>=img.getWidth()){
							i = img.getWidth()-1;
						}

						if(y<0){
							j = 0;
						} else if(j>=img.getHeight()){
							j = img.getHeight()-1;
						}
						res = img.getCharset().indexOf(img.getPixel(i,j));
					}

					return res;
	}


}
