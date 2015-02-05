import java.util.Scanner;

/**
 *Die main-Methode.
 *Sie liest als einzige Klasse Befehle ein, verarbeitet diese und
 *gibt sie auf die Standartausgabe aus.
 */

public class AsciiShop{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int width = 0, height = 0;
		boolean input_error = false;
		String eof = "", temp = "", charSet = "", loot = "", command = "";
		/*
		 *Die nächsten vier if-Abfragen überprüfen, ob das erste Wort "create" ist, ob danach zwei Zahlenwerte folgen und ob ein String der erlaubten Zeichen vorhanden ist, sonst wird ein Fehler ausgegeben.
		 */
		if(!sc.next().equals("create") && !sc.hasNextInt()){		
			input_error = true;
		}
		if(sc.hasNextInt()){
			width = sc.nextInt();
		} else {input_error = true;}
		if(sc.hasNextInt()){
			height = sc.nextInt();
		} else {input_error = true;}
		if(sc.hasNext()){
			charSet = sc.next();
		} else {input_error = true;}

		/*
		 * Falls bisher kein Fehler aufgetreten ist, wird ein Objekt der Klasse AsciiImage mit den, aus der Eingabedatei eingelesenen, Werten erzeugt.
		 */
		AsciiImage image = new AsciiImage(0,0,"");
		if(input_error == false){
			AsciiImage defa = new AsciiImage(width, height, charSet);
			image = defa;
		}

		image = new ClearOperation().execute(image);
		AsciiStack ascii_stack = new AsciiStack();

		/*
		 *Die Schleife wird solange durchlaufen, solange kein Fehler auftritt und eine Eingabe vorhanden ist.
		 *Das Bild wird bis "eof" eingelesen und die Bildpunkte entsprechen ihren Koordinaten gespeichert. 
		 *Folgt nach der angegebenen Höhe nicht "eof" wird ein Fehler ausgegeben. 
		 *Es wird auch ein Fehler ausgegeben, wenn die Breite einer Zeile sich von der angegebenen unterscheidet.
		 */
		while(sc.hasNext() && input_error == false){
			command = sc.next();
			AsciiImage copy = new AsciiImage(image);

			try{
				if(command.equals("load")){
					if(sc.hasNext()){
						eof = sc.next();
					} else {
						input_error = true;
						break;
					}
					while(!loot.equals(eof)){
						temp += loot + '\n';
						loot = sc.next();
					}
					if(!loot.equals(eof)){
						input_error = true;
						break;
					}
					image = new LoadOperation(temp).execute(image);
				} else if(command.equals("replace")){

					char c1 = ' ', c2 = ' ';
					temp = sc.next();
					c1 = temp.charAt(0);
					temp = sc.next();
					c2 = temp.charAt(0);

					image = new ReplaceOperation(c1, c2).execute(image);
				} else if(command.equals("grow")){		
					String s = "";

					if(sc.hasNext()){
						s = sc.next();
					} else {
						input_error = true;
						break;
					}
					char c = s.charAt(0);
					image = new GrowRegionOperation(c).execute(image);
				} else if(command.equals("fill")){
					int x,y;
					String a = "";

					if(sc.hasNextInt()){
						x = sc.nextInt();
					} else {
						input_error = true;
						break;
					}

					if(sc.hasNextInt()){
						y = sc.nextInt();
					} else {
						input_error = true;
						break;
					}
					if(sc.hasNext()){
						a = sc.next();
					} else {
						input_error = true;
					}

					char c = a.charAt(0);
					/*
					 *Sind die Koordinaten, an denen der fill-Algorithmus beginnen soll, außerhalb des Bildbereiches wird "OPERATION FAILD" ausgegeben.
					 */
					image = new FillOperation(x, y, c).execute(image);

				} else if(command.equals("filter")){
					if(!sc.next().equals("median")){
						input_error = true;
						break;
					}
					image = new MedianOperation().execute(image);	
				} else if(command.equals("clear")){
					image =	new ClearOperation().execute(image);
				} else if(command.equals("transpose")){
					image = new TransposeOperation().execute(image);
				}
				else if(command.equals("undo")){				

					AsciiImage Pimage = ascii_stack.pop();		

					if(Pimage == null){				
						System.out.println("STACK EMPTY");
					} else {
						image=Pimage;
					}
				}
				else if(command.equals("print")){				
					System.out.println(image.toString());
				} else {
					System.out.println("UNKNOWN COMMAND");
					break;
				}
			} catch(OperationException o){System.out.println("OPERATION FAILED"); System.err.println(o); break;} 
			/*
			 *Wenn einer der Befehle eingegeben wurde, wird eine Kopie des Bildes auf dem Stack abgelegt.
			 */	

			if(command.equals("grow") || 				
					command.equals("clear") || 
					command.equals("replace") || 
					command.equals("fill") || 
					command.equals("transpose") || 
					command.equals("load") ||
					command.equals("filter"))
			{
				ascii_stack.push(copy);
			}
		}

		/*
		 *Werden die bool'schen error variablen "true", wird der entsprechende Fehler ausgegeben.
		 */
		if(input_error == true){
			System.out.println("INPUT MISMATCH");
		} 
	}
}
