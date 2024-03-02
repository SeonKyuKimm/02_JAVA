package CVSStoreService;

import java.time.LocalDateTime;
import java.util.Map;

public interface CVSStoreService {

	Map<String, Object> cvsServiceFullView();

	public abstract String dateFormat(LocalDateTime regDate);

}
