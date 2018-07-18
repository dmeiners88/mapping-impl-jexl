package de.dmeiners.mapping.impl.jexl;

public class SomeType {

	private SomeDependentType dependent;

	public SomeType(SomeDependentType dependent) {
		this.dependent = dependent;
	}

	public SomeDependentType getDependent() {
		return dependent;
	}

	public void setDependent(SomeDependentType dependent) {
		this.dependent = dependent;
	}
}
