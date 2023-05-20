package com.first.restS.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private Integer marks;
    private Integer studentRank;
}
