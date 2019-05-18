package vn.edu.vnua.dse.calendar.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vn.edu.vnua.dse.calendar.common.AppConstant;
import vn.edu.vnua.dse.calendar.model.User;
import vn.edu.vnua.dse.calendar.service.UserService;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
//        if (user.getEmail().length() < 6 || user.getEmail().length() > 32) {
//            errors.rejectValue("email", "Size.userForm.email");
//        }
        if(!user.getEmail().matches(AppConstant.GMAIL_REGEX)) {
        	errors.rejectValue("email", "NotValidGmail");
        }
        
        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.user.email");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmptyFirstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmptyLastName");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmptyPass");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.user.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.user.passwordConfirm");
        }
    }
}
