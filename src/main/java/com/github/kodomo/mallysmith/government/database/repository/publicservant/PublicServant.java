package com.github.kodomo.mallysmith.government.database.repository.publicservant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicServant {
    private int id;
    private String userId;
    private String job;
    private Integer salary;
}
