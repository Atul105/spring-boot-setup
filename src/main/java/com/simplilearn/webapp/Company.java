package com.simplilearn.webapp;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.simplilearn.bean.Employee;



public class Company {
	public static void main(String[] args) {
		
		//tightly coupled object
	    //create emplyee object
//		Employee employee = new Employee();
//		employee.setId(1001);
//		employee.setName("Jhon");
//		employee.setDept("Engineering");
//		employee.setSalary(4566.78);
//		
//		System.out.println(employee);
		
		//Application context container
		ApplicationContext context = new ClassPathXmlApplicationContext("employee-bean.xml");
		Employee emp1 = (Employee) context.getBean("emp1");
		System.out.println(emp1);
		Employee emp2 = context.getBean("emp2", Employee.class);
		System.out.println(emp2);
		System.out.println("---------------");
		
		//bean factory container
		DefaultListableBeanFactory beanfactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanfactory);
		reader.loadBeanDefinitions(new ClassPathResource("employee-bean.xml"));
		
		Employee employee1 = (Employee)beanfactory.getBean("emp1");
		Employee employee2 = (Employee)beanfactory.getBean("emp2");
		
		System.out.println(employee1);
		System.out.println(employee2);
		
	}

}
