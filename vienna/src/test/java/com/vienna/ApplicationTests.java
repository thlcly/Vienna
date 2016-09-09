package com.vienna;

import com.vienna.question.domain.tables.pojos.TUser;
import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static com.vienna.question.domain.tables.TUser.T_USER;

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
        List<TUser> users = dsl.selectFrom(T_USER).fetchInto(TUser.class);
        System.out.println(users);
    }
}
