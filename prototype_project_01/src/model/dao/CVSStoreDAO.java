package model.dao;

import java.util.List;

import model.dto.CVSStore;

public interface CVSStoreDAO {

	void saveFile() throws Exception;
	
	
	/** 편의점 물건 반환 DAO
	 * @return
	 */
	List<CVSStore> cvsServiceFullView();

}
