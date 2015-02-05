import java.util.Scanner;

public class AsciiShop{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int height = 0;
		AsciiImage image = new AsciiImage();;
		boolean input_error = false;
		boolean op_error = false;
		
		if(sc.hasNext() && sc.next().equals("read") && sc.hasNextInt()){
			height = sc.nextInt();
		} else {
			input_error = true;	
		}
		
		for(int i=1;i<=height;i++){
			image.addLine(sc.next());
		}
		
		String command = "";
		
		while(sc.hasNext()){
			command = sc.next();
			
			if(command.equals("uniqueChars")){
				
				System.out.println(image.getUniqueChars());	
			}
			else if(command.equals("flip-v")){
				
				image.flipV();
			}
			else if(command.equals("transpose")){
				
				image.transpose();
			}
			else if(command.equals("fill")){
				
				int x = sc.nextInt();
				int y = sc.nextInt();
				String a = sc.next();
				char c = a.charAt(0);
				
				if(x<image.getWidth() && y<image.getHeight()){
					image.fill(x, y, c);
				} else {
					op_error = true;
				}
			}
			else if(command.equals("symmetric-h")){
				
				if(image.symmetric() == true){
					System.out.println("true");
				} else {
					System.out.println("false");
				}
				
			} else {
				input_error = true;
			}
		}
		
		if(input_error == false && op_error == false){
			System.out.print(image.toString());
			System.out.println(image.getWidth() + " " + image.getHeight());
			
		} else if(input_error == true){
			System.out.println("INPUT MISMATCH");
			
		} else if(op_error == true){
			System.out.println("OPERATION FAILED");
		}
	}
	
}
