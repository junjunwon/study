package com.springPractice.webScope;

import com.springPractice.common.object.scope.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebScopeController {

    private final WebAppConfig webAppConfig;

    public WebScopeController(WebAppConfig webAppConfig) {
        this.webAppConfig = webAppConfig;
    }

    @GetMapping("/scopes/request")
    public String getRequestScopeMessage(final Model model) {

        City requestBean = webAppConfig.requestScopedBean();

        model.addAttribute("previousMessage", requestBean.getName());
        requestBean.setName("설마 지워지겠어?");
        model.addAttribute("currentMessage", requestBean.getName());

        return "returning getRequestScopeMessage";
    }

    @GetMapping("/scopes/session")
    public String getSessionScopeMessage(final Model model) {

        City requestBean = webAppConfig.sessionScopedBean();

        model.addAttribute("previousMessage", requestBean.getName());
        requestBean.setName("두번째 Insert");
        model.addAttribute("currentMessage", requestBean.getName());

        return "returning getSessionScopeMessage";
    }
}
