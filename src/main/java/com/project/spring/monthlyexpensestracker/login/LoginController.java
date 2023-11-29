package com.project.spring.monthlyexpensestracker.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"budget","name"})
public class LoginController {

  //  private AuthenticationService service;

//    public LoginController(AuthenticationService service){
//        this.service=service;
//    }
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String goToLoginPage(ModelMap model){
        model.put("name",getLoggedInUsername());
        return "welcome";


    }
//    @RequestMapping(value="/login",method = RequestMethod.POST)
//    public String goToWelcomePage(@RequestParam String name,@RequestParam String password, ModelMap model){
//        boolean isValid=service.isValid(name,password);
//        if(isValid){
//            model.put("name",name);
//            return "welcome";
//        }
//        model.put("errorMessage","Invalid Credentials!");
//        return "login";
//
//    }

    private String getLoggedInUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
     return    authentication.getName();
    }



    @RequestMapping(value="/goto-budget",method = RequestMethod.GET)
    public String goToBudgetPage(){
        return "budget";
    }

    @RequestMapping(value="/goto-budget",method = RequestMethod.POST)
    public String setBudgetPage(@RequestParam double budget, ModelMap model){
        if((budget<=0)){
            model.put("errormessage","Please Enter postive number");
            return "budget";
        }else{
            model.put("budget",budget);
            return "redirect:/goto-expense";
        }

    }

    @RequestMapping(value="/expense",method = RequestMethod.GET)
    public String goToExpensePage(){
        return "expense";
    }
}
