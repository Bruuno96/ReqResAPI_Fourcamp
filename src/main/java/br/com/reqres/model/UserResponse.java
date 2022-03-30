package br.com.reqres.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserResponse {

    private String id;
    private String name;
    private String job;
    private String createdAt;

    public UserResponse() {
    }

    public UserResponse(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
