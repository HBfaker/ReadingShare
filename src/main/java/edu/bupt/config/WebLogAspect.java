package edu.bupt.config;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by 73681 on 2018/6/22.
 */
@Aspect
@Component
public class WebLogAspect {
    private Logger logger = Logger.getLogger(getClass());
}
