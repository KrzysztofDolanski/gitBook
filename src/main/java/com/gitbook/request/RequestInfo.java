package com.gitbook.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "request_info")
public class RequestInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "LOGIN")
    private String login;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "REQUEST_COUNT")
    private Long requestCount;

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public Long getRequestCount() {
        return requestCount;
    }
}
