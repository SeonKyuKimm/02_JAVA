package freezer.service;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freezer.model.dao.FreezerDAO;
import freezer.model.dao.FreezerDAOImpl;
import freezer.model.dto.Freezer;



public class FreezerServiceImpl implements FreezerService {

	
	private FreezerDAO dao = null;
	
	public FreezerServiceImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		dao = new FreezerDAOImpl();
	}
	
	
	@Override
	public Map<String, Object> freezerFullView() {
		
		List<Freezer> freezerList = dao.freezerListFullView();
		
		int completeCount = 0;
		
		for( Freezer freezer : freezerList) {
			
			if( freezer.isInAndOut() ) {
				completeCount++;
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("freezerList", freezerList);
		map.put("completeCount", completeCount);
		
		
		return map;
	}
	
	

	/*
	@Override
	public String dateFormat(LocalDateTime regDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd MM:mm:ss");
		
		String formattedDateTime = regDate.format(formatter);
		return formattedDateTime;
		
	}*/

	/* 상세조회*/

	@Override
	public String dateFormat(LocalDateTime regDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd MM:mm:ss");
		// TODO Auto-generated method stub
		
		String formattedDateTime = regDate.format(formatter);
		
		return formattedDateTime;
	}

	
	@Override
	public String freezerDetailView(int index) {
		
		Freezer freezer = dao.freezerDetailView(index);
		
		if (freezer ==null) return null;
		StringBuilder sb = new StringBuilder();
		
		sb.append("----------------------------------------------------------\n");
		sb.append( String.format("Q : 맛있나요? 먹을거예요? A : %s\n", freezer.getFood() ) );
		sb.append( String.format("입고일 : %s\n", dateFormat(freezer.getRegDate() ) ) );
		sb.append( String.format("들어있어요? : \n", freezer.isInAndOut() ? "O" : "X" ) );
		sb.append("\n[ 이것은 바로?!] \n");
		sb.append("----------------------------------------------------------\n");
		sb.append( String.format("%s\n", freezer.getKeep() ));
		
		return sb.toString();
		
	}
	
	
	/* 메뉴 추가*/
	@Override
	public int freezerAdd(String keep, String food) throws Exception{
		
		Freezer freezer = new Freezer(keep, food, false, LocalDateTime.now() );
		
		
		int index = dao.freezerAdd(freezer);
		
		return index;
	}
	
	/* 업데이트 */
	@Override
	public boolean freezerUpdate(int index, String keep, String food) throws Exception{
	
		return dao.freezerUpdate(index ,keep, food);
	
	}
	
	@Override
	public String freezerDelete(int index) throws Exception{
		
		Freezer freezer = dao.freezerDelete(index);
		if( freezer == null) return null;
		
		return  freezer.getKeep();
		
	}


	@Override
	public boolean freezerComplete(int index) throws Exception {
		
		return dao.freezerComplete(index, null, null);
	}


	
	
	

	
}
	
	
	
	

