package com.theironyard.services;

import com.theironyard.entities.Assignment;
import com.theironyard.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by PiratePowWow on 3/10/16.
 */
public interface AssignmentRepository extends PagingAndSortingRepository<Assignment, UUID> {
    Page<Assignment> findAllByOrderByNumAsc(Pageable pageable);
    List<Assignment> findAllByOrderByNumAsc();
}
