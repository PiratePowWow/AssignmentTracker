package com.theironyard.services;

import com.theironyard.entities.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by PiratePowWow on 3/10/16.
 */
public interface StudentRepository extends CrudRepository<Student, UUID> {
}
