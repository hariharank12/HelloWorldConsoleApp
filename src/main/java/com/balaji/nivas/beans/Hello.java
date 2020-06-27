package com.balaji.nivas.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by hariharank12 on 27/06/20.
 */
@Data
@Component(value="helloBean")
@AllArgsConstructor
@NoArgsConstructor
public class Hello {
    @Value(value = "${name}")
    private String name;

    @PostConstruct
    private void postConstruct() {
        System.out.println("Hello Bean post construct name:" + name);
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("Hello Bean pre destroy name:" + name);
    }


}
