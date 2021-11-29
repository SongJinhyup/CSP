package cosmetic.mem.info;

import cosmetic.vo.MemberVO;

public class MemberInfoServiceImpl implements IMemberInfoService {
	private static IMemberInfoService service;
	private IMemberInfoDao dao;
	
	private MemberInfoServiceImpl() {	
		dao = MemberInfoDaoImpl.getInstance();
	}
	
public static IMemberInfoService getInstance() {
	if(service == null) service = new MemberInfoServiceImpl();
	return service;
}

@Override
public int infoUpdate(MemberVO vo) {
	return dao.infoUpdate(vo);
}

@Override
public int passUpdate(MemberVO vo) {
	return dao.passUpdate(vo);

}

@Override
public int deleteAccount(String memId) {
	return dao.deleteAccount(memId);
}

@Override
public MemberVO getInfo(String memId) {
	return dao.getInfo(memId);
}


}
