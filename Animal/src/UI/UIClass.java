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
	
	// Scanner 선언 
	private Scanner bk;
	
	//Manager 선언
	private ManagerClass manager;
	private Pet pet = null;

	public UIClass() {
		// Manager, Scanner 생성
		// 출력문 연결
		manager = new ManagerClass();
		bk = new Scanner(System.in);
	}

	public void UI() {
		boolean flag = true;
		while (flag) {
			MainMenu();
			switch (bk.nextInt()) {
			case 1:
				System.out.println("=========등 록=========");
				data(1);
				//(1) 등록과 수정 구분
				break;
			case 2:
				System.out.println("=========검 색=========");
				search();
				break;
			case 3:
				System.out.println("=========등록 데이터 전체보기=========");
				print();
				break;
			case 4:
				System.out.println("=========수 정=========");
				data(2);
				//(2) 등록과 수정 구분
				break;
			case 5:
				System.out.println("=========삭 제=========");
				delete();
				break;
			case 6:
				System.out.println("=========저 장=========");
				checkSave();
				break;
			case 7:
				System.out.println("=========불러 오기=========");
				checkLoad();
				break;
			case 8:
				System.out.println("프로그램을 종료 합니다.");
				flag = false;
				break;
			default:
				System.out.println("메뉴 다시 선택");
				break;
			}
		}
	}

	public Pet data(int k) {
		subMenu();
		switch (bk.nextInt()) {
		
		// registration() 사용하여  생성 Return 받아 Manager 연결
		// 등록과 수정은 data 메소드 사용. (매개변수로 구분)
			case 1: // 포유류
				Pet mammal = (Pet) registration(1);
				if (k == 1) {
					manager.register(mammal);
					return mammal;
				} else if (k == 2) {
					manager.modify(mammal);
					return mammal;
				}
										
			case 2: // 어류
				Pet fish = (Pet) registration(2);
				if (k == 1) {
					manager.register(fish);
					return fish;
				} else if (k == 2) {
					manager.modify(fish);
					return fish;
				}
				
			case 3: // 조류
				Pet bird = (Pet) registration(3);
				if (k == 1) {
					manager.register(bird);
					return bird;
				} else if (k == 2) {
					manager.modify(bird);
					return bird;
				}
			case 4:// 상위 메뉴로
				System.out.println("상위 메뉴로 갑니다.");
				return null;
			default:
				return null;
		}
	}

	public String getName() {
		System.out.println("이름: ");
		String Name = bk.next();
		return Name;
	}

	private Object registration(int select) {
		// 매개변수 (포유류, 조류, 어류구분)이용하여 생성하여 return
		// Object 형태로 return
		Object obj = null;
		boolean loop = true;
				
		while(loop) {
			
			if (select == 9) {
				break;
			}
			
			System.out.print("| 이 름 | ");
			String name = bk.next();
			
			System.out.print("| 나 이 | ");
			String age = bk.next();
			
			switch (select) {
			
				case 1:			// 포유류
					
					System.out.print("| 포유류 종류 | ");
					String type1 = bk.next();
					
					obj = new Mammal(name, age, type1);
					break;
										
				case 2:			// 조류
					
					System.out.print("| 조류 종류 | ");
					String type2 = bk.next();
					
					obj = new Bird(name, age, type2);
					break;
				
				case 3:			// 어류
					
					System.out.print("| 어류 종류 | ");
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
		//검색 Manager 연결
		String name = getName();
		Pet canSearch = manager.search(name);
		
		if (canSearch == null) {
			System.out.println("검색할 값이 존재하지 않습니다.");
		} else {
			System.out.println(canSearch);
		}
	}

	public void print() {
		// 출력 Manager 연결
		
		ArrayList<Pet> canPrint = manager.allPrint();
		
		if (canPrint.size() == 0) {
			System.out.println("출력할 값이 존재하지 않습니다.");
		} else {
			for (Pet pet : canPrint) {
				System.out.println(pet);
			}
		}
	}

	public void delete() {
		//삭제 Manager 연결
		
		System.out.print("삭제할 동물 이름 : ");
		String name = bk.next();
		
		manager.delete(name);
	}

	public void checkSave() {

		try {
			manager.saveFile();
			System.out.println("저장.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void checkLoad() {

		try {
			manager.loadFile();
			System.out.println("불러오기 완료.");
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
		System.out.println("1.등록");
		System.out.println("2.검색");
		System.out.println("3.전체보기");
		System.out.println("4.수정");
		System.out.println("5.삭제");
		System.out.println("6.저장");
		System.out.println("7.불러오기");
		System.out.println("8.종료");
	}

	public void subMenu() {
		System.out.println("1.포유류");
		System.out.println("2.어류");
		System.out.println("3.조류");
		System.out.println("4.상위 메뉴로");
	}

}
