package step3;

/**
 * <pre>
 * SES(Soft Engineer School) ���� ���α׷��� �����ο� �� ������ ���� ������ �����ϴ� Ŭ����
 * Human Ŭ������ ����ϰ� ������, Professor ��ü�� �߰����� ������ ������ ��� ������ ���´�.
 * </pre>
 * */
public class Professor extends Human {
	private String major; //������ ��������

	/**
	 * �⺻ ������
	 */
	public Professor() {}

	/**
	 * �־��� �̸�, ����, �ֹι�ȣ, �������� ������ ������ ���ο� Professor ��ü�� �����Ѵ�.
	 * @param name ������ �̸�
	 * @param age ������ ����
	 * @param jumin ������ �ֹι�ȣ
	 * @param major ������ ��������
	 * */
	public Professor(String name, int age, String jumin, String major) {
		super(name, age, jumin);
		this.major = major;
	}

	/**
	 * ���������� ��ȸ�Ѵ�.
	 * @return Professor ��ü�� ������ �ִ� ��������
	 * */
	public String getMajor() {
		return major;
	}

	/**
	 * ���ο� ������������ �����Ѵ�.
	 * @param major �����ϰ��� �ϴ� ���ο� ��������
	 * */
	public void setMajor(String major) {
		this.major = major;
	}
	
	/**
	 * ��ü�� ������ �ִ� �̸�, ����, �ֹι�ȣ, ���� ������ ���ڿ��� �����Ѵ�.
	 * @return ��ü�� ����
	 */
	@Override
	public String toString() {
		return super.toString() + ", ����:" + major;
	}
}
