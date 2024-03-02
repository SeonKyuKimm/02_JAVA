package CVSStoreService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dao.CVSStoreDAO;
import model.dao.CVSStoreDAOImpl;
import model.dto.CVSStore;

public class CVSStoreServiceImpl implements CVSStoreService{

	private CVSStoreDAO dao = null;

	public CVSStoreServiceImpl() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		dao = new CVSStoreDAOImpl();
	}

	@Override
	public Map<String, Object> cvsServiceFullView() {
		
		List<CVSStore> cvsServiceList = dao.cvsServiceFullView();
		
		int inAndOut = 0;
		
		for( CVSStore cvsService : cvsServiceList) {
			
			if( cvsService.isInAndOut() ) {
				inAndOut++;
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("todoList", cvsServiceList);
		map.put("inAndOut", inAndOut);
		return map;
		
	}

	@Override
	public String dateFormat(LocalDateTime regDate) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd MM:mm:ss");
		
		String formattedDateTime = regDate.format(formatter);		
		return formattedDateTime;
		
	}
	
	

}
