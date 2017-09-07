package org.lyh.dblog.ds.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lvyahui (lvyahui8@gmail.com,lvyahui8@126.com)
 * @since 2017/9/7 19:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    public static Logger logger = LoggerFactory.getLogger(PostServiceTest.class);

    @Autowired
    private PostService postService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSelect() throws Exception {

    }

    @Test
    public void testFind() throws Exception {
        System.out.println(postService.find(1));
    }
}