package mx.com.xisco.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.com.xisco.dto.UserDto;

@Controller
public class SignUpController {
    private static final Logger LOG = LoggerFactory.getLogger(SignUpController.class);

    @Autowired
    private MessageSource messages;

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String showForm(final UserDto userDto) {
        return "signUp";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(final Locale locale, final Model model, @Valid final UserDto userDto, final BindingResult bindingResult) {
        FieldError error;

        try {
            if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
                error = new FieldError("userDto", "confirmPassword", messages.getMessage("message.password.notMatch", null, locale));
                bindingResult.addError(error);
                error = new FieldError("userDto", "password", messages.getMessage("message.password.notMatch", null, locale));
                bindingResult.addError(error);
            } else {

            }
        } catch (Exception e) {
            error = new FieldError("userDto", "username", bindingResult.getFieldValue("username"), false, null, null, messages.getMessage("message.username.exist", null, locale));
            bindingResult.addError(error);
            SignUpController.LOG.error(e.getMessage());
        }

        if (bindingResult.hasErrors()) {
            return "signUp";
        }

        model.addAttribute("message", messages.getMessage("message.success.signUp", null, locale));
        return "redirect:/login";
    }

}
