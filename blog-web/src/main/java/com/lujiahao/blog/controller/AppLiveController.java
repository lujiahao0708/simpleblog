package com.lujiahao.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.lujiahao.blog.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author lujiahao
 * @date 2018-08-09 下午4:41
 */
@RestController
public class AppLiveController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppLiveController.class);

    private Point point = new Point();

    private LoadingCache<String, String> cache;

    String POINT = "point";

    @PostConstruct
    public void init() {
        point.setStep(-1);
        point.setXPoint(-1);
        point.setYPoint(-1);
        point.setContent("");

        /**
         * 5秒自动过期
         */
        cache = CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
            public String load(String id) throws Exception {
                //LOGGER.info("触发过期策略,清空内容,时间:{},原有内容:{}", new Date(), cache.get(POINT));
                //这里执行查询数据库，等其他复杂的逻辑
                point.setStep(-1);
                point.setXPoint(-1);
                point.setYPoint(-1);
                point.setContent("");
                return JSON.toJSONString(point);
            }
        });
    }

    @GetMapping(value = "liveTest")
    public void liveTest(HttpServletRequest request) {
        LOGGER.info("node alive ip:{}", request.getRemoteAddr());
    }


    @GetMapping(value = "getPoint")
    public Point getPoint() {
        String pointStr = cache.getUnchecked(POINT);
        JSONObject jsonObject = JSONObject.parseObject(pointStr);
        Integer step = jsonObject.getInteger("step");
        Integer xPoint = jsonObject.getInteger("xPoint");
        Integer yPoint = jsonObject.getInteger("yPoint");
        String content = jsonObject.getString("content");
        point.setStep(step);
        point.setXPoint(xPoint);
        point.setYPoint(yPoint);
        point.setContent(content);
        return this.point;
    }

    @PostMapping(value = "setPoint")
    public Point setPoint(Integer step, Integer xPoint, Integer yPoint, String content) throws Exception{
        point.setStep(step);
        point.setXPoint(xPoint);
        point.setYPoint(yPoint);
        point.setContent(content);
        String pointStr =  JSON.toJSONString(point);
        cache.put(POINT, pointStr);
        return point;
    }

    @GetMapping(value = "confirm")
    public void confirm() {
        cache.invalidateAll();
        point.setStep(-1);
        point.setXPoint(-1);
        point.setYPoint(-1);
        point.setContent("");
        String pointStr =  JSON.toJSONString(point);
        cache.put(POINT, pointStr);
    }
}
