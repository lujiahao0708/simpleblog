package com.lujiahao.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lujiahao
 * @date 2018-08-09 下午4:41
 */
@RestController
public class AppLiveController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppLiveController.class);

    @GetMapping(value = "liveTest")
    public void liveTest(HttpServletRequest request) {
        LOGGER.info("node alive ip:{}", request.getRemoteAddr());
    }
}
