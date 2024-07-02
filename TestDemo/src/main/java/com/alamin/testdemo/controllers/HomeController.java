package com.alamin.testdemo.controllers;

import com.alamin.testdemo.dto.StudentDTO;
import com.alamin.testdemo.store.DataStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor

public class HomeController {
    @GetMapping("/test")
    public ResponseEntity<?> test(){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
    @CrossOrigin("*")
    @GetMapping("/api/v1/student")
    public ResponseEntity<?> student(){
        return new ResponseEntity<>(DataStore.getStudentDTOList(), HttpStatus.OK);
    }
    @CrossOrigin("*")
    @GetMapping("/api/v1/student/{id}")
    public ResponseEntity<?> studentByID(@PathVariable Long id){
        Optional<StudentDTO> optionalStudentDTO = DataStore.getStudentDTOList().stream()
                .filter(p -> Objects.equals(p.id(), id))
                .findFirst();

        if (optionalStudentDTO.isPresent()) {
//            StudentDTO studentDTO = optionalStudentDTO.get();
            return new ResponseEntity<>(optionalStudentDTO.get(), HttpStatus.OK);
        } else {
//            System.out.println("Student with ID " + id + " not found.");
            return new ResponseEntity<>("Student with ID " + id + " not found.", HttpStatus.OK);
        }



    }

    @CrossOrigin(
            origins = {"http://localhost:3000", "http://localhost:4000"},
            methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE},
            exposedHeaders = {"custom-header"},
            allowCredentials = "true",
            maxAge = 10, //Second of time for preflight
            allowedHeaders = {HttpHeaders.CONTENT_TYPE, HttpHeaders.AUTHORIZATION}
    )
    @PostMapping("/api/v1/student")
    public ResponseEntity<?> studentByID(@RequestBody StudentDTO dto){
        DataStore.addStudentDTO(dto);
        System.out.println(DataStore.getStudentDTOList());
        return ResponseEntity.ok().header(
                "custom-header" ,"Simple custom header"
        ).body(dto);

    }
    @DeleteMapping
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        return new ResponseEntity<>("Student with ID " + id + " not found.", HttpStatus.OK);

    }

}
