package org.sample.spring.model;

import javax.persistence.*;

@Entity(name = "ddd")
@Table(name = "ddd")
public interface IEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);
}
