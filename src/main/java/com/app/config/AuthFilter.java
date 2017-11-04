package com.app.config;

import com.app.repo.GeolocationRepo;
import com.app.security.Hashing;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created by wailm.yousif on 2/7/17.
 */
@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter
{
    private GeolocationRepo geolocationRepo;

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException
    {
        HttpServletRequest req = ((HttpServletRequest) request);
        HttpServletResponse resp = ((HttpServletResponse) response);

        boolean restAuthorized = false;
        String signature = req.getHeader("x-authorization-key");

        if (signature != null)
        {
            /*
            This is a Test code where signature validation always returns true.
            The original code shall check the signature which comes in the request header x-authorization-key
            The signature is a hash function of (API Username, API Password, HTTP Request Date)
            The API password is not sent on the request (i.e the password is used as a private key)
            */
            restAuthorized = (new Hashing()).validateSignature(signature);
        }
        
        if (restAuthorized)
        {
            chain.doFilter(req, resp);
        }
        else
        {
        	resp.addHeader("x-invalid-auth", "1");
            resp.getWriter().write("Invalid Authorization.");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}