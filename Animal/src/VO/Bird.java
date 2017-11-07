package VO;

public class Bird extends Pet{
	private String kindOfBird;

	public Bird() {
	}

	public Bird(String name, String age, String kindOfBird) {
		super(name, age);
		this.kindOfBird = kindOfBird;
	}

	public String getKindOfBird() {
		return kindOfBird;
	}

	public void setKindOfBird(String kindOfBird) {
		this.kindOfBird = kindOfBird;
	}

	@Override
	public String toString() {
		return super.toString()+ "새의 종류: " + kindOfBird;
	}
	
}
