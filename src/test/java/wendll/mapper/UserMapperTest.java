package wendll.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import wendll.enums.UserSexEnum;
import wendll.model.User;

import java.util.List;

@RunWith(value = SpringRunner.class)
@SpringBootTest
@Transactional
public class UserMapperTest {

    @Autowired
    private UserMapper UserMapper;

    @Test
    public void testInsert() throws Exception {
        int usersize = UserMapper.getAll().size();
        UserMapper.insert(new User("aa", "a123456", UserSexEnum.MAN));
        UserMapper.insert(new User("bb", "b123456", UserSexEnum.WOMAN));
        UserMapper.insert(new User("cc", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3+usersize, UserMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<User> users = UserMapper.getAll();
        System.out.println(users.toString());
    }

    @Test
    public void testUpdate() throws Exception {
        User user = UserMapper.getOne(3L);
        System.out.println(user.toString());
        user.setNickName("neo");
        UserMapper.update(user);
        Assert.assertTrue(("neo".equals(UserMapper.getOne(3L).getNickName())));
    }
}