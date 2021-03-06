public class AsciiImage{
	
	private int height, width; 
	private String line;
	
	public AsciiImage(){
		
		height = 0;
		width = 0;
		line = "";
	}
	
	public boolean addLine(String line){
		
		this.line += line;
		width = line.length();
		height++;
		
		return true;
	}
	
	public int getWidth(){
		
		return width;
	}
	
	public int getHeight(){
		
		return height;
	}
	
	public String toString(){
		
		String img_out = "";
		
		for(int m=0;m<line.length();m+=width){
			img_out += line.substring(m, m+width) + String.format("%n");
		}

		return img_out;
	}
	
	public int getUniqueChars(){
		
		String chars = "";
		chars += line.charAt(0);

		for(int i=0;i<=line.length()-1;i++){

				String ha = "";
				ha += line.charAt(i);
				if(!chars.contains(ha)){
					chars += line.charAt(i);
				}
		}
		
		return chars.length();
	}
	
	private char getPixel(int x, int y){
		char c = ' ';

		c = line.charAt(y*width+x);		
		
	return c;
	}
	
	public void flipV(){
		
		String temp = "";
		
		for(int m=line.length();m>=width;m-=width){
			temp += line.substring(m-width, m);

		}
		line = temp;
	}
	
	public void transpose(){
		String temp = "";

		for(int n=0;n<width;n++){
			for(int m=0;m<height;m++){
				temp +=getPixel(n,m);
			}
		}
		
		line = temp;
		
		int cache = height;
		height = width;
		width = cache;
	}
	
	public void fill(int x, int y, char c){
		String temp = "";
		char rep = getPixel(x, y);
		
		temp = line.substring(0, y*width+x);
		temp += c;
		temp += line.substring(y*width+(x+1), line.length());
		
		line = temp;
		
		if(y<height-1 && getPixel(x, y+1) == rep){
			fill(x, y+1, c);
		}
		if(x<width-1 && getPixel(x+1, y) == rep){
			fill(x+1, y, c);
		}
		if(y>0 && getPixel(x, y-1) == rep){
			fill(x, y-1, c);
		}
		if(x>0 && getPixel(x-1, y) == rep){
			fill(x-1, y, c);
		}
		
		
	}
	
	public boolean symmetric(){
		String partLine = "";
		boolean sym = true;
		
		for(int e=0;e<line.length()-width;e+=width){
			partLine = line.substring(e, e+width);
			
			for(int f=0;f<width/2;f++){
				if(partLine.charAt(f) != partLine.charAt(width-1-f)){
					sym = false;
					break;
				}
			}
		}
	return sym;
	}
	
}
