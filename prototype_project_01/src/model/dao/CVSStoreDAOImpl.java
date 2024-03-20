package model.dao;

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

import model.dto.CVSStore;

public class CVSStoreDAOImpl implements CVSStoreDAO {

	// field
	private final String FILE_PATH = "/CVS/CVSStore.dat";
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	private List<CVSStore> cvsStore = null;
	
	
	public CVSStoreDAOImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		
		//  객체 생성, 파일내용 읽어오기
		// 읽어오기 전에 검사부터
		File file = new File(FILE_PATH);
		
		if( file.exists() ) { // 파일이 있다면
			
			try {
				
				ois = new ObjectInputStream( new FileInputStream(FILE_PATH));
				
				cvsStore = ( ArrayList<CVSStore>)ois.readObject() ;
			} finally {
				if(ois != null) ois.close();
			}
						
			
		}else { //  파일이 존재하지 않으면 파일 폴더 만드는 경우
			
			File directory = new File("/CVS");
			
			if (!directory.exists()) directory.mkdir();
			
			cvsStore = new ArrayList<CVSStore>();
			
			cvsStore.add(new CVSStore( "콜라", "달고 맛나다", false, LocalDateTime.now() ) );
			cvsStore.add(new CVSStore( "샌드위치", "싸구려같지만 맛나나?", false, LocalDateTime.now() ) );
			cvsStore.add(new CVSStore( "추파춥스", "이가 상할수도 있지만 맛나다", false, LocalDateTime.now() ) );
			cvsStore.add(new CVSStore( "저가형충전기", "6개월은 쓸 수 있을까", false, LocalDateTime.now() ) );
		
			try { 
				
				oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH) );
			
				oos.writeObject( cvsStore );
			}finally {
				
				if(oos != null) oos.close();
				
			}
		
			System.out.println(" *** CVSstore 파일 생성 ***");
		}
		
		// 기본생성자 ~
	}

	@Override
	public List<CVSStore> cvsServiceFullView() {
		// TODO Auto-generated method stub
		return cvsStore;
	}

	
	//------------------------------
	@Override
	public void saveFile() throws Exception {

		try {
			
		oos = new ObjectOutputStream( new FileOutputStream(FILE_PATH));
		oos.writeObject(cvsStore);
		
		}finally {
			
			oos.close();
		}
	}

	//-----------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
