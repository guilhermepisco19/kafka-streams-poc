package com.planet.kafkaprocessor.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
public class Domain implements Serializable {

    String domain;
    String create_date;
    String update_date;
    String country;
    boolean isDead;
    String A;
    String NS;
    String CNAME;
    String MX;
    String TXT;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domain domain1 = (Domain) o;
        return isDead == domain1.isDead && Objects.equals(domain, domain1.domain) && Objects.equals(create_date, domain1.create_date) && Objects.equals(update_date, domain1.update_date) && Objects.equals(country, domain1.country) && Objects.equals(A, domain1.A) && Objects.equals(NS, domain1.NS) && Objects.equals(CNAME, domain1.CNAME) && Objects.equals(MX, domain1.MX) && Objects.equals(TXT, domain1.TXT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domain, create_date, update_date, country, isDead, A, NS, CNAME, MX, TXT);
    }
}
