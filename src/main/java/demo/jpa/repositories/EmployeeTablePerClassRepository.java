package demo.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import demo.jpa.EmployeeDTO;
import demo.jpa.entities.EmployeeTablePerClass;

public interface EmployeeTablePerClassRepository extends CrudRepository<EmployeeTablePerClass, Long>
{
    List<EmployeeTablePerClass> findByLastName(@Param("lastName") String lastName);
    @Query("select new demo.jpa.EmployeeDTO(firstName, lastName) from EmployeeTablePerClass where lastName=:lastName")
    List<EmployeeDTO> findMinimalEmployeeByLastName(@Param("lastName") String lastName);
}
