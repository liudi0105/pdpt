package com.pd.server.messages.complains;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "complains")
public class ComplainsPO {
    @Id
    private Long id;
    private Character uuid;
    private String email;
    private String body;
    private LocalDateTime added;
    private Short answered;
    private String ip;
}
