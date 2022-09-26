package com.planet.kafkaproducer.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode
public class DomainList {

    List<Domain> domains;
}
