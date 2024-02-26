package freezer.model.dao;

import java.util.List;

import freezer.model.dto.freezer;

 


 // service 에게 전달

public interface freezerDAO {

	
	void saveFile() throws Exception;
	
	List<freezer> freezerListFullView();

	
	
	freezer freezerDetailView(int index);

	int freezerAdd(freezer freezer) throws Exception;

	boolean freezerComplete(int index, String keep, String food) throws Exception;
		
	boolean freezerUpdate(int index, String keep, String food) throws Exception;

	freezer freezerDelete(int index) throws Exception;

	

	
	
	
	
	
}
