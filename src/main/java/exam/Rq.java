package exam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public Rq(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;

        try {
            request.setCharacterEncoding("UTF-8");

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
    }

    public int getIntParam(String paramName, int defaultValue) {
        String parameter = request.getParameter(paramName);

        if (parameter == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(parameter);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public void appendBody(String str) {
        try {
            response.getWriter().append(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setAttr(String name, Object value) {
        request.setAttribute(name, value);
    }

    public void view(String path) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/" + path + ".jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }

    public String getParam(String paramName, String defaultName) {
        String parameter = request.getParameter(paramName);

        if (parameter == null || parameter.trim().length() == 0) {
            return defaultName;
        }
        return parameter;
    }

    public String getPath() {
        return request.getRequestURI();
    }

    public String getMethod() {
        return request.getMethod();
    }

    public String getFirstPathVariable() {
        String[] bits = request.getRequestURI().split("/");
        return bits[4];
    }

    public String getActionPath() {
        String[] bits = request.getRequestURI().split("/");

        return "/%s/%s/%s".formatted(bits[1], bits[2], bits[3]);
    }
}
