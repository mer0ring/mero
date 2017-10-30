package gov.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import gov.vo.FireStation;
import gov.vo.GovernmentOffice;
import gov.vo.PoliceOffice;

public class Manager {
	private final String FILE_NAME = "gov.dat";
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	private ArrayList<GovernmentOffice> officeList;	// 관공서 리스트
	
	/**
	 * Constructor
	 */
	public Manager() {
		if(new File(FILE_NAME).exists()){
			loadFile();
		} else {
			officeList = new ArrayList<GovernmentOffice>();
		}
	}
	
	/**
	 * gov.dat를 저장한다
	 */
	public void saveFile() {
		
		try {
			fos = new FileOutputStream(FILE_NAME);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(officeList);
			oos.flush();
			
		} catch (IOException e){
			e.printStackTrace();
			
		} finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * gov.dat를 불러온다
	 */
	public void loadFile() {
		
		try {
			fis = new FileInputStream(FILE_NAME);
			ois = new ObjectInputStream(fis);
			
			officeList = (ArrayList<GovernmentOffice>) ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				fis.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 관공서 정보를 저장한다. 관공서는 관리 번호에 의해 분류되고 중복될 수 없다.
	 * @param office 저장할 관공서 정보
	 * @return 저장 여부
	 */
	public boolean insert(GovernmentOffice office) {
		
		boolean canInsert = true;
				
		if (search(office.getOfficeId()) != null) {
			canInsert = false;
			
		} else {
			officeList.add(office);
			saveFile();
			
		}
		
		return canInsert;
	}

	/**
	 * 관리 번호를 통해 관공서 정보를 찾는다.
	 * @param officeId 검색할 관공서의 관리 번호
	 * @return 일치하는 관공서 정보
	 */
	public GovernmentOffice search(String officeId) {
		
		for (int i = 0; i < officeList.size(); i++) {
			if (officeId.equals(officeList.get(i).getOfficeId())) {
				return officeList.get(i);
			}
		}
		
		return null;
	}

	/**
	 * 관리 번호를 통해 관공서 정보를 삭제한다.
	 * @param officeId 삭제할 관공서의 관리 번호
	 * @return 삭제 여부
	 */
	public boolean delete(String officeId) {
		
		boolean canDelete = false;
		GovernmentOffice find = search(officeId);
		
		if (find != null) {
			canDelete = true;
			officeList.remove(find);
			saveFile();
		}
		
		return canDelete;
	}

	/**
	 * 관공서 리스트를 얻는다
	 * @return
	 */
	public ArrayList<GovernmentOffice> getOfficeList() {
		return officeList;
	}

	/**
	 * 경찰서의 갯수를 얻는다
	 * @return 경찰서의 갯수
	 */
	public int getPoliceOfficeCount() {
		
		int count = 0;
		
		for (int i = 0; i < officeList.size(); i++) {
			GovernmentOffice gov = officeList.get(i);
			if (gov instanceof PoliceOffice) {
				count++;
			}		
			
		}
		return count;
	}

	/**
	 * 소방서의 갯수를 얻는다
	 * @return 소방서의 갯수
	 */
	
	public int getFireStationCount() {
		
		int count = 0;
		GovernmentOffice gov;
		
		for (int i = 0; i < officeList.size(); i++) {
			gov = officeList.get(i);
			if (gov instanceof FireStation) {
				count++;
			}
		}
		
		return count;
	}

	/**
	 * 전체 관공서의 종사자 수를 얻는다
	 * @return 전체 관공서의 종사자 수
	 */
	public int getEmployeeCount() {
		
		int sum = 0;
		
		for (int i = 0; i < officeList.size(); i++) {
			GovernmentOffice gov = officeList.get(i);
			int count = gov.getEmployeeCount();
			sum += count;
		}
		
		return sum;
	}
}
