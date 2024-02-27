                             package freezer.model.dao;

import java.util.List;

import freezer.model.dto.Freezer;

 


 // service 에게 전달

public interface FreezerDAO {

	
	void saveFile() throws Exception;
	
	List<Freezer> freezerListFullView();

	
	
	Freezer freezerDetailView(int index);

	int freezerAdd(Freezer freezer) throws Exception;

	boolean freezerComplete(int index, String keep, String food) throws Exception;
		
	boolean freezerUpdate(int index, String keep, String food) throws Exception;

	Freezer freezerDelete(int index) throws Exception;


	

	
	
	
	
	
}
