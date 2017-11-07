package VO;

import java.io.Serializable;

public class Pet implements Serializable {

	private String name;

	private String age;

	public Pet() {
	}

	
	public Pet(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Pet의 이름: " + name + " , Pet의 나이: " + age;
	}

	
}
