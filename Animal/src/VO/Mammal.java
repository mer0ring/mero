package VO;

public class Mammal extends Pet {
	private String kindOfMammal;

	public Mammal() {
	}

	public Mammal(String name, String age, String kindOfMammal) {
		super(name, age);
		this.kindOfMammal = kindOfMammal;
	}

	public String getKindOfMammal() {
		return kindOfMammal;
	}

	public void setKindOfMammal(String kindOfMammal) {
		this.kindOfMammal = kindOfMammal;
	}

	@Override
	public String toString() {
		return super.toString()+ "포유류 종류: " + kindOfMammal;
	}

	
	
}
