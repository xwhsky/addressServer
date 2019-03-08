package hkc.address.dto;

import java.lang.reflect.Field;

/**
 * @author xwh19
 */
public class Utils {
    //判断是否为空
    public static boolean CheckNull(Object o) throws IllegalAccessException {
        for (Field f : o.getClass().getDeclaredFields())
            if (f.get(o) != null)
                return false;
        return true;
    }



}
