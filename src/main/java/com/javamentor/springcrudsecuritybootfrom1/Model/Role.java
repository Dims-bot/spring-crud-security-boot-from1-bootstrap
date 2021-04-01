package com.javamentor.springcrudsecuritybootfrom1.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    @Column(name = "id")
    private Long id;


    @Column(name = "name_role")
    @Enumerated(EnumType.STRING)
    private ERole role;

//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users;

    public Role(ERole role) {
        this.role = role;
    }
}
