package com.yuanstack.bp.core.design.behavior.template;

import com.yuanstack.bp.core.design.behavior.template.helloworld.AbstractTemplateExample;
import com.yuanstack.bp.core.design.behavior.template.helloworld.ConcreteTemplateExample;
import org.junit.jupiter.api.Test;

class AbstractTemplateExampleTest {

    @Test
    void templateMethod() {
        AbstractTemplateExample demo = new ConcreteTemplateExample();
        demo.templateMethod();
    }
}