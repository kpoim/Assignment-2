package com.kpoim.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.reflections.Reflections;

public class EntitiesConfiguration {

  private static Map<String, Class<? extends Entity>> classesMap;

  public static Map<String, Class<? extends Entity>> getClassesMap() {
	if (classesMap == null) {
	  classesMap = new HashMap<>();
	  Reflections reflections = new Reflections("com.kpoim.entity");
	  Set<Class<? extends Entity>> subTypes = reflections.getSubTypesOf(Entity.class);
	  subTypes.forEach(item -> {
		classesMap.put(item.getSimpleName().toLowerCase(), item);
	  });
	}
//	classesMap.forEach((i, t) -> {
//	  System.out.println(i + " ---> " + t);
//	});
	return classesMap;
  }
}
