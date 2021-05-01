package com.delight.demo.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.delight.demo.entity.Student;

@Repository
public class StudentRepository {

    @Autowired
    private DynamoDBMapper mapper;


    public Student addStudent(Student student) {
        mapper.save(student);
        return student;
    }

    public Student findStudentByStudentId(String studentId) {
        return mapper.load(Student.class, studentId);
    }

    public String deletePerson(Student student) {
        mapper.delete(student);
        return "student records removed";
    }

    public String editStudentDetails(Student student) {
        mapper.save(student, buildExpression(student));
        return "Student records Updated.";
    }

    private DynamoDBSaveExpression buildExpression(Student student) {
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
        expectedMap.put("studentId", new ExpectedAttributeValue(new AttributeValue().withS(student.getStudentId())));
        dynamoDBSaveExpression.setExpected(expectedMap);
        return dynamoDBSaveExpression;
    }


}
