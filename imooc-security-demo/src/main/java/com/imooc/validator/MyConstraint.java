package com.imooc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 何国锋
 * @date 2019-12-21 18:03
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
//标志这是一个用于校验的注解，且校验工作由指定的类完成
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {


    //还需要声明如下三个抽象方法，其他的校验注解如@NotBlank也声明了这些方法
    String message() default "{默认消息}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
