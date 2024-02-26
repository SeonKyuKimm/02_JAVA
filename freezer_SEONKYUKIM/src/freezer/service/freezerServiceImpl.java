package freezer.service;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freezer.model.dao.freezerDAO;
import freezer.model.dao.freezerDAOImpl;
import freezer.model.dto.freezer;


public class freezerServiceImpl implements freezerService {

	
	private freezerDAO dao = null;
	
	public freezerServiceImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		dao = new freezerDAOImpl();
	}
	
	
	@Override
	public Map<String, Object> freezerFullView() {
		
		List<freezer> freezerList = dao.freezerListFullView();
		
		int completeCount = 0;
		
		for( freezer freezer : freezerList) {
			
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


	@Override
	public String dateFormat(LocalDateTime regDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd MM:mm:ss");
		// TODO Auto-generated method stub
		
		String formattedDateTime = regDate.format(formatter);
		
		return formattedDateTime;
	}


	@Override
	public String freezerDetailView(int index) {
		
		freezer freezer = dao.freezerDetailView(index);
		
		if (freezer ==null) return null;
		StringBuilder sb = new StringBuilder();
		
		sb.append("-------------------------------------------");
		sb.append( String.format("제목 : %s\n", freezer.getFood() ) );
		sb.append( String.format("등록일 : %s\n", dateFormat(freezer.getRegDate() ) ) );
		sb.append( String.format("완료여부 : \n", freezer.isInAndOut() ? "O" : "X" ) );
		sb.append("\n[ 세부 내용] \n");
		sb.append("-------------------------------------------");
		sb.append( String.format("%s\n", freezer.getKeep() ));
		
		return sb.toString();
		
	}

	@Override
	public int freezerAdd(String keep, String food) throws Exception{
		
		freezer freezer = new freezer(keep, food, alse, LocalDateTime.now() );
		
		
		int index = dao.freezerAdd(freezer);
		
		return index;
	}
	
	@Override
	public boolean freezerUpdate(int index, String keep, String food) throws Exception{
	
		return dao.freezerUpdate(index ,keep, food);
	
	}
	
	@Override
	public String freezerDelete(int index) throws Exception{
		
		freezer freezer = dao.freezerDelete(index);
		if( freezer == null) return null;
		
		return  freezer.getKeep();
		
	}


	
	
	

	
}
	
	
	
	

