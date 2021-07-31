package com.company.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode(of = "uuid")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String uuid;

    @Column(name = "name")
    @Basic(optional = false)
    private String name;

    @Column(name = "surname")
    @Basic(optional = false)
    private String surname;

    @Column(name = "username", nullable = false,unique = true)
    private String username;

    @Min(6)
    private String password;

    @PrePersist
    public void prePersist(){
        setUuid(UUID.randomUUID().toString());
    }

}
