package com.skt.poc.common.api.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class LoginController {

//    @Autowired
//    private UserService userService;

    @GetMapping(value = {"/", "login"})
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login/login");
        return modelAndView;
    }
    
    @GetMapping("home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        UserDetails userPrincipal = (UserDetails) auth.getPrincipal();

        modelAndView.addObject("userName", "Welcome User [" + userPrincipal.getUsername() + "]  * Roles => " + userPrincipal.getAuthorities());
//        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("home");
        return modelAndView;
    }

    /**
    @GetMapping("registration")
    public ModelAndView getRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user/registration");

        return modelAndView;
    }

    @PostMapping("registration")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        User userExists = userService.findUserByLoginId(user.getLoginId());
        if (userExists != null) {
            bindingResult
                .rejectValue("loginId", "error.loginId",
                    "There is already a user registered with the loginId provided");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("user/registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("user/registration");
        }

        return modelAndView;
    }

    @GetMapping("exception")
    public ModelAndView getUserPermissionExceptionPage() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("user/access-denied");

        return mv;
    }
    **/

}