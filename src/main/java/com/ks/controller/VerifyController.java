package com.ks.controller;

import com.ks.service.VerifyService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author xialinrui

 */

@RestController
@Slf4j

public class VerifyController {
    @Resource
    private  VerifyService verifyService;
    @GetMapping("/test/VerifyImage")
    public void getCode(HttpServletResponse response, HttpServletRequest request) throws IOException {

        verifyService.createCode(response, request);
    }

}

