package freezer.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import freezer.model.dto.freezer;

public class freezerDAOImpl implements freezerDAO{

	
	private final String FILE_PATH ="/freezer/Freezer.dat";

	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	private List<freezer> freezerList = null;
	
	public freezerDAOImpl() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		File file = new File(FILE_PATH);
		
		if ( file.exists() ) {
			
			try{
				
				ois = new ObjectInputStream( new FileInputStream(FILE_PATH) );
			
				freezerList = ( ArrayList<freezer> )ois.readObject();
			
			}finally {
				
				if( ois != null) ois.close();
			}
			
			
		}else { //  파일 존재여부
			
			//폴더 파일 만들기
			File directory = new File("/freezer");
			if(!directory.exists() ) directory.mkdir();
			
			freezerList = new ArrayList<freezer>();
			
			freezerList.add(new freezer("우유", "맛있다", false, LocalDateTime.now() ) );
			freezerList.add(new freezer("소고기", "맛있다", false, LocalDateTime.now() ) );
			freezerList.add(new freezer("미역국", "끓인다", false, LocalDateTime.now() ) );
			
			try {
				oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH) );
				
				
			}finally {
				
				if(oos != null)oos.close();
				
			}
		
			System.out.println("***** freezerList.dat 파일 생성 완료 *****");
		
		}
		
	}	
	
	
	
	@Override
	public List<freezer> freezerListFullView() {
		
		return freezerList;
	}
	
	
	@Override
	public freezer freezerDetailView(int index) {
		if(index <0 || index >= freezerList.size() ) return null;
		
		return freezerList.get(index);
	}

	
	@Override
	public void saveFile() throws Exception {
		
		try {
			
			oos = new ObjectOutputStream (new FileOutputStream(FILE_PATH) );
			oos.writeObject(freezerList);
		
		}finally {
			oos.close();
		}
	}

	@Override
	public int freezerAdd(freezer freezer) throws Exception {
				
		if( freezerList.add(freezer) ) {
			
			saveFile();
			
			return freezerList.size() -1;
		}
		return -1;
	}
	
	@Override
	public boolean freezerComplete(int index, String keep, String food) throws Exception {
		if (index < 0 || index >= freezerList.size() ) return false;
	
		boolean complete = freezerList.get(index).isInAndOut();
		freezerList.get(index).setInAndOut(!complete);
		
		saveFile();
		
		return true;
	}
	
	@Override
	public boolean freezerUpdate(int index, String keep, String food) throws Exception {
		
		freezer freezer = new freezer(
									  keep,
									  food,
									  freezerList.get(index).isInAndOut(), 
									  freezerList.get(index).getRegDate() );
		
		if( freezerList.set(index, freezer) != null ) {
			
			
			saveFile();
			
			return true;
		}
			return false;	
	}
		
	@Override
	public freezer freezerDelete(int index) throws Exception {

		if(index < 0 || index >= freezerList.size() ) return null;
		
		freezer freezer = freezerList.remove(index);
		saveFile();
		
		return freezer;
	}
	
	

}
	

