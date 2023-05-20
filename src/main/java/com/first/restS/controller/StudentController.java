package com.first.restS.controller;
import com.first.restS.dto.StudentDto;
import com.first.restS.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("students")
@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    //Fetching all students.
    @GetMapping
    public List<StudentDto> getStudents() {
        return service.getStudents();
    }

    //Fetch all students sorted by rank.
    @GetMapping("/sorted-by-rank")
    public List<StudentDto> getStudentsSortedByRank() {
        return service.sortAccordingToRank();
    }

    //Fetch all students sorted by the given column name accepted.
    @GetMapping("/sort-by-{sortField}")
    public List<StudentDto> getStudentsSortedBy(@PathVariable String sortField) {
        return service.sortAccordingTo(sortField);
    }
}

