package com.first.restS.service.Impl;

import com.first.restS.dto.StudentDto;
import com.first.restS.repository.StudentRepo;
import com.first.restS.service.StudentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;
    public StudentServiceImpl(StudentRepo studentRepo, ModelMapper modelMapper) {
        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<StudentDto> getStudents() {
        TypeToken<List<StudentDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(studentRepo.findAll(), typeToken.getType());
    }
}
