package com.g2.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.g2.model.Person;
import com.g2.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImp implements ExampleService {
    

    private static final Log LOGGER = LogFactory.getLog(ExampleServiceImp.class);

    @Override
    public List<Person> getListPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Hector", 36));
        people.add(new Person("Eduardo", 26));
        people.add(new Person("Garcia", 16));
        people.add(new Person("Picon", 46));
        
        LOGGER.info("Hello from Service !!");

        return people;
    }

}
