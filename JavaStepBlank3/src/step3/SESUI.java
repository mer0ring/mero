package step3;

import java.util.Scanner;

/**
 * <pre>
 * SES(Soft Engineer School) ���� ���α׷��� ����� ȭ��(User Interface) Ŭ����
 * ����ڷκ��� ó���� ���õ� �Է��� �ް�, SESManager Ŭ������ ���� ó���� ����� �����ش�.
 * </pre>
 */
public class SESUI {
	private SESManager manager = new SESManager(); 	//��û�� ���õ� ó���� �ϱ� ���� ������ SESManager Ŭ������ ��ü
	private Scanner sc = new Scanner(System.in); 	//Ű����κ��� ������ �Է¹ޱ� ���� ������ Scanner Ŭ������ ��ü
	
	/**
	 * <pre>
	 * SES(Soft Engineer School) ���� ���α׷��� ����� ȭ���� �����ϰ� ����� �Է��� ����Ѵ�.
	 * ���α׷��� ���� �޴��� �����ϱ� ������ ���� �ݺ��Ͽ� ó�� �ȴ�.
	 * </pre> 
	 * */
	public SESUI() {
		while(true) {
			// �޴��� ����Ѵ�
			printMainMenu();
			
			// �޴���ȣ�� ���ڷ� �Է¹޴´�
			int no = 0;
			try {
				no = sc.nextInt();
			}
			catch (Exception e) {
				// ���ڷ� �Է¹��� �� ���� ������ �� ��� Exception ó��
				e.printStackTrace();
			}
			
			//�Է¹��� ��ȣ�� ���� ó��
			switch(no){
				// Human ��ü�� �����Ͽ� �߰��Ѵ�
				case 1: 
					insertHuman();
					break;
					
				// �ֹι�ȣ�� �Է¹޾� �ش��ϴ� Human ��ü�� ã�´�
				case 2: 
									
					System.out.print("|�ֹι�ȣ | ");
					String search = getJuminFromUser();
					Human canSearch = manager.findHuman(search);
					
					if (canSearch == null) {
						System.out.println("������� ã�� �� �����ϴ�.");
					} else {
						System.out.println(canSearch);
					}
					
					// �ֹι�ȣ�� �Է¹޴´�
					// �Ŵ��� ��ü�κ��� �ֹι�ȣ�� �ش��ϴ� ��ü�� ã�´�
					//����� ������ ����ϰ�, ������ "�˻� ����� �����ϴ�."
					break;
					
				// �ֹι�ȣ�� �ش��ϴ� Human ��ü�� �����Ѵ�
				case 3: 
					System.out.print("|�ֹι�ȣ | ");
					String delete = getJuminFromUser();
					
					manager.deleteHuman(delete);
					
					// �ֹι�ȣ�� �Է¹޴´�
					// �Ŵ��� ��ü�κ��� �ֹι�ȣ�� �ش��ϴ� ��ü�� ������ �õ��ϰ� ���� ���θ� �����޴´�
					// ���������� �����Ǿ����� ������ �����Ͱ� ������ ����� ����Ѵ�.
					break;
					
				// ���� ����Ǿ� �ִ� ��� Human ��ü�� ����Ѵ�
				case 4: 
					manager.showAll();
					break;

				// ���α׷��� �����Ѵ�
				case 9: 
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
					break;
				
				// ���� ��ȣ�� �ش����� �ʴ´ٸ� �����Ѵ�
				default:
			}
		}
	}
	
	/**
	 * <pre>
	 * SES(Soft Engineer School) ���� ���α׷��� ��� �޴��� ���� ó���� ����Ѵ�.
	 * �����ο�(����, ������, ���)�� ���� ����� ���� �޴��� �����ְ�, �Է¹��� Professor, Trainee, Staff ��ü�� SESManager�� ���� ����Ѵ�.
	 * </pre>
	 * */
	public void insertHuman(){
		while(true){
			// ��� �޴��� ����Ѵ�
			printInsertMenu();
			
			// �޴���ȣ�� ���ڷ� �Է¹޴´�
			int no = 0;
			
			try {
				no = sc.nextInt();
			}
			catch (Exception e) {
				// ���ڷ� �Է¹��� �� ���� ������ �� ��� Exception ó��
				e.printStackTrace();
			}
			
			switch (no) {
				case 1: 
				case 2:
				case 3:
					//����ڷκ��� �Է¹޾� ��ü�� �����Ѵ�.
					Human h = makeHuman(no);
					
					//������ ��ü�� �Ŵ����� �����Ͽ� �����Ѵ�.
					//�����ϵǾ����� ������ �ֹι�ȣ�� �����ϴ��� ����Ѵ�.
					boolean search = manager.insertHuman(h);
					
					if (search) {
						// ������
						System.out.println("������ �Ǿ����ϴ�.");
					} else {
						// ���� �ֹι�ȣ ����
						System.out.println("������ �ֹι�ȣ�� �̹� �����մϴ�.");
					}
					break;
					
				// ���� �޴��� �̵��Ѵ�
				case 4: return;	
				default:
			}
		}
	}
	
	/**
	 * SES(Soft Engineer School) ���� ���α׷��� ���� �޴��� ����Ѵ�.
	 * */
	public void printMainMenu(){
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� Soft Engineer School ���� �ý��� ��");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������");
		System.out.println("��1.���                                      ��");	
		System.out.println("��2.ã��                                      ��");	
		System.out.println("��3.����                                      ��");	
		System.out.println("��4.��ü���                                  ��");	
		System.out.println("��9.����                                      ��");
		System.out.println("����������������������������������������������������������������");
		System.out.print(" �޴� ��ȣ�� �����ϼ���=> ");	
	}
	
	/**
	 * SES(Soft Engineer School) ���� ���α׷��� �����ο� ��� ���� �޴��� ����Ѵ�.
	 * */
	public void printInsertMenu(){
		System.out.println("����������������������������������������������������������������");
		System.out.println("��        SES �����ο� ���              ��");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������");
		System.out.println("��1.����                                      ��");	
		System.out.println("��2.������                                    ��");	
		System.out.println("��3.���                                    ��");	
		System.out.println("��4.�����޴�                                  ��");
		System.out.println("����������������������������������������������������������������");
		System.out.print(" �޴� ��ȣ�� �����ϼ���=> ");	
	}
	
	/**
	 * �Ű������� �־��� Ÿ�� ���� ���� ����, ������, ��� ������ Ű����� �Է¹޾� ������ ��ü�� �����Ͽ� ��ȯ�Ѵ�.
	 * @param type SES �����ο� ��� �޴����� ���õ� ��ȣ ��. 1:����, 2:������, 3:���
	 * @return SES �����ο� ��� �޴����� ���õ� ��ȣ�� ���� ������ Professor, Trainee, Staff ��ü
	 * */
	public Human makeHuman(int type){
		Human h = null;
		String name = getNameFromUser() ;
		int age = getAgeFromUser();
		String jumin = getJuminFromUser();
		
		switch(type){
			case 1: System.out.print("|����| ");
					String major = sc.next();
					h = new Professor(name, age, jumin, major);
					break;
			case 2: System.out.print("|�й�| ");
					String stdNo = sc.next();
					h = new Trainee(name, age, jumin, stdNo);
					break;
			case 3: System.out.print("|�μ�| ");
					String field = sc.next();
					h = new Staff(name, age, jumin, field);
		}
		
		return h;
	}
	
	/**
	 * �̸� ������ Ű����� �Է¹޾� ��ȯ�Ѵ�.
	 * @return Ű����� �Է¹��� �̸�
	 * */
	private String getNameFromUser() {
		System.out.print("|�̸�| ");
		String name = sc.next();
		return name;
	}
	
	/**
	 * �ֹι�ȣ ������ Ű����� �Է¹޾� ��ȯ�Ѵ�.
	 * @return Ű����� �Է¹��� �ֹι�ȣ
	 * */
	private String getJuminFromUser() {
		String jumin = "";
		
		while (true) {
			System.out.print("|�ֹι�ȣ(���ڸ�)| ");
			jumin = sc.next();
			
			if (jumin.length() == 13) {
				break;
			}
			
			System.out.println("[����] �ֹι�ȣ ������ �ٸ��ϴ�");
		}
		
		return jumin;
	}
	
	/**
	 * ���� ������ Ű����� �Է¹޾� ��ȯ�Ѵ�.
	 * @return Ű����� �Է¹��� ����
	 * */
	private int getAgeFromUser() {
		int age = 0;
		do {
			System.out.print("|����| ");
			try {
				age = sc.nextInt();
			}
			catch (Exception e) {
				// e.printStackTrace();
				System.out.println("[����] ���ڸ� �Է��� �ֽʽÿ�");
				
				// ������ ���� ��� �̹� �Է¹��� ���ڸ� ������ ��� �ǹǷ� ����
				sc.nextLine();
			}
		}
		while (age <= 0);
		
		return age;
	}
}
