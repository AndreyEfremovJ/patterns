package ru.efremov.patterns;

public class AbstractFactory {

	public static void main(String[] args) {

		ICarFactory factory = getFactoryByNameCar("AUDI");
		IBody body = factory.getIBody();
		IEngine engine = factory.getIEngine();
		ISalon salon = factory.getISalon();

		body.createBody();
		engine.createEngine();
		salon.createSalon();
	}

	private static ICarFactory getFactoryByNameCar(String lang) {
		switch (lang) {
		case "BMW":
			return new BMWFactory();
		case "AUDI":
			return new AUDIFactory();
		default:
			throw new RuntimeException("Unknown name car!!!: " + lang);
		}
	}
}
