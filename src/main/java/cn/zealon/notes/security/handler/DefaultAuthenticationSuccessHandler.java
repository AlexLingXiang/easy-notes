package cn.zealon.notes.security.handler;

import cn.zealon.notes.common.result.ResultUtil;
import cn.zealon.notes.security.domain.LoginUserBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理
 * @author: zealon
 * @since: 2020/11/17
 */
@Slf4j
@Component
public class DefaultAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LoginUserBean loginUser = (LoginUserBean) authentication.getPrincipal();
        log.info("用户[{}]登录成功", loginUser.getUsername());
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(objectMapper.writeValueAsString(ResultUtil.success(loginUser.getUser())));
    }
}
