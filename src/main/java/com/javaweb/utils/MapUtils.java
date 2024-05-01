package com.javaweb.utils;

import java.util.Map;

public class MapUtils {
	public static <T> T getObject(Map<String,Object> maps, String key, Class<T> tClass) {
		Object obj = maps.getOrDefault(key, null);
		if(obj != null) {
			if(tClass.getTypeName().equals("java.lang.Long")) {
				obj = obj != "" ? Long.valueOf(obj.toString()) : null;
			}
			else if(tClass.getTypeName().equals("java.lang.Integer")) {
				obj = obj != "" ? Integer.valueOf(obj.toString()) : null;
			}
			else if(tClass.getTypeName().equals("java.lang.String")) {
				obj = obj.toString();
			}
			return tClass.cast(obj);
		}
		return null;
	}

//	public static <T> T getObject(Object item, Class<T> tClass) {
//		if(item != null) {
//			if(tClass.getTypeName().equals("java.lang.Long")) {
//				item = item != "" ? Long.valueOf(item.toString()) : null;
//			}
//			else if(tClass.getTypeName().equals("java.lang.Integer")) {
//				item = item != "" ? Integer.valueOf(item.toString()) : null;
//			}
//			else if(tClass.getTypeName().equals("java.lang.String")) {
//				item = item.toString();
//			}
//			return tClass.cast(item);
//		}
//		return null;
//	}
}
