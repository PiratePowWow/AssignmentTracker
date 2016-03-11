package com.theironyard.services;

import com.theironyard.entities.Assignment;
import com.theironyard.entities.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by PiratePowWow on 3/10/16.
 */
public interface AssignmentRepository extends CrudRepository<Assignment, UUID> {
}
