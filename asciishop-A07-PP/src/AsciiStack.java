public class AsciiStack{

	private AsciiStackNode node;
	
	/**
	 * Konstruktor.
	 * Initialisiert eine Instanz der Klasse AsciiStackNode mit "null". 
	 * Damit wird beim Erstellen eines neuen Stacks der Anfangspunkt des Stacks gesetzt.*/
	public AsciiStack(){
		node = null;	
	}
	/**
	 * Überprüft leeren Stack.
	 * Mit dieser Methode kann überprüft werden, ob noch Elemente im Stack vorhanden sind.
	 *@return True: Wenn Stack leer ist. False: sonst
	 */
	public boolean empty(){

		boolean empty = false;

		if(peek() == null){
			empty = true;
		}
		return empty;
	}
	/**
	 * Nimmt Objekt vom Stack.
	 *Nimmt das oberste Element des Stacks und löscht es aus dem Stack.
	 *@return Oberstes Element des Stacks
	 */
	public AsciiImage pop(){

		AsciiImage peek = peek();
		if(node != null){
			node = node.next;
			return peek;
		}
		return null; 
	}
	/**
	 * Zeigt das nächste Objekt des Stacks.
	 *Gibt das oberste Element des Stacks zurück ohne es zu löschen.
	 *@return Gibt Null zurück, wenn der Stack leer ist, sonst das oberste Element.
	 */
	public AsciiImage peek(){
		if(node != null){
			return node.image;
		}
		return null;
	}
	/**
	 * Fügt ein Element dem Stack hinzu.
	 *Legt ein Element vom Typ AsciiImage auf dem Stack ab.
	 *@param img Element welches auf den Stack gelegt wird.
	 *@see AsciiImage.java
	 */
	public void push(AsciiImage img){

		node = new AsciiStackNode(img, node);
	}
	/**
	 * Die Größe des Stacks.
	 *@return Gibt die Anzahl der belegten Plätze zurück.
	 */
	public int size(){
		if(node == null){
			return 0;
		}
		return node.size();	
	}
	/*
	 * AsciiStackNode implementiert als innere Klasse.
	 * Somit kann direkt auf "image" und "next" zugegriffen werden, und es sind keine eigenen Methoden nötig.
	 * Außerdem können die Klassenvariablen "private" bleiben.*/
	class AsciiStackNode {

		private AsciiImage image;
		private AsciiStackNode next;
		/**
		 * Konstruktor.
		 * Die Klasse wird mit Parametern vom Typ AsciiImage und AsciiStackNode initialisiert.
		 * @param image Das AsciiImage Objekt, welches auf den Stack gelegt werden soll.
		 * @param next Eine Instanz von AsciiStackNode, die alle Informationen zu den vorhergehenden Elementem im Stack enthält.*/
		public AsciiStackNode(AsciiImage image, AsciiStackNode next){
			this.image = image;
			this.next = next;
		}
		/**
		 * Anzahl der AsciiStackNode Elemente.
		 * Jedes weitere Element, das dem Stack hinzugefügt wird, erzeugt ein neues Objekt der Klasse AsciiStackNode.
		 * Somit ist die Anzahl der AsciiStackNode Objekte gleich der Größe des Stacks.
		 * @return Der Rückgabewert des vorherigen AsciiStackNode Objektes plus eins.*/
		public int size(){

			if(this.next == null){
				return 1;	
			}

			return next.size()+1;
		}
	}
}
