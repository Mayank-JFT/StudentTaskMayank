package com.first.restS.service;
import com.first.restS.dto.StudentDto;

import java.util.List;

public interface StudentService {
     List<StudentDto> getStudents();
     List<StudentDto> sortAccordingToRank();
     List<StudentDto> sortAccordingTo(String sortField);
}
