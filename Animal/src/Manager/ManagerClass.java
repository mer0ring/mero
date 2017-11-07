package Manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import VO.InterfaceClass;
import VO.Pet;

public class ManagerClass implements InterfaceClass {
	
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	private static final String FILE_NAME = "animal.dat";
	private ArrayList<Pet> petList;
	
	public ManagerClass(){
		
		if (new File(FILE_NAME).exists()) {
			try {
				loadFile();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			petList = new ArrayList<>();
		}
				
	}

	@Override
	public boolean register(Pet pet) {
	
		if (search(pet.getName()) == null) {
			petList.add(pet);
			try {
				saveFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		
		return false;
	}

	@Override
	public Pet search(String name) {
	
		for (Pet pet : petList) {
			if (name.equals(pet.getName())) {
				return pet;
			}
		}
		return null;
	}

	@Override
	public boolean delete(String name) {
		
		Pet canDelete = search(name);
		if (canDelete == null) {
			return false;
		} else {
			petList.remove(canDelete);
			try {
				saveFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean modify(Pet pet) {
	
		for (int i = 0; i < petList.size(); i++) {
			if (pet.getName().equals(petList.get(i).getName())) {
				petList.set(i, pet);
				return true;
			}
		}
		return false;
	}

	@Override
	public void saveFile() throws IOException {
				
		fos = new FileOutputStream(FILE_NAME);
		oos = new ObjectOutputStream(fos);
		
		oos.writeObject(petList);
		oos.flush();
	}

	@Override
	public void loadFile() throws IOException, FileNotFoundException, ClassNotFoundException {
		
		fis = new FileInputStream(FILE_NAME);
		ois = new ObjectInputStream(fis);
		
		petList = (ArrayList<Pet>) ois.readObject();
		
	}

	@Override
	public ArrayList<Pet> allPrint() {
		
		return petList;
		
	}

	

	
}
