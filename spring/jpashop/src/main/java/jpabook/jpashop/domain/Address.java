package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable //어딘가에 내장이 될수있다
@Getter
public class Address {

    private String city ;
    private String street;
    private String zipcode;

    protected Address() {

    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
