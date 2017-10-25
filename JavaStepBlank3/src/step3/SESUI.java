package step3;

import java.util.Scanner;

/**
 * <pre>
 * SES(Soft Engineer School) 관리 프로그램의 사용자 화면(User Interface) 클래스
 * 사용자로부터 처리와 관련된 입력을 받고, SESManager 클래스를 통해 처리된 결과를 보여준다.
 * </pre>
 */
public class SESUI {
	private SESManager manager = new SESManager(); 	//요청과 관련된 처리를 하기 위해 생성한 SESManager 클래스의 객체
	private Scanner sc = new Scanner(System.in); 	//키보드로부터 정보를 입력받기 위해 생성한 Scanner 클래스의 객체
	
	/**
	 * <pre>
	 * SES(Soft Engineer School) 관리 프로그램의 사용자 화면을 구성하고 사용자 입력을 대기한다.
	 * 프로그램은 종료 메뉴를 선택하기 전까지 무한 반복하여 처리 된다.
	 * </pre> 
	 * */
	public SESUI() {
		while(true) {
			// 메뉴를 출력한다
			printMainMenu();
			
			// 메뉴번호를 숫자로 입력받는다
			int no = 0;
			try {
				no = sc.nextInt();
			}
			catch (Exception e) {
				// 숫자로 입력받을 수 없는 에러가 날 경우 Exception 처리
				e.printStackTrace();
			}
			
			//입력받은 번호에 따라 처리
			switch(no){
				// Human 객체를 생성하여 추가한다
				case 1: 
					insertHuman();
					break;
					
				// 주민번호를 입력받아 해당하는 Human 객체를 찾는다
				case 2: 
									
					System.out.print("|주민번호 | ");
					String search = getJuminFromUser();
					Human canSearch = manager.findHuman(search);
					
					if (canSearch == null) {
						System.out.println("결과값을 찾을 수 없습니다.");
					} else {
						System.out.println(canSearch);
					}
					
					// 주민번호를 입력받는다
					// 매니저 객체로부터 주민번호로 해당하는 객체를 찾는다
					//결과가 있으면 출력하고, 없으면 "검색 결과가 없습니다."
					break;
					
				// 주민번호로 해당하는 Human 객체를 삭제한다
				case 3: 
					System.out.print("|주민번호 | ");
					String delete = getJuminFromUser();
					
					manager.deleteHuman(delete);
					
					// 주민번호를 입력받는다
					// 매니저 객체로부터 주민번호에 해당하는 객체를 삭제를 시도하고 성공 여부를 돌려받는다
					// 정상적으로 삭제되었는지 삭제할 데이터가 없는지 결과를 출력한다.
					break;
					
				// 현재 저장되어 있는 모든 Human 객체를 출력한다
				case 4: 
					manager.showAll();
					break;

				// 프로그램을 종료한다
				case 9: 
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
				
				// 위의 번호에 해당하지 않는다면 무시한다
				default:
			}
		}
	}
	
	/**
	 * <pre>
	 * SES(Soft Engineer School) 관리 프로그램의 등록 메뉴에 대한 처리를 담당한다.
	 * 관리인원(교수, 연수생, 운영진)에 대한 등록을 서브 메뉴로 보여주고, 입력받은 Professor, Trainee, Staff 객체를 SESManager를 통해 등록한다.
	 * </pre>
	 * */
	public void insertHuman(){
		while(true){
			// 등록 메뉴를 출력한다
			printInsertMenu();
			
			// 메뉴번호를 숫자로 입력받는다
			int no = 0;
			
			try {
				no = sc.nextInt();
			}
			catch (Exception e) {
				// 숫자로 입력받을 수 없는 에러가 날 경우 Exception 처리
				e.printStackTrace();
			}
			
			switch (no) {
				case 1: 
				case 2:
				case 3:
					//사용자로부터 입력받아 객체를 생성한다.
					Human h = makeHuman(no);
					
					//생성된 객체를 매니저로 전달하여 저장한다.
					//정상등록되었는지 동일한 주민번호가 존재하는지 출력한다.
					boolean search = manager.insertHuman(h);
					
					if (search) {
						// 정상등록
						System.out.println("정상등록 되었습니다.");
					} else {
						// 동일 주민번호 존재
						System.out.println("동일한 주민번호가 이미 존재합니다.");
					}
					break;
					
				// 상위 메뉴로 이동한다
				case 4: return;	
				default:
			}
		}
	}
	
	/**
	 * SES(Soft Engineer School) 관리 프로그램의 메인 메뉴를 출력한다.
	 * */
	public void printMainMenu(){
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ Soft Engineer School 관리 시스템 │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.등록                                      │");	
		System.out.println("│2.찾기                                      │");	
		System.out.println("│3.삭제                                      │");	
		System.out.println("│4.전체출력                                  │");	
		System.out.println("│9.종료                                      │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");	
	}
	
	/**
	 * SES(Soft Engineer School) 관리 프로그램의 관리인원 등록 서브 메뉴를 출력한다.
	 * */
	public void printInsertMenu(){
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│        SES 관리인원 등록              │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.교수                                      │");	
		System.out.println("│2.연수생                                    │");	
		System.out.println("│3.운영진                                    │");	
		System.out.println("│4.상위메뉴                                  │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");	
	}
	
	/**
	 * 매개변수로 주어진 타입 값에 따라 교수, 연수생, 운영진 정보를 키보드로 입력받아 각각의 객체를 생성하여 반환한다.
	 * @param type SES 관리인원 등록 메뉴에서 선택된 번호 값. 1:교수, 2:연수생, 3:운영진
	 * @return SES 관리인원 등록 메뉴에서 선택된 번호에 따라 생성된 Professor, Trainee, Staff 객체
	 * */
	public Human makeHuman(int type){
		Human h = null;
		String name = getNameFromUser() ;
		int age = getAgeFromUser();
		String jumin = getJuminFromUser();
		
		switch(type){
			case 1: System.out.print("|전공| ");
					String major = sc.next();
					h = new Professor(name, age, jumin, major);
					break;
			case 2: System.out.print("|학번| ");
					String stdNo = sc.next();
					h = new Trainee(name, age, jumin, stdNo);
					break;
			case 3: System.out.print("|부서| ");
					String field = sc.next();
					h = new Staff(name, age, jumin, field);
		}
		
		return h;
	}
	
	/**
	 * 이름 정보를 키보드로 입력받아 반환한다.
	 * @return 키보드로 입력받은 이름
	 * */
	private String getNameFromUser() {
		System.out.print("|이름| ");
		String name = sc.next();
		return name;
	}
	
	/**
	 * 주민번호 정보를 키보드로 입력받아 반환한다.
	 * @return 키보드로 입력받은 주민번호
	 * */
	private String getJuminFromUser() {
		String jumin = "";
		
		while (true) {
			System.out.print("|주민번호(숫자만)| ");
			jumin = sc.next();
			
			if (jumin.length() == 13) {
				break;
			}
			
			System.out.println("[에러] 주민번호 형식이 다릅니다");
		}
		
		return jumin;
	}
	
	/**
	 * 나이 정보를 키보드로 입력받아 반환한다.
	 * @return 키보드로 입력받은 나이
	 * */
	private int getAgeFromUser() {
		int age = 0;
		do {
			System.out.print("|나이| ");
			try {
				age = sc.nextInt();
			}
			catch (Exception e) {
				// e.printStackTrace();
				System.out.println("[에러] 숫자를 입력해 주십시오");
				
				// 에러가 났을 경우 이미 입력받은 문자를 제거해 줘야 되므로 실행
				sc.nextLine();
			}
		}
		while (age <= 0);
		
		return age;
	}
}
