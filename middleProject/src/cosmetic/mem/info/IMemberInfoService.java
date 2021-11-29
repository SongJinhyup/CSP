package cosmetic.mem.info;

import cosmetic.vo.MemberVO;

/**
 * ȸ�������� �����ϴ� ServiceŬ����
 * @author User
 *
 */
public interface IMemberInfoService {
	
	/**
	 * ������ ȸ�� �� ������ ��ȸ�ϴ� �޼ҵ�
	 * @param memId �α����� �� ���� ȸ�� ���̵��� ������ �޾ƿ� parameter�� �Է� �޴´�.
	 * @return ������ �������� vo��ü�� ��ȯ�޴´�.
	 */
	public MemberVO getInfo(String memId);
	
	/**
	 * ȸ���� �� ������ �����ϴ� �޼ҵ�
	 * @param vo �̸���, ��ȭ��ȣ, ��������� VO�� ���� �Է� �޴´�.
	 * @return ������ 1, ���н� 0�� ��ȯ
	 */
	public int infoUpdate(MemberVO vo);
	
	
	/**
	 * ȸ�� ��й�ȣ�� �����ϴ� �ޙ�
	 * @param mem_pass �����Ϸ��� ��й�ȣ�� �Է¹޴´�.
	 * @return ������ 1, ���н� 0�� ��ȯ
	 */
	public int passUpdate(MemberVO vo);
	
	/**
	 * ȸ��Ż�� �����ϴ� �޼ҵ�
	 * @param memId ȸ��Ż���Ϸ��� ȸ���� ���̵�
	 * @return ������ 1, ���н� 0�� ��ȯ
	 */
	public int deleteAccount(String memId);
}
