package com.springboot.start;

import com.springboot.start.bean.User;
import com.springboot.start.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

/**
 * @Author liuxian
 * @Date 2018/6/6
 * @Desc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringRunner.class})
public class TestUser {

    @Mock
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void setUp() {
        User mockUser = new User();
        mockUser.setNickName("john");
        mockUser.setId(1L);
        mockUser.setGender("1");
        when(userService.findOne(1L)).thenReturn(mockUser);
    }

    @Test
    public void findOneTest() {
//        User user = userService.findOne(1L);
//        logger.info("user.name = {}", user.getNickName());
//        Assert.assertEquals(user.getNickName(), "john");
    }
}
