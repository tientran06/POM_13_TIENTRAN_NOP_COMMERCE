package car.factory.pattern;

public class Honda extends Car{

	@Override
	void View() {
		System.out.println("Honda view: CIVIC | HRV | BRIO | JAZZ");
		System.out.println("Honda Model : 2017 | 2018 | 2019");
		
	}

	@Override
	void ColorCar() {
		System.out.println("Honda Color view : White | Black | Red | Yellow......");
		
	}

}
