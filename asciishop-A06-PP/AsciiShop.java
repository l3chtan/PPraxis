import java.util.Scanner;

/**
*Die main-Methode liest Befehle ein und verarbeitet diese.
*Sie gibt auch als einzige Klasse auf die Standardausgabe aus.
*/

public class AsciiShop{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		
		int width = 0, height = 0;
		boolean input_error = false;
		boolean op_error = false;
		String eof = "", temp = "";
		/**
		*Überprüft ob das erste Wort "create" ist und ob danach ein Zahlenwert folgt, sonst wird ein Fehler ausgegeben.
		*/
		if(!sc.next().equals("create") && !sc.hasNextInt()){		
			input_error = true;
		}
		
		width = sc.nextInt();
		height = sc.nextInt();
		/**
		*Überprüft ob Höhe und Breite größer Null sind, ansonsten wird "INPUT MISMATCH" ausgegeben.
		*/
		if(width<=0 || height<=0){					
			input_error = true;
		}
		
		AsciiImage image = new AsciiImage(width, height);		
			
		String command = "";
		AsciiStack ascii_stack = new AsciiStack(3);		
		
		/**
		*Die Schleife wird solange durchlaufen, solange kein Fehler auftritt und eine Eingabe vorhanden ist.
		*Das Bild wird bis "eof" eingelesen und die Bildpunkte entsprechen ihren Koordinaten gespeichert. 
		*Folgt nach der angegebenen Höhe nicht "eof" wird ein Fehler ausgegeben. 
		*Es wird auch ein Fehler ausgegeben, wenn die Breite einer Zeile sich von der angegebenen unterscheidet.
		*Die Eingabe wird height-mal durchlaufen.
		*@see AsciiImage.java
		*/
		while(sc.hasNext() && input_error == false && op_error == false){
			command = sc.next();
			AsciiImage copy = new AsciiImage(image);
			
			if(command.equals("load")){
				if(sc.hasNext()){
				eof = sc.next();
				} else {
					input_error = true;
					break;
				}
				for(int h=0;h<image.getHeight();h++){		
					temp = sc.next();
					if(temp.length() != width){
						input_error = true;
						break;
					}
					for(int g=0;g<temp.length();g++){
						image.setPixel(g,h,temp.charAt(g));
					}
				}
				if(!sc.next().equals(eof)){
					input_error = true;
					break;
				}
			} 
			else if(command.equals("transpose")){
				image.transpose();
			}
			else if(command.equals("fill")){
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
				/**
				*Sind die Koordinaten, an denen der fill-Algorithmus beginnen soll, außerhalb des Bildbereiches wird "OPERATION FAILD" ausgegeben.
				*/
				if(x<image.getWidth() && y<image.getHeight()){	
					image.fill(x, y, c);
				} else {
					op_error = true;
					break;
				}
			}
			else if(command.equals("clear")){
				image.clear();
			}
			else if(command.equals("line") && sc.hasNextInt()){
				int x0,y0,x1,y1;
				String ch = "";
				
				if(sc.hasNextInt()){
					x0=sc.nextInt();
				} else {
					input_error = true;
					break;
				}if(sc.hasNextInt()){
					y0=sc.nextInt();
				} else {
					input_error = true;
					break;
				}if(sc.hasNextInt()){
					x1=sc.nextInt();
				} else {
					input_error = true;
					break;
				}if(sc.hasNextInt()){
					y1=sc.nextInt();
				} else {
					input_error = true;
					break;
				}
				if(sc.hasNext()){
					ch = sc.next();
				} else {
					input_error = true;
					break;
				}
				char c = ch.charAt(0);
				
				image.drawLine(x0,y0,x1,y1,c);
				
			}
			else if(command.equals("replace")){
			
				char c1 = ' ', c2 = ' ';
				temp = sc.next();
				c1 = temp.charAt(0);
				temp = sc.next();
				c2 = temp.charAt(0);
				
				image.replace(c1, c2);
			}
			else if(command.equals("centroid")){
				String s = "";
				
				if(sc.hasNext()){
				s = sc.next();
				} else {
					input_error = true;
					break;
				}
				char c = s.charAt(0);
				if(image.getCentroid(c) == null){
					System.out.println("null");
				} else {
					System.out.println(image.getCentroid(c).toString());
				}
			}
			else if(command.equals("grow")){		
				String s = "";
				
				if(sc.hasNext()){
				s = sc.next();
				} else {
					input_error = true;
					break;
				}
				char c = s.charAt(0);
				image.growRegion(c);
			}
			else if(command.equals("undo")){				
			
				AsciiImage Pimage = ascii_stack.pop();		
				
				if(Pimage == null){				
					System.out.println("STACK EMPTY");
				} else {
					image=Pimage;
					System.out.printf("STACK USAGE %d/%d\n",ascii_stack.size(), ascii_stack.capacity());
					
				}
			}
			else if(command.equals("print")){				
				System.out.println(image.toString());
			} else {
				System.out.println("UNKNOWN COMMAND");
				break;
			}

			/**
			*Wenn einer der Befehle eingegeben wurde, wird eine Kopie des Bildes auf dem Stack abgelegt.
			*/	
			if(command.equals("grow") || 				
			command.equals("clear") || 
			command.equals("replace") || 
			command.equals("line") || 
			command.equals("transpose") || 
			command.equals("load"))
			{
				ascii_stack.push(copy);
			}
			/*if(command.equals("symmetric-h")){
				
				if(image.symmetric() == true){
					System.out.println("true");
				} else {
					System.out.println("false");
				}
			}
			
			if(command.equals("uniqueChars")){
				System.out.println(image.getUniqueChars());	
			}
			if(command.equals("flip-v")){
				image.flipV();
			}*/
		}
		/**
		*Werden die bool'schen error variablen "true", wird der entsprechende Fehler ausgegeben.
		*/
		if(input_error == true){
			System.out.println("INPUT MISMATCH");
		} 
		if(op_error == true){
			System.out.println("OPERATION FAILD");
		}
	}
}
