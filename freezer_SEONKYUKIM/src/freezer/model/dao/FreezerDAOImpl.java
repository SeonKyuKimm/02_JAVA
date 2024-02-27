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

import freezer.model.dto.Freezer;


public class FreezerDAOImpl implements FreezerDAO{

	
	private final String FILE_PATH ="/freezer/Freezer.dat";

	// 객체 입 출력 보조스트림
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	// 파일에 입 출력되는 리스트 변수
	private List<Freezer> freezerList = null;
	
	

	public FreezerDAOImpl() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		File file = new File(FILE_PATH);
		
		if ( file.exists() ) {
			
			try{
				
				ois = new ObjectInputStream( new FileInputStream(FILE_PATH) );
			
				freezerList = ( ArrayList<Freezer> )ois.readObject();
			
			}finally {
				
				if( ois != null) ois.close();
			}
			
			
		}else { //  파일 존재여부
			
			//폴더 파일 만들기
			File directory = new File("/freezer");
			if(!directory.exists() ) directory.mkdir();
			
			freezerList = new ArrayList<Freezer>();
			
			freezerList.add(new Freezer("맛있다", "우유", false, LocalDateTime.now() ) );
			freezerList.add(new Freezer("맛있다", "소고기", false, LocalDateTime.now() ) );
			freezerList.add(new Freezer("맛있다", "미역국", false, LocalDateTime.now() ) );
			
			try {
				oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH) );
				oos.writeObject(freezerList);
			}finally {
				
				if(oos != null)oos.close();
				
			}
		
			System.out.println("***** freezerList.dat 파일 생성 완료 *****");
		
		}
		
	}	
	
	
	
	@Override
	public List<Freezer> freezerListFullView(){
		
		return freezerList;
	}
	
	
	@Override
	public Freezer freezerDetailView(int index) {
		if(index < 0 || index >= freezerList.size() ) return null;
		
		return freezerList.get(index);
	}

	/* save file */
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
	public int freezerAdd(Freezer freezer) throws Exception {
				
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
		
		Freezer freezer = new Freezer(
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
	public Freezer freezerDelete(int index) throws Exception {

		if(index < 0 || index >= freezerList.size() ) return null;
		
		Freezer freezer = freezerList.remove(index);
		saveFile();
		
		return freezer;
	}


	

}
	

