package step3;

/**
 * <pre>
 * SES(Soft Engineer School) 관리 프로그램의 관리인원 중 교수에 대한 정보를 관리하는 클래스
 * Human 클래스를 상속하고 있으며, Professor 객체의 추가적인 정보인 전공을 멤버 변수로 갖는다.
 * </pre>
 * */
public class Professor extends Human {
	private String major; //교수의 전공과목

	/**
	 * 기본 생성자
	 */
	public Professor() {}

	/**
	 * 주어진 이름, 나이, 주민번호, 전공과목 정보를 가지고 새로운 Professor 객체를 생성한다.
	 * @param name 교수의 이름
	 * @param age 교수의 나이
	 * @param jumin 교수의 주민번호
	 * @param major 교수의 전공과목
	 * */
	public Professor(String name, int age, String jumin, String major) {
		super(name, age, jumin);
		this.major = major;
	}

	/**
	 * 전공과목을 조회한다.
	 * @return Professor 객체가 가지고 있는 전공과목
	 * */
	public String getMajor() {
		return major;
	}

	/**
	 * 새로운 전공과목으로 변경한다.
	 * @param major 변경하고자 하는 새로운 전공과목
	 * */
	public void setMajor(String major) {
		this.major = major;
	}
	
	/**
	 * 객체가 가지고 있는 이름, 나이, 주민번호, 전공 정보를 문자열로 리턴한다.
	 * @return 객체의 내용
	 */
	@Override
	public String toString() {
		return super.toString() + ", 전공:" + major;
	}
}
