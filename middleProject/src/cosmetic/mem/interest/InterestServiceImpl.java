package cosmetic.mem.interest;

import java.util.List;

import cosmetic.vo.InterestedVO;
import cosmetic.vo.ProductVO;

public class InterestServiceImpl implements IInterestService{
	private IInterestDao dao;
	private static InterestServiceImpl service;
	
	private InterestServiceImpl() {
		dao = InterestDaoImpl.getInstance();
	}
	
	public static IInterestService getInstance() {
		if(service == null) service = new InterestServiceImpl();
		return service;
	}
	
	@Override
	public List<ProductVO> getInterstList(String memId) {
		return dao.getInterstList(memId);
	}

	@Override
	public int insertInterest(InterestedVO vo) {
		return dao.insertInterest(vo);
	}

	@Override
	public int deleteInterest(InterestedVO vo) {
		return dao.deleteInterest(vo);
	}

	@Override
	public void insertCart(InterestedVO vo) {
		dao.insertCart(vo);
	}

}
