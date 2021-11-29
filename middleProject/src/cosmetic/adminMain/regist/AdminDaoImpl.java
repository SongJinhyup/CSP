package cosmetic.adminMain.regist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import cosmetic.ibatis.SqlMapConfig;
import cosmetic.vo.AdminVO;
import cosmetic.vo.LprodVO;
import cosmetic.vo.MemberVO;
import cosmetic.vo.ProductVO;

public class AdminDaoImpl implements IAdminDao{
   private SqlMapClient smc;
   private static IAdminDao dao;

   private AdminDaoImpl() {
      smc = SqlMapConfig.getSqlMapClient();
   }
   
   public static IAdminDao getInstance() {
      if(dao==null) dao = new AdminDaoImpl();
      return dao;
   }
   
//회원
   @Override
   public List<MemberVO> selectMember(String mem_id) {
      List<MemberVO> memList = new ArrayList<>();
      
      try {
         memList = smc.queryForList("admin.selectMember", mem_id);
      } catch (SQLException e) {
         memList = null;
         e.printStackTrace();
      }
      return memList;
   }
   
   @Override
   public List<MemberVO> getAllMemberList() {
      List<MemberVO> memList = new ArrayList<>();
      
      try {
         memList = smc.queryForList("admin.getAllMember");
      }catch (SQLException e) {
         memList = null;
         e.printStackTrace();
      }
      return memList;
   }
   

   @Override
   public int deleteMember(String mem_id) {
      int cnt = 0;
      try {
         cnt = smc.delete("admin.deleteMember", mem_id);
      } catch (SQLException e) {
         cnt = 0;
         e.printStackTrace();
      }
      return cnt;
   }


   @Override
   public List<AdminVO> getAllBlackList() {
      List<AdminVO> memList = new ArrayList<>();
      
      try {
         memList = smc.queryForList("admin.getAllBlackList");
      }catch (SQLException e) {
         memList = null;
         e.printStackTrace();
      }
      return memList;
   }
   
   @Override
   public int updateBlackList(String mem_id) { 
      int cnt = 0;
      
      try {
         cnt = smc.update("admin.updateBlackList", mem_id);
      }catch (SQLException e) {
         cnt = 0;
         e.printStackTrace();
      }
      return cnt;
   }

   @Override
   public int deleteBlackList(String mem_id) {
      int cnt = 0;
      
      try {
//         cnt = smc.update("admin.updateBlackList", mem_id);
         cnt = smc.update("admin.deleteBlackList", mem_id);

      }catch(SQLException e){
         cnt = 0;
         e.printStackTrace();
      }
      return cnt;
   }

   
   
// 상품 재고    
   @Override
   public List<ProductVO> selectProdStock(String prod_id) {
      List<ProductVO> prodList = new ArrayList<>();
      
      try {
         prodList = smc.queryForList("prod.selectProdStock", prod_id);
      } catch (SQLException e) {
         prodList = null;
         e.printStackTrace();
      }
      return prodList;
   }
   
   @Override
   public List<ProductVO> getAllProdStock() {
      List<ProductVO> prodStockList = new ArrayList<>();
      
      try {
    	  prodStockList = smc.queryForList("prod.getAllProdStock");
      } catch (SQLException e) {
    	  prodStockList = null;
         e.printStackTrace();
      }
      return prodStockList;
   }
   
   @Override
   public int updateProdStock(ProductVO productVo) {
      int cnt = 0;
      
      try {
         cnt = smc.update("prod.updateProdStock", productVo);
      } catch (SQLException e) {
         cnt = 0;
         e.printStackTrace();
      }
      return cnt;
   }

   

// 상품 카테고리
   
   @Override
   public List<LprodVO> selectLprod(String lprod_id) {
      List<LprodVO> lprodList = new ArrayList<>();
      
      try {
         lprodList = smc.queryForList("lprod.selectLprod", lprod_id);
      } catch (SQLException e) {
         lprodList = null;
         e.printStackTrace();
      }
      return lprodList;
   }

   @Override
   public List<LprodVO> getAllLprodList() {
      List<LprodVO> lprodList = null;
      
      try {
         lprodList = smc.queryForList("lprod.getAllLprod");
      } catch (SQLException e) {
         lprodList = null;
         e.printStackTrace();
      }
      return lprodList;
   }


   @Override
   public int updateLprod(LprodVO lprodVo) {
      int cnt = 0;
      try {
         cnt = smc.update("lprod.updateLprod", lprodVo);
      }catch (SQLException e) {
         cnt = 0;
         e.printStackTrace();
      }
      return cnt;
   }

   @Override
   public int deleteLprod(String lprod_id) {
      int cnt = 0;
      
      try {
         cnt = smc.delete("lprod.deleteLprod", lprod_id);
      } catch (SQLException e) {
         cnt = 0;
         e.printStackTrace();
      }
      return 0;
   }

   @Override
   public int insertLprod(String lprod_type) {
      int cnt = 0;
      
      try {
    	  Object obj =  smc.insert("lprod.insertLprod", lprod_type);
    	  if(obj==null) cnt=1;
      } catch (SQLException e) {
         cnt = 0;
         e.printStackTrace();
      }
      return cnt;
   }



   // 상품 관리
   @Override
   public List<ProductVO> selectProd(String prod_id) {
      List<ProductVO> prodList = new ArrayList<>();
      
      try {
         prodList = smc.queryForList("lprod.selectProd", prod_id);
      } catch (SQLException e) {
         prodList = null;
         e.printStackTrace();
      }
      return prodList;
   }

   @Override
   public List<ProductVO> getAllProd() {
      List<ProductVO> list = null;
      
      try {
    	  list = smc.queryForList("prod.getAllProd");
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return list;
   }

   @Override
   public int updateProd(ProductVO prodVo) {
      int cnt = 0;
      
      try {
         cnt = smc.update("prod.updateProd" , prodVo);
      } catch (Exception e) {
         cnt = 0;
         e.printStackTrace();
      }
      return cnt;
   }

   @Override
   public int deleteProd(String prod_id) {
      int cnt = 0;
      
      try {
         cnt = smc.delete("prod.deleteProd", prod_id);
      } catch (SQLException e) {
         cnt = 0;
         e.printStackTrace();
      }
         
      return cnt;
   }


   @Override
   public int insertProd(ProductVO prodVo) {
      int cnt = 0;
      try {
         cnt = (int) smc.insert("prod.insertProd", prodVo);
      } catch (SQLException e) {
         cnt = 0;
         e.printStackTrace();
      }
         
      return cnt;
   }
   
	@Override
	public ProductVO getProd(String prodId) {
		ProductVO vo = null;
		try {
			vo = (ProductVO) smc.queryForObject("prod.getProd",prodId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<LprodVO> getLprod() {
		List<LprodVO> list = null;
		try {
			list = smc.queryForList("prod.getLprod");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}



}