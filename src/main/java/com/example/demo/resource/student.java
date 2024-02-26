package com.example.demo.resource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class student {
    ArrayList<studentclass> list = new ArrayList<>();

    @PostMapping("/addStudent")
    public String add_student(String name, String age, String adhar, String university) {
        String id = Integer.toString(list.size());
        studentclass student = new studentclass(id, name, age, adhar, university);
        list.add(student);
        return id;
    }

    @GetMapping("/getStudentsByUniversity")
    public ArrayList<studentclass> getStudentsByUniversity(String university) {
        ArrayList<studentclass> res = new ArrayList<>();
        for(studentclass st : list) {
            if(st.university.equals(university)) {
                res.add(st);
            }
        }

        return res;
    }

    @GetMapping("/getStudentById")
    public studentclass getStudentsById(String id) {
        return list.get(Integer.parseInt(id));
    }
}
