package com.lujiahao.blog;

import com.lujiahao.blog.service.RedisService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lujiahao
 * @date 2018-09-07 下午3:39
 */
public class PfTest extends BaseTestCase{
    @Autowired
    private RedisService redisService;

    @Test
    public void addData() {
        for (int i = 0; i < 1000; i++) {
            redisService.pfadd("codehole", "user" + i);
            long total = redisService.pfcount("codehole");
            if (total != i + 1) {
                System.out.printf("%d %d\n", total, i + 1);
                break;
            }
        }
    }
}
