package toy.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import toy.vo.Bicycle;
import toy.vo.Drone;
import toy.vo.GameConsole;
import toy.vo.Toy;

/**
 * 장난감 정보를 관리하는 클래스
 */
public class Manager {
	private final String FILE_NAME = "toyList.dat";
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ArrayList<Toy> toyList;		// 장난감 리스트

	
	/**
	 * Constructor
	 */
	public Manager() {
		if(new File(FILE_NAME).exists()){
			loadFile();
		} else {
			toyList = new ArrayList<Toy>();
		}
	}
	
	/**
	 * toyList.dat를 저장한다
	 */
	public void saveFile() {
		
		try {
			fos = new FileOutputStream(FILE_NAME);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(toyList);
			oos.flush();
			
		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * toyList.dat를 불러온다
	 */
	public void loadFile() {
		
		try {
			fis = new FileInputStream(FILE_NAME);
			ois = new ObjectInputStream(fis);
			
			toyList = (ArrayList<Toy>) ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 장난감을 저장한다. 장난감은 code에 의해 분류되고 같은 code는 사용할 수 없다.
	 * @param toy 저장할 장난감 정보
	 * @return 저장 여부
	 */
	public boolean insert(Toy toy) {
		
		boolean result = true;
		
		if (search(toy.getCode()) != null) {
			result = false;
			
		} else {
			toyList.add(toy);
			saveFile();
		}
		
		return result;
	}
	
	/**
	 * code를 통해 장난감을 찾는다. 코드가 일치하는 장난감을 찾으면 그것을 반환한다.
	 * @param code 검색할 장난감 코드
	 * @return 일치하는 장난감 정보
	 */
	public Toy search(String code) {
		
		for (int i = 0; i < toyList.size(); i++) {
			if (code.equals(toyList.get(i).getCode())) {
				return toyList.get(i);
			}
		}
		return null;
	}

	/**
	 * code를 통해 장난감을 삭제한다. 코드가 일치하는 장난감을 찾으면 삭제한다. 
	 * @param code 삭제할 장난감 코드
	 * @return 삭제 여부
	 */
	public boolean delete(String code) {
		
		boolean result = false;
		Toy delete = search(code);
		
		if (delete != null) {
			result = true;
			toyList.remove(delete);
			saveFile();
		} 
		
		return result;
		
	}

	/**
	 * 장난감 리스트를 얻는다
	 * @return 장난감 리스트
	 */
	public ArrayList<Toy> getToyList() {
		loadFile();
		
		return toyList;
	}
	
}
