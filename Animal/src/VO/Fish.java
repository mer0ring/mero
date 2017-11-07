package VO;

public class Fish extends Pet{
	private String kindOfFish;

	public Fish() {
	}

	public Fish(String name, String age, String kindOfFish) {
		super(name, age);
		this.kindOfFish = kindOfFish;
	}

	public String getKindOfFish() {
		return kindOfFish;
	}

	public void setKindOfFish(String kindOfFish) {
		this.kindOfFish = kindOfFish;
	}

	@Override
	public String toString() {
		return super.toString()+ "물고기 종류: " + kindOfFish;
	}
	
}
