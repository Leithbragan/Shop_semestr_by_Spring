package ru.kpfu.itis.util.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.form.AddProductForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorAddProductForm implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        AddProductForm addProductForm = (AddProductForm) o;

        if (addProductForm.getName() == null || addProductForm.getName().isEmpty()) {
            errors.rejectValue("name", "", "Поле не может быть пустым");
        }
        if (addProductForm.getDescription() == null || addProductForm.getDescription().isEmpty()) {
            errors.rejectValue("description", "", "Поле не может быть пустым");
        }
    }
}
