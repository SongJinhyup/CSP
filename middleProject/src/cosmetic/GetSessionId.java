package cosmetic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetSessionId {
	private static HttpSession session;
	private static String memId;
	
	public static String getSessionId(HttpServletRequest request) {
		session = request.getSession();
		memId = (String) session.getAttribute("mem_id");
		return memId;
	}
}
