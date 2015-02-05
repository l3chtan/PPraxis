
public class App {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Locomotive lok1 = new Locomotive(12.0, 12.0, 12); 
		Train train  = new Train(lok1); 
		PassengerCar w1 = new PassengerCar(1.1, 1.1, 11); 
		PassengerCar w2 = new PassengerCar(2.2, 2.2, 22);
		DiningCar d1 = new DiningCar(3.3,3.3, 100, false); 
		PassengerCar w3 = new PassengerCar(4.2, 4.2, 44);
		train.add(w1); 
		train.add(d1);
		train.add(w2);
		train.add(w3);
		train.hasOpenDiningCar(); 
		System.out.println(train.toString()); 
		
		
		

	}

}
