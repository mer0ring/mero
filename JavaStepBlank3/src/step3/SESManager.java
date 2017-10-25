package step3;
import java.io.*;
import java.util.*;

/**
 * <pre>
 * SES(Soft Engineer School) ���� ���α׷��� ���������� �����ϴ� Ŭ����
 * �ֿ� ������δ� ������ ����.
 * 1. �ű� �����ο� ���
 * 2. ����ο� �˻�
 * 3. ����ο� ����
 * 4. ��ü ����ο� ���
 * </pre>
 * */
public class SESManager {
	private final String FILE_NAME = "human.dat";	// ���ϸ� ���
	private ArrayList<Human> list;	// Human ��ü�� ���� ����Ʈ
	
	private FileInputStream fis;	//������ �б����� ��Ʈ��
	private FileOutputStream fos;	//������ �������� ��Ʈ��
	private ObjectInputStream ois;	//��ü�� �б����� ��Ʈ��
	private ObjectOutputStream oos;	//��ü�� �������� ��Ʈ��
	
	/**
	 * ������
	 */
	public SESManager(){
		
		File f = new File(FILE_NAME);
		
		if (f.exists()) {
			getFile();
		} else {
			list = new ArrayList<Human>();
		}
		// ������ �����ϸ� �о���δ�. ������ ArrayList�� �����Ѵ�.
	}
	
	/**
	 * ���ο� Human ��ü�� ����Ѵ�.
	 * @param human ����� Professor, Trainee, Staff Ŭ������ ��ü
	 * @return ���� ����
	 * */
	public boolean insertHuman(Human human) {
		// ���޵� ��ü�� �ֹε�Ϲ�ȣ�� �˻��Ѵ�.
		Human find_h = findHuman(human.getJumin());
		
		if (find_h != null) {
			return false;
		} else {
			list.add(human);
			setFile();
		}
		
		return true;
		
		// ��ϵ� �ֹι�ȣ���� üũ�Ѵ�. �̹� �ִ� �ֹε�Ϲ�ȣ�� ���� false�� �����Ѵ�.
		
		//����Ʈ�� ���ο� Human ��ü�� �߰��Ѵ�.
		//���Ͽ� ���� ����Ʈ�� �����
		//true�� �����Ѵ�.
	}

	/**
	 * ��ϵ� Human ��ü�� �˻��Ѵ�.
	 * @param jumin �˻��� Human�� �ֹι�ȣ
	 * @return Human �迭�� ��ϵ� ��ü�� �� �Ķ���ͷ� ���޵� �ֹι�ȣ�� ��ġ�Ǵ� Human ��ü, �˻� ����� ���� �� null�� ��ȯ�Ѵ�.
	 * */
	public Human findHuman(String jumin) {
		//���޵� �ֹι�ȣ�� ����Ʈ���� �˻��Ͽ� ������ �ش� ��ü�� �����Ѵ�.
		//������ null�� �����Ѵ�.
		
		for (int i = 0; i < list.size(); i++) {
			if (jumin.equals(list.get(i).getJumin())) {
				return list.get(i);
			}
		}
		
		return null;
		
	}

	/**
	 * ��ϵ� Human ��ü�� �����Ѵ�.
	 * @param jumin ������ Human�� �ֹι�ȣ
	 * @return �־��� �ֹι�ȣ�� ��ġ�Ǵ� Human ��ü�� ���� ���, Human �迭�� ��ϵ� ��ü�� �� �Ķ���ͷ� ���޵� �ֹι�ȣ�� ��ġ�Ǵ� Human ��ü�� �߰ߵǾ� ������ �����ϸ� true�� �׷��� ������ false�� ��ȯ
	 * */
	public boolean deleteHuman(String jumin){
		//���޵� �ֹι�ȣ�� ã�� �ش� ��ü�� �����Ѵ�.
		//���� ���� ���θ� �����Ѵ�.
		
		Human find_h = findHuman(jumin);
		
		if (find_h == null) {
			System.out.println("������ ��Ƽ� �����ϴ�.");
			return false;
		} else {
			list.remove(find_h);
			setFile();
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		}
		return true;
		
	}

	/**
	 * ��ϵ� ��� Human ��ü ������ ����Ѵ�.
	 * */
	public void showAll() {
		//����Ʈ�� ��� ��ü ���
		
		if (list.size() == 0) {
			System.out.println("����� ���� �������� �ʽ��ϴ�.");
		} else {
			for (Human human : list) {
				if (human != null) {
					System.out.println(human);
				} 
			}
		}
	}
	
	/**
	 * ����Ʈ�� ��ϵ� ��� Human ��ü ������ ���Ͽ� ����.
	 * @return ���� ���� ���� ����
	 * */
	public boolean setFile(){
		
		boolean result = true;
		
		try {
			
			fos = new FileOutputStream(FILE_NAME);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(list);
			oos.flush();
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		} finally {
			closeStreams();
		}
		
		return result;
		
	}
	
	/**
	 * ���Ͽ� ������ ��� Human ��ü ������ ArrayList�� �о���δ�.
	 * */
	public void getFile() {
		
		try {
			
			fis = new FileInputStream(FILE_NAME);
			ois = new ObjectInputStream(fis);
			
			list = (ArrayList<Human>) ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			closeStreams();
		}
	}
	
	/**
	 * ��Ʈ�� ��ü�� ��� close �Ͽ� �ڿ��� ��ȯ�Ѵ�.
	 * */
	private void closeStreams() {
		
		if (ois != null) {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (oos != null) {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
