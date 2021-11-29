package cosmetic.nologin.signin;

import cosmetic.vo.MemberVO;

public interface ISignInDao {
	
	/**?
	 * 	MemberVO에 넣어진 데이터를 DB에 저장하는 메서드
	 * @param memVo DB에 삽입할 자료가 저장될 MemberVO객체
	 * @return 작업 성공 : 1이상, 작업실패 : 0
	 */
	public int insertMeber(MemberVO memVo);
	
	/**?
	 * memId을 받아서 회원의 존재 여부를 검사하는 메서드
	 * @param mem_id
	 * @return 검색된 회원 이메일의 개수 
	 */
	public int countMemeber(String mem_id);
}
