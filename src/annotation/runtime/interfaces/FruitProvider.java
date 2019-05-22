package annotation.runtime.interfaces;

import java.lang.annotation.*;

/**
 * 水果供应者注解
 *
 * @autor rj-liang
 * @date 2017/5/14 上午10:28
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /**
     * 供应商编号
     *
     * @return
     */
    public int id() default -1;

    /**
     * 供应商名称
     *
     * @return
     */
    public String name() default "";

    /**
     * 供应商地址
     *
     * @return
     */
    public String address() default "";
}
