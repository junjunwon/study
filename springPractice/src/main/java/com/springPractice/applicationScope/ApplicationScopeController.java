package com.springPractice.applicationScope;


import com.springPractice.common.object.scope.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationScopeController {

    private final ApplicationScopeAppConfig config;

    public ApplicationScopeController(ApplicationScopeAppConfig config) {
        this.config = config;
    }

    @GetMapping("/scope/application")
    public String getApplicationScope(final Model model) {

        City city = config.applicationScopedBean();
        model.addAttribute("previous", city.getName());
        city.setName("new name!!!!");
        model.addAttribute("current", city.getName());

        return "getApplicationScope";
    }

}
