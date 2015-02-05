public class AsciiStack{

	private int increment;
	private AsciiImage[] imgStack;
	
	/**
	*Konstruktor. Erzeugt ein neues Stack.
	*@param increment Legt die Größe des neu erzeugten Stacks fest.
	*/
	public AsciiStack(int increment){
		this.increment = increment;
		imgStack = new AsciiImage[increment];
	}
	/**
	*@return Gesamtgröße des Stacks
	*/
	public int capacity(){
		
		return imgStack.length;
	}
	/**
	*@return True: Wenn Stack leer ist. False: sonst
	*/
	public boolean empty(){
	
		boolean empty = false;
	
		if(size() == 0){
			empty = true;
		}
		return empty;
	}
	/**
	*Nimmt das oberste Element des Stacks und löscht es aus dem Stack.
	*@return Oberstes Element des Stacks
	*/
	public AsciiImage pop(){
	
		AsciiImage[] temp;
		int n = 0;
		
		AsciiImage img = peek();
		
		if(peek() == null){
			return img;
		}
		
			n = size()-1;
			imgStack[size()-1] = null;
			if(n < capacity()-increment){
				temp = new AsciiImage[capacity()-increment];
				System.arraycopy(imgStack, 0, temp, 0, temp.length);
				imgStack = temp;
			}
		return img;
	}
	/**
	*Gibt das oberste Element des Stacks zurück ohne es zu löschen.
	*@return Gibt Null zurück, wenn der Stack leer ist, sonst das oberste Element.
	*/
	public AsciiImage peek(){

		if(empty() == false){
			return imgStack[size()-1];
		} else {
			return null;
		}
	}
	/**
	*Legt ein Element vom Typ AsciiImage auf dem Stack ab und vergrößert den Stack bei Bedarf.
	*@param img Element welches auf den Stack gelegt wird.
	*@see AsciiImage.java
	*/
	public void push(AsciiImage img){
		int n = size()+1;
		if(n > capacity()){
		AsciiImage[] temp = new AsciiImage[capacity()+increment];
			
			System.arraycopy(imgStack, 0, temp, 0, imgStack.length);
			imgStack = temp;
		}
			imgStack[n-1] = img;
	}
	/**
	*@return Gibt die Anzahl der belegten Plätze zurück.
	*/
	public int size(){
		
		int count = 0;
		
		for(int d=0;d<imgStack.length;d++){
			if(imgStack[d] != null){
				count++;
			}
		}
		return count;
	}
}
