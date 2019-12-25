package com.kpoim;

import com.kpoim.entity.Entity;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanUtils;

public class Utilities {

  public static PropertyDescriptor[] getSortedPropertyDescriptors(Class<? extends Entity> aClass) {
	List<String> fields = new ArrayList();
//	Arrays.asList(aClass.getSuperclass().getDeclaredFields()).forEach(f -> fields.add(f.getName()));
	Arrays.asList(aClass.getDeclaredFields()).forEach(f -> fields.add(f.getName()));
	PropertyDescriptor[] props = new PropertyDescriptor[fields.size()];
	PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(aClass);
	for (PropertyDescriptor p : pds) {
	  int index = fields.indexOf(p.getDisplayName());
	  if (index != -1) {
		props[index] = p;
	  }
	}
	return props;
  }
  
//  
//  public static Map<String, Object> convertAttributeTypes(String entityName, Map<String, Object> input){
//	Map<String, Object> map = new HashMap();
//	
//  }

}
