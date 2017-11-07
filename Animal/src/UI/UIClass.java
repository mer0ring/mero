package UI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Manager.ManagerClass;
import VO.Bird;
import VO.Fish;
import VO.Mammal;
import VO.Pet;

public class UIClass {
	
	// Scanner ���� 
	private Scanner bk;
	
	//Manager ����
	private ManagerClass manager;
	private Pet pet = null;

	public UIClass() {
		// Manager, Scanner ����
		// ��¹� ����
		manager = new ManagerClass();
		bk = new Scanner(System.in);
	}

	public void UI() {
		boolean flag = true;
		while (flag) {
			MainMenu();
			switch (bk.nextInt()) {
			case 1:
				System.out.println("=========�� ��=========");
				data(1);
				//(1) ��ϰ� ���� ����
				break;
			case 2:
				System.out.println("=========�� ��=========");
				search();
				break;
			case 3:
				System.out.println("=========��� ������ ��ü����=========");
				print();
				break;
			case 4:
				System.out.println("=========�� ��=========");
				data(2);
				//(2) ��ϰ� ���� ����
				break;
			case 5:
				System.out.println("=========�� ��=========");
				delete();
				break;
			case 6:
				System.out.println("=========�� ��=========");
				checkSave();
				break;
			case 7:
				System.out.println("=========�ҷ� ����=========");
				checkLoad();
				break;
			case 8:
				System.out.println("���α׷��� ���� �մϴ�.");
				flag = false;
				break;
			default:
				System.out.println("�޴� �ٽ� ����");
				break;
			}
		}
	}

	public Pet data(int k) {
		subMenu();
		switch (bk.nextInt()) {
		
		// registration() ����Ͽ�  ���� Return �޾� Manager ����
		// ��ϰ� ������ data �޼ҵ� ���. (�Ű������� ����)
			case 1: // ������
				Pet mammal = (Pet) registration(1);
				if (k == 1) {
					manager.register(mammal);
					return mammal;
				} else if (k == 2) {
					manager.modify(mammal);
					return mammal;
				}
										
			case 2: // ���
				Pet fish = (Pet) registration(2);
				if (k == 1) {
					manager.register(fish);
					return fish;
				} else if (k == 2) {
					manager.modify(fish);
					return fish;
				}
				
			case 3: // ����
				Pet bird = (Pet) registration(3);
				if (k == 1) {
					manager.register(bird);
					return bird;
				} else if (k == 2) {
					manager.modify(bird);
					return bird;
				}
			case 4:// ���� �޴���
				System.out.println("���� �޴��� ���ϴ�.");
				return null;
			default:
				return null;
		}
	}

	public String getName() {
		System.out.println("�̸�: ");
		String Name = bk.next();
		return Name;
	}

	private Object registration(int select) {
		// �Ű����� (������, ����, �������)�̿��Ͽ� �����Ͽ� return
		// Object ���·� return
		Object obj = null;
		boolean loop = true;
				
		while(loop) {
			
			if (select == 9) {
				break;
			}
			
			System.out.print("| �� �� | ");
			String name = bk.next();
			
			System.out.print("| �� �� | ");
			String age = bk.next();
			
			switch (select) {
			
				case 1:			// ������
					
					System.out.print("| ������ ���� | ");
					String type1 = bk.next();
					
					obj = new Mammal(name, age, type1);
					break;
										
				case 2:			// ����
					
					System.out.print("| ���� ���� | ");
					String type2 = bk.next();
					
					obj = new Bird(name, age, type2);
					break;
				
				case 3:			// ���
					
					System.out.print("| ��� ���� | ");
					String type3 = bk.next();
					
					obj = new Fish(name, age, type3);
					break;
	
				default:
					loop = false;
					break;
			}
			
		}
				
		return obj;
	}

	public void search() {
		//�˻� Manager ����
		String name = getName();
		Pet canSearch = manager.search(name);
		
		if (canSearch == null) {
			System.out.println("�˻��� ���� �������� �ʽ��ϴ�.");
		} else {
			System.out.println(canSearch);
		}
	}

	public void print() {
		// ��� Manager ����
		
		ArrayList<Pet> canPrint = manager.allPrint();
		
		if (canPrint.size() == 0) {
			System.out.println("����� ���� �������� �ʽ��ϴ�.");
		} else {
			for (Pet pet : canPrint) {
				System.out.println(pet);
			}
		}
	}

	public void delete() {
		//���� Manager ����
		
		System.out.print("������ ���� �̸� : ");
		String name = bk.next();
		
		manager.delete(name);
	}

	public void checkSave() {

		try {
			manager.saveFile();
			System.out.println("����.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void checkLoad() {

		try {
			manager.loadFile();
			System.out.println("�ҷ����� �Ϸ�.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void MainMenu() {
		System.out.println("1.���");
		System.out.println("2.�˻�");
		System.out.println("3.��ü����");
		System.out.println("4.����");
		System.out.println("5.����");
		System.out.println("6.����");
		System.out.println("7.�ҷ�����");
		System.out.println("8.����");
	}

	public void subMenu() {
		System.out.println("1.������");
		System.out.println("2.���");
		System.out.println("3.����");
		System.out.println("4.���� �޴���");
	}

}
