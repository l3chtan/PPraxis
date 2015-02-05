import java.util.ArrayList;

public class AsciiImage{
	
	private int height, width; 
	private char[][] picture;
	/**
	*Konstruktor. Erzeugt ein neues Bild mit angegebener Breite und Höhe.
	*@param width Breite des Bildes
	*@param height Höhe des Bildes
	*/
	public AsciiImage(int width, int height){
		
		this.height = height;
		this.width = width;
		
		picture = new char[width][height];
		clear();
	}
	/**
	*Kopier-Konstruktor. Erzeugt eine Kopie des AsciiImage Objektes.
	*@param img Eine AsciiImage Kopie
	*/
	public AsciiImage(AsciiImage img){
		this.height = img.height;
		this.width = img.width;
		picture = new char[img.width][img.height];
		
		for(int g=0;g<width;g++){
			for(int h=0;h<height;h++){
				picture[g][h] = img.getPixel(g,h);
			}
		}
	}
	/**
	*Setzt alle Punkte des Bildes auf '.', und löscht somit den vorherigen Inhalt.
	*/
	public void clear(){
	
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				picture[i][j] = '.';
			}
		}
	}
	/**
	*@return Gibt die Breite des Bildes zurück
	*/
	public int getWidth(){
		
		return width;
	}
	/**
	*@return Gibt die Höhe des Bildes zurück.
	*/
	public int getHeight(){
		
		return height;
	}
	/**
	*Formatiert das Bild und gibt eine Lesbare Darstellung aus.
	*@return Gibt den formatierten String aus.
	*/
	public String toString(){
		
		String img_out = "";
		
		for(int m=0;m<height;m++){
			for(int n=0;n<width;n++){
				img_out += getPixel(new AsciiPoint(n,m));
			}
			img_out += String.format("%n");
		}
		return img_out;
	}
	/**
	*@param x x-Koordinate
	*@param y y-Koordinate
	*@return Zeichen an den angegebenen Koordinaten
	*/
	public char getPixel(int x, int y){

		return picture[x][y];
	}
	/**
	*@param p Ein Objekt der AsciiPoint Klasse.
	*@return Zeichen an den angebenen Koordinaten
	*@see AsciiPoint.java
	*/
	public char getPixel(AsciiPoint p){
	
		return picture[p.getX()][p.getY()];
	}
	/**
	*Setzt ein Zeichen an den angegebenen Koordinaten.
	*@param x x-Koordinate
	*@param y y-Koordinate
	*@param c zu setzendes Zeichen
	*/
	public void setPixel(int x, int y, char c){
		
		picture[x][y] = c;
	}
	/**
	*Setzt ein Zeichen an den angegebenen Koordinaten.
	*@param p Ein Objekt der AsciiPoint Klasse.
	*@param c zu setzendes Zeichen
	*@see AsciiPoint.java
	*/
	public void setPixel(AsciiPoint p, char c){
	
		picture[p.getX()][p.getY()] = c;
	}
	/**
	*Speichert alle Koordinaten eines bestimmten Zeichens aus dem Bild.
	*@param c Zeichen von welchem alle Vorkommen in der ArrayList gespeichert werden
	*@return Eine ArrayList vom Typ AsciiPoint mit allen Koordinaten an denen das Zeichen c vorkommt.
	*@see AsciiPoint.java
	*/
	public ArrayList<AsciiPoint> getPointList(char c){
		
		ArrayList<AsciiPoint> pixel = new ArrayList<AsciiPoint>();
		
		for(int a=0;a<width;a++){
			for(int b=0;b<height;b++){

				if(getPixel(a,b) == c){
					AsciiPoint d = new AsciiPoint(a,b);
					pixel.add(d);
				}
			}
		}
		return pixel;
	}
	/**
	*Transponiert (vertauscht Zeilen mit Spalten) das Bild
	*@see getPixel(int x, int y)
	*/
	public void transpose(){
		char[][] temp = new char[height][width];

		for(int n=0;n<width;n++){
			for(int m=0;m<height;m++){
				temp[m][n] = getPixel(n,m);
			}
		}
		
		picture = temp;
		
		int cache = height;
		height = width;
		width = cache;
	}
	/**
	*Bestimmt den Schwerpunkt eines Zeichens aus dem Bild.
	*@param c Zeichen dessen Schwerpunkt bestimmt werden soll.
	*@return Gibt die Koordinaten des Schwerpunktes zurück.
	*@see getPointList(char c)
	*/
	public AsciiPoint getCentroid(char c){
		
		int xSum = 0, ySum = 0;
		int centrX = 0, centrY = 0;
		double point = 0.0;
		
		ArrayList<AsciiPoint> tmp = getPointList(c);
		point = tmp.size();
		
		if(tmp.size() == 0){
			return null;
		}
		
		for(int q=0;q<point;q++){
			xSum += tmp.get(q).getX();
			ySum += tmp.get(q).getY();
		}
		centrX = (int)Math.round(xSum/point);
		centrY = (int)Math.round(ySum/point);
		
		AsciiPoint p = new AsciiPoint(centrX, centrY);
		
		return p;
	}
	/**
	*Setzt in einer Vierer-Nachbarschaft um alle Vorkommen eines Zeichens im Bild alle Hintergrundpixel ('.') auf das Zeichen selbst.
	*@param c Zeichen in dessen Nachbarschaft Hintergrundpixel auf es selbst gesetzt werden.
	*@see getPointList(char c)
	*@see getPixel(int x, int y)
	*@see setPixel(int x, int y, char c)
	*/
	public void growRegion(char c){

		ArrayList<AsciiPoint> tmp = getPointList(c);
		
		int x=0, y=0;
		
		for(int p=0;p<tmp.size();p++){
			x=tmp.get(p).getX();
			y=tmp.get(p).getY();
			
			if(y<height-1 && getPixel(x,y+1) == '.'){
				setPixel(x,y+1,c);
				}
			if(x<width-1 && getPixel(x+1,y) == '.'){
				setPixel(x+1,y,c);
				}
			if(y>0 && getPixel(x,y-1) == '.'){
				setPixel(x,y-1,c);
				}
			if(x>0 && getPixel(x-1,y) == '.'){
				setPixel(x-1,y,c);
			}
		}
	}
	/**
	*Ersetzt ein Zeichen mit einem anderen Zeichen, und alle Zeichen in dessen Nachbarschaft die gleich dem ersetzten Zeichen sind.
	*@param x x-Koordinate
	*@param y y-Koordinate
	*@param c Das zu setztende Zeichen
	*/
	public void fill(int x, int y, char c){
		String temp = "";
		char rep = getPixel(x, y);
		
		setPixel(x,y,c);
		
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
	/**
	*Zeichnet eine Line entlang angegebener Koordinaten. 
	*Ist (x1-x0) kleiner als (y1-y0), werden die x- und y-Koordinaten vertauscht.
	*Wenn x1 kleiner als x0 ist, werden x0 mit x1 und y0 mit y1 vertauscht.
	*@param x0 x-Koordinate des Anfangspunktes
	*@param y0 y-Koordinate des Anfangspunktes
	*@param x1 x-Koordinate des Endpunktes
	*@param y1 y-Koordinate des Endpunktes
	*@param c Zeichen, aus dem die Linie bestehen soll
	*/
	public void drawLine(int x0, int y0, int x1, int y1, char c){
		double dx = 0.0;
		double dy = 0.0;
		int cache = 0;
		boolean turn = false;
		
		double steigung = 0.0;
		double y = 0;
		
		if(Math.abs(y1-y0)>Math.abs(x1-x0)){
			
			cache = x0;
			x0 = y0;
			y0 = cache;
			
			cache = x1;
			x1 = y1;
			y1 = cache;
			turn = true;
		}
		
		if(x1<x0){
		
			cache = x0;
			x0 = x1;
			x1 = cache;
			
			cache = y0;
			y0 = y1;
			y1 = cache;
		}
		
		y = y0;
		
		dx = x1-x0;
		dy = y1-y0;
		steigung = dy/dx;
		
		for(int x=x0;x<=x1;x++){
			if(turn == false){
				setPixel(x, (int)Math.round(y),c);
			} else {
				setPixel((int)Math.round(y), x, c);
			}
			y += steigung;
		}
	}
	/**
	*Ersetzt ein bestimmtes Zeichen. Dazu wird das Bild durchlaufen und alle Zeichen die gleich oldChar sind werden durch newChar ersetzt.
	*@param oldChar Das zu ersetzende Zeichen
	*@param newChar Das neue Zeichen
	*@see getPointList(char c)
	*/
	public void replace(char oldChar, char newChar){
		
		ArrayList<AsciiPoint> tmp = getPointList(oldChar);
		int point = tmp.size();
		int x = 0;
		int y = 0;
		
		for(int e=0;e<point;e++){
			x = tmp.get(e).getX();
			y = tmp.get(e).getY();
				if(oldChar == picture[x][y]){
					setPixel(x, y, newChar);
				}
		}
	}
	/*
	public void flipV(){
		
		String temp = "";
		
		for(int m=line.length();m>=width;m-=width){
			temp += line.substring(m-width, m);

		}
		line = temp;
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
	*/
}
