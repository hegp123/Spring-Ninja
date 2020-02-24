package com.g2.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g2.entity.Course;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable> {

    /**
     * este metodo busca automaticament por el campo price, sin necesidad de
     * implementarlo :) excelente esta funcionalidad
     * 
     * @param price
     * @return
     */
    public abstract Course findByPrice(int price);

    /**
     * este metodo busca automaticament por el campo price y name, sin necesidad de
     * implementarlo :) excelente esta funcionalidad
     * 
     * @param price
     * @return
     */
    public abstract Course findByPriceAndName(int price, String name);

    /**
     * este metodo busca automaticament por el campo name y ordena por hours, sin
     * necesidad de implementarlo :) excelente esta funcionalidad
     * 
     * @param price
     * @return
     */
    public abstract List<Course> findByNameOrderByHours(String name);

    /**
     * este metodo busca automaticament por el campo name o price, sin necesidad de
     * implementarlo :) excelente esta funcionalidad
     * 
     * @param price
     * @return
     */
    public abstract Course findByNameOrPrice(String name, int price);
}
