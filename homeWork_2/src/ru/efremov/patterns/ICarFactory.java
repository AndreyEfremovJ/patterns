package ru.efremov.patterns;

import static java.lang.System.out;

interface IBody {
	void createBody();
}

interface IEngine {
	void createEngine();
}

interface ISalon {
	void createSalon();
}

interface ICarFactory {
	IBody getIBody();

	IEngine getIEngine();

	ISalon getISalon();
}

class BMWBody implements IBody {
	public void createBody() {
		out.println("create body for BMW");
	}
}

class BMWEngine implements IEngine {
	public void createEngine() {
		out.println("create engine for BMW");
	}
}

class BMWSalon implements ISalon {
	public void createSalon() {
		out.println("create salon for BMW");
	}
}

class AUDIBody implements IBody {
	public void createBody() {
		out.println("create body for AUDI");
	}
}

class AUDIEngine implements IEngine {
	public void createEngine() {
		out.println("create engine for AUDI");
	}
}

class AUDISalon implements ISalon {
	public void createSalon() {
		out.println("create salon for AUDI");
	}
}

class BMWFactory implements ICarFactory {

	public IBody getIBody() {
		return new BMWBody();
	}

	public IEngine getIEngine() {
		return new BMWEngine();
	}

	public ISalon getISalon() {
		return new BMWSalon();
	}
}

class AUDIFactory implements ICarFactory {

	public IBody getIBody() {
		return new AUDIBody();
	}

	public IEngine getIEngine() {
		return new AUDIEngine();
	}

	public ISalon getISalon() {
		return new AUDISalon();
	}
}
