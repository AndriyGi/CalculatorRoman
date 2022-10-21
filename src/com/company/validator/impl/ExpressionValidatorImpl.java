package com.company.validator.impl;

import com.company.exception.IncorrectExpressionException;
import com.company.utils.StrUtil;
import com.company.validator.ExpressionValidator;

public class ExpressionValidatorImpl implements ExpressionValidator {

    @Override
    public void validate(String[] array) {

        if (array.length != 2) {
            throw new IncorrectExpressionException();
        }

        if(StrUtil.isEmpty(array[0]) || StrUtil.isEmpty(array[1])){
            throw new IncorrectExpressionException();
        }
    }
}
