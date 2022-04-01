package com.yuanstack.bp.spring.helloworld.aop;

import com.yuanstack.bp.spring.helloworld.spring01.Student;
import lombok.Data;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年04月01日 22:16
 */
@Data
public class Klass {

    List<Student> students;

    public void dong(){
        System.out.println(this.getStudents());
    }

}
