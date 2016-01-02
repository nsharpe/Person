package org.neil.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * Created by neilsharpe on 1/1/16.
 */
@SpringBootApplication
public class PersonApplication {
  public static void main(String args[]){
    ApplicationContext ctx = SpringApplication.run(PersonApplication.class, args);

    String[] beanNames = ctx.getBeanDefinitionNames();
    Arrays.sort(beanNames);
    for (String beanName : beanNames) {
      System.out.println(beanName);
    }
  }
}
