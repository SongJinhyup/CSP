package cosmetic.nologin.enterlogin;

import java.util.Map;

import cosmetic.vo.MemberVO;

public interface IMemberLoginService {
	
	public MemberVO logInMember(MemberVO memVo);
	
	public String findId(Map<String, String> paramap);
	
	public String findPass(MemberVO membervo);
	
}
