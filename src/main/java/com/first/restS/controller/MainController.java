package com.first.restS.controller;
import com.first.restS.dto.StudentDto;
import com.first.restS.repository.StudentRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("students")
@RestController
public class MainController {
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;
    public MainController(StudentRepo studentRepo, ModelMapper modelMapper) {
        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
    }
    //Fetching all students.
    @GetMapping
    public List<StudentDto> getStudent()
    {
        TypeToken<List<StudentDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(studentRepo.findAll(), typeToken.getType());
    }
}
