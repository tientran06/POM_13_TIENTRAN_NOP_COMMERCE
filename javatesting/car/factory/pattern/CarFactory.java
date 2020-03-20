package car.factory.pattern;

public class CarFactory {
	public void viewCar(String carType) {
		Car car;
		if (carType.equalsIgnoreCase("HONDA")) {
			car = new Honda();
			car.View();
		} else if(carType.equalsIgnoreCase("LEXUS")) {
			car = new Lexus();
			car.View();
		}else if(carType.equalsIgnoreCase("TOYOTA")) {
			car = new Toyota();
			car.View();
		}
	}

}
