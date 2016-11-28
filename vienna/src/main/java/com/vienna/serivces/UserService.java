package com.vienna.serivces;

import com.vienna.commons.ServiceException;
import com.vienna.domain.tables.pojos.TUser;
import com.vienna.domain.tables.records.TUserRecord;
import com.vienna.vos.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author tonyhui
 * @since 16/9/9
 */
@Service
public class UserService extends BaseViennaService {

    /**
     * @author ys
     * @createTime 2016年9月12日
     * @description:
     */
    public boolean saveOrUpdate(User user) {
        TUserRecord record = new TUserRecord();
        record.setId(user.getId());
        record.setName(user.getName());
        record.setPhone(user.getPhone());
        record.setEmail(user.getEmail());
        record.setPassword(user.getPassword());
        // TODO: 16/11/28 flyway中设置默认值
        record.setStatus(true);
        return dsl.insertInto(T_USER).set(record).onDuplicateKeyUpdate().set(record).execute() == 1;
    }

    /**
     * @author ys
     * @createTime 2016年9月12日
     * @description:
     */
    public void update(TUser t) {
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
    public List<TUser> queryPageAll(int start, int end) {
        return dsl.selectFrom(T_USER).orderBy(T_USER.UPDATED).limit(start, end).fetchInto(TUser.class);
    }

    /**
     * @author ys
     * @createTime 2016年9月12日
     * @description: 根据用户名 和密码 登录   true表示登录成功 false 失败
     */
    public Optional<TUser> login(String name, String pwd) {
        return dsl.selectFrom(T_USER).where(T_USER.NAME.eq(name)).and(T_USER.PASSWORD.eq(pwd)).fetchOptionalInto(TUser.class);
    }

    /**
     * @author ys
     * @createTime 2016年9月12日
     * @description: 根据id删除
     */
    public boolean delete(int id) {
        if (dsl.selectCount().from(T_USER).where(T_USER.ID.eq(id)).fetchOneInto(Integer.class) != 1)
            throw new ServiceException("要删除的用户不存在");

        return dsl.update(T_USER).set(T_USER.ID, id).execute() == 1;
    }


}
