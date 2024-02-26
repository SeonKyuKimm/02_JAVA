package freezer.service;

import java.time.LocalDateTime;
import java.util.Map;



public interface freezerService  {

	
	Map<String, Object> freezerFullView() throws NullPointerException;
	
	
	
	public abstract String dateFormat( LocalDateTime regDate);



	public abstract String freezerDetailView(int index);



	public abstract int freezerAdd(String keep, String string) throws Exception;



	public abstract boolean freezerComplete(int index) throws Exception;



	public abstract boolean freezerUpdate(int index, String keep, String string)throws Exception;



	public abstract String freezerDelete(int index)throws Exception;



	

	
	

	



	
	
	
	
}
