package com.g2.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.g2.entity.Course;
import com.g2.entity.QCourse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * En el archivo pom se configura dslquery y se le dice en cual ruta va a dejar las clases generadas.  EJ: target/generated-sources/java
 * desde una consola no dirigimos a la ruta de nuestro proyecto y ejecutamos mvn clean install.   esto genera las clases que usaremos con dslquery
 * en la ruta configurada ya aparece las clases,  pero el proyecto aun no las renoce,  entonces toca hacer el paso que aparece en el comentario de abajo
 * @author hector.garcia
 *
 */
@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
    
    /**
     * Si esta clase no es reconocida destro del proyecto entonces tenemos que hacer dos pasos:
     * 1: desde una terminal no dirigimos a nuestro proyecto y ejecutamos:  mvn eclipse:eclipse   
     * 2: click derecho al proyecto->maven->update project
     * Me funcionó :)
     */
    private QCourse qCourse = QCourse.course;
    
    //em  es un objeto que se encarga de gestionar las entidades de la persistencia de la aplicacion
    @PersistenceContext
    private EntityManager em;
    
    public void find() {
        JPAQuery<Course> query = new JPAQuery<>(em);
        
        Course course1 = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
        Course course2 = (Course) query.select(qCourse.name, qCourse.description).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
        
        List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
    }
    
    public Course find(boolean exist) {
        
        JPAQuery<Course> query = new JPAQuery<>(em);
        
        Predicate predicate1 = qCourse.description.endsWith("OP");
        BooleanBuilder predicateBuilder = new BooleanBuilder(predicate1);


        if (exist) {
            Predicate predicate2 = qCourse.id.eq(23);
            predicateBuilder.and(predicate2);
        } else {
            Predicate predicate3 = qCourse.name.endsWith("OP");
            predicateBuilder.or(predicate3);
        }

        Course course = query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();

        return course;
    }
    

}
