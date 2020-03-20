package car.factory.pattern;

public class Toyota extends Car{

	@Override
	void View() {
		System.out.println("Toyota view: INNOVA | CAMRY | VIOS");
		System.out.println("Toyota Model : 2017 | 2018 | 2019");
	}

	@Override
	void ColorCar() {
		System.out.println("Toyota Color view : White | Black | Red | Yellow......");
		
	}

}
