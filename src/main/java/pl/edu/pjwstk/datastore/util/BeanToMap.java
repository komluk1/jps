package pl.edu.pjwstk.datastore.util;

import org.apache.commons.beanutils.BeanMap;

import java.util.Map;

public class BeanToMap {
    public static Map<String, Object> toMap(Object bean) {
        Map<String, Object> map = new BeanMap(bean);
        return map;
    }
}
