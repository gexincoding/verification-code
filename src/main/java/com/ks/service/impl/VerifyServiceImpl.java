package com.ks.service.impl;

import com.ks.service.VerifyService;
import com.ks.util.VerifyUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;

/**
 * @author xialinrui
 */
@Service
public class VerifyServiceImpl implements VerifyService {
    @Override
    public void createCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        //获取session
        HttpSession session = request.getSession();
        //获得sessionId
        String id = session.getId();
        System.out.println();
        ResponseCookie cookie = ResponseCookie.from("JSESSIONID",id)
                .secure(true)
                .domain("")
                .path("/")
                .maxAge(Duration.ofHours(1))
                .sameSite("None")
                .build();

        //清除之前缓存的图片验证码
//        if (!String.valueOf(request.getSession().getAttribute("SESSION_VERIFY_CODE_"+id)).isEmpty()){
//            String getVerify = String.valueOf(request.getSession().getAttribute("SESSION_VERIFY_CODE_"+id));
//            redisUtil.del(getVerify);
//            System.out.println("清除成功");
//        }

        //生成图片验证码,用的默认参数
        Object[] verify = VerifyUtil.newBuilder().build().createImage();

        //将验证码存入session
        session.setAttribute("SESSION_VERIFY_CODE_" + id, verify[0]);
        //打印验证码
        System.out.println(verify[0]);

        //将验证码存入redis
       // redisUtil.set((String) verify[0],id,5*60);

        //将图片传给浏览器
        BufferedImage image = (BufferedImage) verify[1];
        response.setContentType("image/png");
        response.setHeader(HttpHeaders.SET_COOKIE,cookie.toString());
        OutputStream ops = response.getOutputStream();
        ImageIO.write(image,"png",ops);
    }
}
