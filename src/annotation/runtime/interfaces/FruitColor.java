package annotation.runtime.interfaces;

import java.lang.annotation.*;

/**
 * 水果颜色注解
 *
 * @autor rj-liang
 * @date 2017/5/14 上午10:26
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    /**
     * 颜色枚举
     */
    public enum Color {
        BULE, RED, GREEN
    }

    ;

    /**
     * 颜色属性
     */
    Color fruitColor() default Color.GREEN;

}
