package com.vienna;

import static com.vienna.domain.tables.TUser.T_USER;
import static com.vienna.domain.tables.TQuestion.T_QUESTION;
import static com.vienna.domain.tables.TType.T_TYPE;


import java.util.List;
import java.util.Map;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Result;
import org.jooq.SelectConditionStep;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.vienna.domain.tables.pojos.TQuestion;
import com.vienna.domain.tables.records.TQuestionRecord;;

/**
 * @author tonyhui
 * @since 16/9/9
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {
    @Autowired
    private DSLContext dsl;

    @Test
    public void contextLoads() {
        List<String> users = dsl.selectFrom(T_USER).fetch(T_USER.NAME);
        System.out.println(users);
    }
    @Test
    public void delete(){
    	int a=1;
    	dsl.deleteFrom(T_USER).where(T_USER.ID.eq(a)).execute();
    }
    
    /**
     * test  add questions表
     * 
     */
    @Test
    public  void  add(){
      TQuestion q = new 	TQuestion();
      q.setQuestion("问题");
      q.setRefrerence("java 相关资料");
      q.setSolved("解决思路");
      q.setStatus(true);
      q.setTypeId(1);
      q.setUserId(1);
      
      TQuestionRecord record = new TQuestionRecord();
      record.setId(1);
      record.setQuestion("问题");
      record.setRefrerence("java 相关资料....");
      record.setSolved("解决思路......");
      record.setStatus(true);
      record.setTypeId(1);
      record.setUserId(1);
      //sava  or update
      int i = dsl.insertInto(T_QUESTION).set(record).onDuplicateKeyUpdate().set(record).execute();
      System.out.println(i);
    	
    }
    
    @Test
    public void pageQueryListByUserId(){
    	int start=0;
    	int end =1;
    	int userId =1;
    	List<TQuestion> list1 = dsl.selectFrom(T_QUESTION).orderBy(T_QUESTION.UPDATED).limit(start,end).fetchInto(TQuestion.class);
    	SelectConditionStep<Record2<String, String>> re = dsl.select(T_TYPE.NAME,T_QUESTION.QUESTION).from(T_TYPE).join(T_QUESTION).on(T_TYPE.ID.eq(T_QUESTION.TYPE_ID)).where(T_QUESTION.USER_ID.eq(userId));
        Result<Record2<String, String>> result = re.fetch();
    	List<Map<String, Object>> list = result.intoMaps();
    	if(list!=null){
        	for (int i = 0; i < list.size(); i++) {
        		System.out.println(list.get(i).get("NAME"));
        	}

    	}
 
    }
    
    @Test
    public void update(){
        TQuestionRecord record = new TQuestionRecord();
        record.setId(1);
        record.setQuestion("问题");
        record.setRefrerence("java 相关资料....2222");
        record.setSolved("解决思路......2222");
        record.setStatus(true);
        record.setTypeId(1);
        record.setUserId(1);
        System.out.println("测试前");
    	int i = dsl.update(T_QUESTION).set(record).where(T_QUESTION.ID.eq(1)).execute();
    	System.out.println(i+"测试后");
    }
    
    @Test
    public void delete1(){
    	int i = dsl.delete(T_QUESTION).where(T_QUESTION.ID.eq(2)).execute();
    	System.out.println("删除"+i);
    }
    
    
    
}
