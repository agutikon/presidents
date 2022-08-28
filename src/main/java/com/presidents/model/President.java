package com.presidents.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "PRESIDENT")
public class President {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private Timestamp termFrom;
    private Timestamp termTo;
    private String party;
}
