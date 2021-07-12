package annotation.runtime.interfaces;

import java.lang.annotation.*;

/**
 * 水果名称注解
 *
 * 指定了被修饰的注解的生命周期
 * RetentionPolicy.SOURCE：当前注解编译期可见，不会写入 class 文件
 * RetentionPolicy.CLASS：类加载阶段丢弃，会写入 class 文件
 * RetentionPolicy.RUNTIME：永久保存，可以反射获取
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
