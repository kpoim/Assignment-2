package com.kpoim.controller;

import com.kpoim.Utilities;
import com.kpoim.entity.EntitiesConfiguration;
import com.kpoim.entity.Entity;
import com.kpoim.service.Service;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("entity")
public class HomeController {

  @Autowired
  Service service;

  @ModelAttribute("entity")
  public Entity user() {
	return new Entity();
  }

  @GetMapping({"/", "/home"})
  public String goHome(Model m) {
	Set<String> entities = EntitiesConfiguration.getClassesMap().keySet();
	m.addAttribute("entities", entities);
	return "home";
  }

  @GetMapping("/{entity}/list")
  public String showEntities(@PathVariable(name = "entity") String entityName, Model m) {
	m.addAttribute("entityName", entityName);
	m.addAttribute("entities", service.findAll(entityName));
	m.addAttribute("properties", Utilities.getSortedPropertyDescriptors(EntitiesConfiguration.getClassesMap().get(entityName)));
	return "list";
  }

  @GetMapping("/{entity}/delete")
  public String deleteEntity(@PathVariable(name = "entity") String entityName, @RequestParam(name = "id") Integer id) {
	service.deleteById(id, entityName);
	return "redirect:/" + entityName + "/list";
  }

  @GetMapping("/{entity}/create")
  public String createForm(@PathVariable(name = "entity") String entityName, Model m) {
	try {
	  Entity entity = EntitiesConfiguration.getClassesMap().get(entityName).newInstance();
	  m.addAttribute("entity", entity);
	  m.addAttribute("properties", Utilities.getSortedPropertyDescriptors(EntitiesConfiguration.getClassesMap().get(entityName)));
	  m.addAttribute("entityName", entityName);
	} catch (InstantiationException | IllegalAccessException ex) {
	  Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
	}
	return "create";
  }

  @PostMapping("/{entity}/create")
  public String createOrUpdateEntity(@PathVariable(name = "entity") String entityName, Model m, @ModelAttribute(name = "entity") Entity e) {
	service.saveOrUpdate(e);
	return "redirect:/" + entityName + "/list";
  }

  @GetMapping("/{entity}/update")
  public String updateForm(@PathVariable(name = "entity") String entityName, @RequestParam("id") Integer id, Model m) {
	Entity entity = service.findById(id, entityName);
	System.out.println(entity);
	m.addAttribute("entity", entity);
	m.addAttribute("properties", Utilities.getSortedPropertyDescriptors(EntitiesConfiguration.getClassesMap().get(entityName)));
	m.addAttribute("entityName", entityName);
	return "create";
  }
}
