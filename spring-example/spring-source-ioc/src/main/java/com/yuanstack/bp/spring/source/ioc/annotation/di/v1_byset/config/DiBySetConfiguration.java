package com.yuanstack.bp.spring.source.ioc.annotation.di.v1_byset.config;

import com.yuanstack.bp.spring.source.ioc.annotation.di.common.DiCat;
import com.yuanstack.bp.spring.source.ioc.annotation.di.common.DiPerson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hansiyuan
 * @date 2022年03月30日 22:19
 */
@Configuration
public class DiBySetConfiguration {
    @Bean
    public DiPerson diPerson() {
        DiPerson person = new DiPerson();
        person.setName("test-person-anno-byset");
        person.setAge(18);
        return person;
    }

    @Bean
    public DiCat diCat() {
        DiCat cat = new DiCat();
        cat.setName("test-cat-anno");
        cat.setMaster(diPerson());
        return cat;
    }
}
