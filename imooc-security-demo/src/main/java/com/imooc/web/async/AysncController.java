package com.imooc.web.async;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 何国锋
 * @date 2019-12-24 21:37
 */
@RestController
public class AysncController {


    static Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    @RequestMapping("/order")
    public String order() throws InterruptedException {
        logger.info("主线程开始");

        //线程休眠一秒，模拟处理业务逻辑的过程
        Thread.sleep(1000);
        logger.info("主线程返回");
        return "success";
    }

}
