package annotation.runtime.interfaces;

import java.lang.annotation.*;

/**
 * 水果名称注解
 *
 * @autor rj-liang
 * @date 2017/5/14 上午10:24
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
