package com.alamin.testdemo.store;

import com.alamin.testdemo.dto.StudentDTO;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
@Getter
public class DataStore {
    @Getter
    private static List<StudentDTO> studentDTOList = new LinkedList<>();
    static {
        studentDTOList.addAll(List.of(
            new StudentDTO(1L,"Alamin", "Rony", "ab1@gmail.com", "CSE"),
            new StudentDTO(2L,"Java", "Rony", "ab2@gmail.com", "CSE"),
            new StudentDTO(3L,"JVM", "Rony", "ab3@gmail.com", "CSE"),
            new StudentDTO(4L,"Saiam", "Rony", "ab4@gmail.com", "CSE"),
            new StudentDTO(5L,"Jahangir", "Rony", "ab5@gmail.com", "CSE"),
            new StudentDTO(6L,"Alamin", "Rony", "ab6@gmail.com", "CSE"),
            new StudentDTO(7L,"Manik", "Rony", "ab7@gmail.com", "ENG"),
            new StudentDTO(8L,"Shabbir", "Rony", "ab8@gmail.com", "BBA"),
            new StudentDTO(9L,"Dart", "Rony", "ab9@gmail.com", "EEE"),
            new StudentDTO(10L,"JS", "Rony", "ab10@gmail.com", "EEE")
        ));
    }
    public static void setStudentDTOList(List<StudentDTO> studentDTOList) {
        DataStore.studentDTOList = studentDTOList;
    }
    public static void addStudentDTO(StudentDTO studentDTO) {
        System.out.println(studentDTO);
        if (studentDTO == null){
            return;
        }
        studentDTOList.add(studentDTO);
    }
}
