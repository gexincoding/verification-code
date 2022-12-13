package com.ks.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author xialinrui
 */
public interface VerifyService {

    /**
     * 创建图片验证码
     * @param response
     * @param request
     * @throws IOException
     */
    void createCode(HttpServletResponse response, HttpServletRequest request) throws IOException;

}
