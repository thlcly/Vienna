package com.vienna.serivces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vienna.domain.tables.pojos.TUser;
import com.vienna.domain.tables.records.TUserRecord;

/**
 * @author tonyhui
 * @since 16/9/9
 */
@Service
public class UserService extends BaseViennaService{
	
	   /**
     * @author ys
     * @createTime 2016年9月12日
     * @description:
     */
	public int saveOrUpdate(TUser t){
		TUserRecord record = new TUserRecord();
		record.setId(t.getId());
		record.setName(t.getName());
		record.setPhone(t.getPhone());
		record.setEmail(t.getEmail());
		record.setPassword(t.getPassword());
		record.setStatus(t.getStatus());
		return dsl.insertInto(T_USER).set(record).onDuplicateKeyUpdate().set(record).execute();
	}
	
	/**
	 * @author ys
	 * @createTime 2016年9月12日
	 * @description: 
	 */
	public void update(TUser t){
		TUserRecord record = new TUserRecord();
		record.setId(t.getId());
		record.setName(t.getName());
		record.setPhone(t.getPhone());
		record.setEmail(t.getEmail());
		record.setPassword(t.getPassword());
		record.setStatus(t.getStatus());
		dsl.update(T_USER).set(record).where(T_USER.ID.eq(record.getId())).execute();
	}
	
     /**
      * @author ys
      * @createTime 2016年9月12日
      * @description:
      */
	public List<TUser> queryPageByUserId(int start,int end,int userId ){
		return dsl.selectFrom(T_USER).orderBy(T_USER.UPDATED).limit(start,end).fetchInto(TUser.class);
	}
	
	/**
	 * @author ys
	 * @createTime 2016年9月12日
	 * @description: 根据用户名 和密码 登录   true表示登录成功 false 失败
	 */
	public Boolean login(String name,String pwd){
		return dsl.select(T_USER.NAME).from(T_USER).where(T_USER.NAME.eq(name)).and(T_USER.PASSWORD.eq(pwd)).execute()>0?true:false;
	}
	
	/**
	 * @author ys
	 * @createTime 2016年9月12日
	 * @description: 根据id删除
	 */
   public void delete(int id){
	   dsl.deleteFrom(T_USER).where(T_USER.ID.eq(id)).execute();
   }


}
