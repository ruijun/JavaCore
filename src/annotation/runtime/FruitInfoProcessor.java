package annotation.runtime;

import annotation.runtime.interfaces.FruitColor;
import annotation.runtime.interfaces.FruitName;
import annotation.runtime.interfaces.FruitProvider;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 水果信息注解处理器
 *
 * @autor rj-liang
 * @date 2017/5/14 上午10:32
 */
public class FruitInfoProcessor {

    public static void getFruitInfo(Class<?> clazz) {

        String strFruitName = " 水果名称：";
        String strFruitColor = " 水果颜色：";
        String strFruitProvider = "供应商信息：";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName += fruitName.value();
                System.out.println(strFruitName);

            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor += fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);

            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider += " 供应商编号：" + fruitProvider.id() + " 供应商名称：" + fruitProvider.name() + " 供应商地址：" + fruitProvider.address();
                System.out.println(strFruitProvider);

            }
        }

        System.out.println("======================");

        String strFruitName1 = " 水果名称：";
        String strFruitColor1 = " 水果颜色：";
        String strFruitProvider1 = "供应商信息：";
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method: methods) {
            if (method.getAnnotation(FruitName.class) != null) {
                FruitName fruitName = method.getAnnotation(FruitName.class);
                strFruitName1 += fruitName.value();
                System.out.println(strFruitName1);

            } else if (method.getAnnotation(FruitColor.class) != null) {
                FruitColor fruitColor = method.getAnnotation(FruitColor.class);
                strFruitColor1 += fruitColor.fruitColor().toString();
                System.out.println(strFruitColor1);

            } else if (method.getAnnotation(FruitProvider.class) != null) {
                FruitProvider fruitProvider = method.getAnnotation(FruitProvider.class);
                strFruitProvider1 += " 供应商编号：" + fruitProvider.id() + " 供应商名称：" + fruitProvider.name() + " 供应商地址：" + fruitProvider.address();
                System.out.println(strFruitProvider1);

            }
        }
    }
}
