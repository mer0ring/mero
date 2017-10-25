package step3;

/**
 * <pre>
 * SES(Soft Engineer School) ���� ���α׷��� �����ο� �� ����� ���� ������ �����ϴ� Ŭ����
 * Human Ŭ������ ����ϰ� ������, Staff ��ü�� �߰����� ������ �μ��� ��� ������ ���´�.
 * </pre>
 * */
public class Staff extends Human {
	private String field; //����� �μ�

	/**
	 * �⺻ ������
	 */
	public Staff() {}


	/**
	 * �־��� �̸�, ����, �ֹι�ȣ, �μ� ������ ������ ���ο� Staff ��ü�� �����Ѵ�.
	 * @param name ����� �̸�
	 * @param age ����� ����
	 * @param jumin ����� �ֹι�ȣ
	 * @param field ����� �μ�
	 * */
	public Staff(String name, int age, String jumin, String field) {
		super(name, age, jumin);
		this.field = field;
	}

	/**
	 * �μ��� ��ȸ�Ѵ�.
	 * @return Staff ��ü�� ������ �ִ� �μ�
	 * */
	public String getField() {
		return field;
	}

	/**
	 * ���ο� �μ��� �����Ѵ�.
	 * @param field �����ϰ��� �ϴ� ���ο� �μ�
	 * */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * ��ü�� ������ �ִ� �̸�, ����, �ֹι�ȣ, �μ� ������ ���ڿ��� �����Ѵ�.
	 * @return ��ü�� ����
	 */
	@Override
	public String toString() {
		return super.toString() + ", �μ�:" + field;
	}
}
