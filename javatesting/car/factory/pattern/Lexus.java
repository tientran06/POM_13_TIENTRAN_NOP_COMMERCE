package car.factory.pattern;

public class Lexus extends Car{

	@Override
	void View() {
		System.out.println("Lexus view: LexusGS | LexusRS | LexusES | LexusRX");
		System.out.println("Lexus Model : 2017 | 2018 | 2019");
	}

	@Override
	void ColorCar() {
		System.out.println("Lexus Color view : White | Black | Red | Yellow......");
		
	}

}
