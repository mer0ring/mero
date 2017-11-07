package VO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface InterfaceClass {
	public boolean register(Pet pet);
	public Pet search(String name);
	public boolean delete(String name);
	public boolean modify(Pet pet);
	public void saveFile() throws IOException;
	public void loadFile() throws IOException,FileNotFoundException,ClassNotFoundException;
	public ArrayList<Pet> allPrint();
}
