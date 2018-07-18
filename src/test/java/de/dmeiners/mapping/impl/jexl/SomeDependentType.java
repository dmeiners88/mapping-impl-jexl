package de.dmeiners.mapping.impl.jexl;

public class SomeDependentType {

	private String someProperty;

	public SomeDependentType(String someProperty) {
		this.someProperty = someProperty;
	}

	public String getSomeProperty() {
		return someProperty;
	}

	public void setSomeProperty(String someProperty) {
		this.someProperty = someProperty;
	}
}
