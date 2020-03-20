package car.factory.pattern;

public class Customer {
	public static void main(String[] args) {
		CarFactory carFactory = new CarFactory();
		Customer customer = new Customer();
		// apply Factory Pattern
		carFactory.viewCar("HONDA");
		carFactory.viewCar("LEXUS");
		carFactory.viewCar("TOYOTA");
		
		System.out.println("-----------------------------------");
		// Dont apply Factory Pattern
		// ham se tro nen cong kenh hon neu detail nhieu len
		customer.ViewHonda();
		customer.ViewLexus();
		customer.ViewToyota();
	}
	public void ViewHonda() {
		Honda honda = new Honda();
		honda.View();
		honda.ColorCar();
	}
	public void ViewLexus() {
		Lexus lexus = new Lexus();
		lexus.View();
		lexus.ColorCar();
	}
	public void ViewToyota() {
		Toyota toyota = new Toyota();
		toyota.View();
		toyota.ColorCar();
	}

}
