package pl.edu.pjwstk.datastore.util;

import org.apache.commons.beanutils.BeanMap;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 06.10.13
 * Time: 00:41
 * To change this template use File | Settings | File Templates.
 */
public class BeanToMap {
    public static Map<String,Object> toMap(Object bean){
        Map<String,Object> map = new BeanMap(bean);
        return map;
    }
}
