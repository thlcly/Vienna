package com.vienna.serivces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vienna.domain.tables.pojos.TType;
import com.vienna.domain.tables.records.TTypeRecord;

@Service
public class TypeService extends BaseViennaService {
    /**
     * @author ys
     * @createTime 2016年9月12日
     * @description:
     */
	public int saveOrUpdate(TType t){
		TTypeRecord record = new TTypeRecord();
		record.setId(t.getId());
		record.setName(t.getName());
		record.setNumber(t.getNumber());
		record.setStatus(t.getStatus());
		record.setDescriptions(t.getDescriptions());
		return dsl.insertInto(T_TYPE).set(record).onDuplicateKeyUpdate().set(record).execute();
	}
	
	/**
	 * @author ys
	 * @createTime 2016年9月12日
	 * @description: 
	 */
	public void update(TType t){
		TTypeRecord record = new TTypeRecord();
		record.setId(t.getId());
		record.setName(t.getName());
		record.setNumber(t.getNumber());
		record.setStatus(t.getStatus());
		record.setDescriptions(t.getDescriptions());
		dsl.update(T_TYPE).set(record).where(T_TYPE.ID.eq(record.getId())).execute();
	}
	
     /**
      * @author ys
      * @createTime 2016年9月12日
      * @description:
      */
	public List<TType> queryPageByUserId(int start,int end,int userId ){
		return dsl.selectFrom(T_TYPE).orderBy(T_TYPE.UPDATED).limit(start,end).fetchInto(TType.class);
	}
	
	/**
	 * @author ys
	 * @createTime 2016年9月12日
	 * @description: 根据id删除
	 */
   public void delete(int id){
	   dsl.deleteFrom(T_TYPE).where(T_TYPE.ID.eq(id)).execute();
   }
	
}
