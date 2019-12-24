package com.imooc.validator;

import com.imooc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 何国锋
 * @date 2019-12-21 18:06
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    //允许使用Spring的自动织入一些必要的组件来帮助完成你的校验逻辑~
    @Autowired
    HelloService helloService;


    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println(" MyConstraint 初始化工作");
    }


    /**
     *
     * @param o 校验值
     * @param constraintValidatorContext 上下文环境
     * @return
     */
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        helloService.greeting("tom");

        return true;
    }
}
