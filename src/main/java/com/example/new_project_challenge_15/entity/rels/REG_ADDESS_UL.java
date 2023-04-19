package com.example.new_project_challenge_15.entity.rels;

import com.example.new_project_challenge_15.entity.Address;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Node
public class REG_ADDESS_UL {
    @Id
    @GeneratedValue
    public Long id;
    @Property("Адрес")
    public String address_of_reg;
    @Property("Дата регистрационного действия")
    public String data_reg;
    @Property("РКА")
    public String rka;
    @TargetNode
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress_of_reg() {
        return address_of_reg;
    }

    public void setAddress_of_reg(String address_of_reg) {
        this.address_of_reg = address_of_reg;
    }

    public String getData_reg() {
        return data_reg;
    }

    public void setData_reg(String data_reg) {
        this.data_reg = data_reg;
    }

    public String getRka() {
        return rka;
    }

    public void setRka(String rka) {
        this.rka = rka;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
