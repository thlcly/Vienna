package com.vienna.serivces;

import static com.vienna.domain.tables.TQuestion.T_QUESTION;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vienna.domain.tables.pojos.TQuestion;
import com.vienna.domain.tables.records.TQuestionRecord;

@Service
public class QuestionService extends BaseViennaService {
  
	/**
    * save or update
    */
	public int saveOrUpdate(TQuestion t){
	      TQuestionRecord record = new TQuestionRecord();
	      record.setQuestion(t.getQuestion());
	      record.setRefrerence(t.getRefrerence());
	      record.setSolved(t.getSolved());
	      record.setStatus(t.getStatus());
	      record.setTypeId(t.getTypeId());
	      record.setUserId(t.getUserId());
	      //sava  or update
	     return dsl.insertInto(T_QUESTION).set(record).onDuplicateKeyUpdate().set(record).execute();
	}
	
	/**
	 * @author ys
	 * @createTime 2016年9月12日
	 * @description: 根据id进行  跟新
	 */
	public void update(TQuestion t){
	      TQuestionRecord record = new TQuestionRecord();
	      record.setQuestion(t.getQuestion());
	      record.setRefrerence(t.getRefrerence());
	      record.setSolved(t.getSolved());
	      record.setStatus(t.getStatus());
	      record.setTypeId(t.getTypeId());
	      record.setUserId(t.getUserId());
		
		 dsl.update(T_QUESTION).set(record).where(T_QUESTION.ID.eq(t.getId())).execute();
	}
	/**
	 * @author ys
	 * @createTime 2016年9月12日
	 * @description: 根据user_Id 进行分页查询
	 */
	public List<TQuestion> queryPageByUserId(int start,int end,int userId){
		return dsl.selectFrom(T_QUESTION).orderBy(T_QUESTION.UPDATED).limit(start,end).fetchInto(TQuestion.class);
	}
	
	/**
	 * @author ys
	 * @createTime 2016年9月12日
	 * @description:根据id 删除
	 */
	public void delete(int id){
		dsl.delete(T_QUESTION).where(T_QUESTION.ID.eq(id)).execute();
	}
	
}
