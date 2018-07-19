package springboot_validating_form.springboot_validating_form.controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springboot_validating_form.springboot_validating_form.entity.PersonForm;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/person")
public class PersonController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/result").setViewName("result");
    }

    //@GetMapping(value = "/")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showForm(PersonForm personForm) {
        return "form";
    }

    //@PostMapping(value = "/")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }

        return "redirect:/result";
    }
}
