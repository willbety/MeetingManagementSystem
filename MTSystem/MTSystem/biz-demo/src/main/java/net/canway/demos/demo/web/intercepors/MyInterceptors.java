package net.canway.demos.demo.web.intercepors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptors implements HandlerInterceptor {

    /**
     * preHandle 在执行目标方法之前执行，即controller接口之前
     * @param request 用户请求对象
     * @param response 资源响应对象
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        System.out.println("当前访问URL:" + requestURI);
        System.out.println("1 、 preHandle 在执行目标方法之前执行 ..........");
        return true;
    }

    // postHandle 渲染视图之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("2、 postHandle 渲染视图之前执行 ..........");
    }

    // afterCompletion 渲染视图之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("3、 afterCompletion 渲染视图之后执行 ..........");
    }


}