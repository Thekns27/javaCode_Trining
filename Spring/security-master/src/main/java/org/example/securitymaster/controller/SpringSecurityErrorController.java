package org.example.securitymaster.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringSecurityErrorController implements ErrorController {
    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String errorMessage = "Unknown error";

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            switch (statusCode) {
                case 404:
                    errorMessage = "Page not found";
                    break;
                case 500:
                    errorMessage = "Internal server error";
                    break;
                // Add more cases as needed
                case 403:
                    errorMessage = "Forbidden!";
                    break;
                default:
                    errorMessage = "Error occurred";
                    break;
            }

            model.addAttribute("statusCode", statusCode);
            model.addAttribute("errorMessage", errorMessage);
        }

        return "errorPage";
    }

}
