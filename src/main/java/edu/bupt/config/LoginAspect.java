//package edu.bupt.config;
//
//import edu.bupt.util.TokenUtil;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
///*
// * 判断用户登录状态，用切面来做
// */
//@Aspect
//@Component
//public class LoginAspect {
//    //    @Pointcut("execution(public * edu.bupt.controller..*.*(..))")
////    "within(com.cn.winter.controller..*) && !within(com.cn.winter.controller.login.LoginController)"
////    @Pointcut("execution(public * edu.bupt.controller..*) && !within(edu.bupt.controller.UserController)")
////    @Pointcut("execution(public * edu.bupt.controller..*.*(..))) " +
////            "&& !execution(* login*(..))")
//    //除了登录和注册方法，其他的都要走这个登录验证
//    @Pointcut("execution(public * edu.bupt.controller..*.*(..)) " +
//            "&& !execution(public * edu.bupt.controller.UserController.login*(..)) " +
//            "&& !execution(public * edu.bupt.controller.UserController.register*(..))")
//    public void judgeLogin() {
//    }
//
//    @Before("judgeLogin()")
//    public void before() throws RuntimeException {//这次加了参数可能会报错
//        System.out.println("调用了用户登录的切面");
//        // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        //根据传过来的token计算出一个userId，如果这个userId和前端传过来的userId不对的话，那么需要重新登录
//        String userId = request.getParameter("userId");
//        String token = request.getParameter("token");
////        System.out.println("userId:" + userId);
////        System.out.println("token:" + token);
//        Long idFromToken = null;
//        try {
//            idFromToken = TokenUtil.getAppUID(token);
//        } catch (Exception e) {//token不对，需要重新登录
//            throw new RuntimeException("tokenError");
//        }
//
//        if (idFromToken != null) {
////            System.out.println("idFormToken:" + idFromToken);
//            if (!idFromToken.toString().equals(userId)) {//如果token不对，需要重新登录
//                throw new RuntimeException("tokenError");
//            }
//        }
//    }
//}
