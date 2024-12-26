package com.socialnetwork.social_networking_backend.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired
    private HttpSession session;

    protected boolean isAuthenticated() {
        String username = (String) session.getAttribute("username");
        return username != null;
    }
}
