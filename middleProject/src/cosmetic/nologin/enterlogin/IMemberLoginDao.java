package cosmetic.nologin.enterlogin;

import java.util.Map;

import cosmetic.vo.MemberVO;

public interface IMemberLoginDao {
	
	
	/**?
	 * 회원 아이디와 패스워드로 로그인한다.
	 * @param memvo
	 * @return 
	 */
	public MemberVO logInMember(MemberVO memVo);
	
	/**?
	 * mem_name과 mem_tel을 입력받아서 id를 찾는 메서드
	 * @param paramap
	 * @return 
	 */
	public String findId(Map<String ,String> paramap);


	/**?
	 * mem_id,mem_tel,mem_name을 입력받아서 password를 찾는 메서드
	 * @param membervo
	 * @return 
	 */
	public String findPass(MemberVO membervo);

}
