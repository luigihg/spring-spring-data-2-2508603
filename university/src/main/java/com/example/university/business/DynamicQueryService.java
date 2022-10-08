package com.example.university.business;

import com.example.university.domain.Course;
import com.example.university.repo.CourseQueryDslRepo;
import com.example.university.repo.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DynamicQueryService {

    private CourseRepo courseRepo;

    private CourseQueryDslRepo queryDslRepo;

    public DynamicQueryService(CourseRepo courseRepo, CourseQueryDslRepo queryDslRepo) {
        this.courseRepo = courseRepo;
        this.queryDslRepo = queryDslRepo;
    }

    public List<Course> filterBySpecification(CourseFilter filter) {
        return courseRepo.findAll(filter.getSpecification());
    }

    public List<Course> findByQueryDsl(CourseFilter filter){
        List<Course> courses = new ArrayList<>();
        queryDslRepo
                .findAll(filter.getQueryDslPredicate())
                .iterator()
                .forEachRemaining(courses::add);
        return courses;
    }

    public List<Course> findByExample(CourseFilter filter){
        return courseRepo.findAll(filter.getExampleProbe());
    }
}
