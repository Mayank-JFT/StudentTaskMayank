package com.first.restS.service.Impl;
import com.first.restS.dto.StudentDto;
import com.first.restS.entity.Student;
import com.first.restS.repository.StudentRepo;
import com.first.restS.service.StudentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<StudentDto> sortAccordingToRank() {
        return studentRepo.findAll().stream().
                sorted(Comparator.comparing(Student::getStudentRank)).
                map(student -> modelMapper.map(student,StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> sortAccordingTo(String sortField) {
        Comparator<Student> comparator = switch (sortField) {
            case "name" -> Comparator.comparing(Student::getName);
            case "marks" -> Comparator.comparing(Student::getMarks);
            case "rank" -> Comparator.comparing(Student::getStudentRank);
            case "id", default -> Comparator.comparing(Student::getId);
        };
        return studentRepo.findAll().stream()
                .sorted(comparator)
                .map(student -> modelMapper.map(student,StudentDto.class))
                .collect(Collectors.toList());
    }
}
