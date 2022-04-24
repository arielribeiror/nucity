package br.com.fiap.nucity.model;

import javax.persistence.*;

@Entity
@Table(name = "types")
@SequenceGenerator(name = "type", sequenceName = "type_sq", allocationSize = 1)
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "income")
    private Integer id;

    private String name;
    private String key;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
