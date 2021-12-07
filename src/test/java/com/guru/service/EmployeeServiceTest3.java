/*
 * package com.guru.service;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.mockito.ArgumentMatchers.anyLong; import static org.mockito.Mockito.when;
 * 
 * import java.util.ArrayList; import java.util.Date; import java.util.List;
 * import java.util.Optional;
 * 
 * import org.junit.jupiter.api.Assertions; import org.junit.jupiter.api.Test;
 * import org.junit.jupiter.api.extension.ExtendWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.mockito.junit.jupiter.MockitoExtension;
 * 
 * import com.guru.Employee; import com.guru.repo.EmpRepo;
 * 
 * @ExtendWith(MockitoExtension.class) class EmployeeServiceTest3 {
 * 
 * Employee emp = new Employee(1, "GURU", new Date(), new Date(),
 * "JAVA PRACTICE");;
 * 
 * @Mock private EmpRepo repo;
 * 
 * @InjectMocks private EmployeeService reqService;
 * 
 * private List<Employee> list = new ArrayList<>();
 * 
 * @Test void testSave() throws Exception {
 * System.out.println("testSave emp    " + emp);
 * when(repo.save(emp)).thenReturn(emp); System.out.println("testSave emp    " +
 * reqService.save(emp, Type.SAVE));
 * 
 * Assertions.assertEquals(reqService.save(emp, Type.SAVE), emp); }
 * 
 * @Test void testDeleteWithNull() throws Exception {
 * Assertions.assertThrows(Exception.class, () -> { reqService.delete(null); });
 * }
 * 
 * @Test void testDeletePostive() throws Exception {
 * System.out.println("testDeletePostive   ----->  " + emp);
 * when(repo.findById(anyLong())).thenReturn(Optional.of(emp));
 * assertEquals(reqService.delete(1L), "Sucess"); }
 * 
 * @Test void testAll() { when(repo.findAll()).thenReturn(list);
 * System.out.println("testAll --> " + emp); list.add(emp);
 * System.out.println(list.size()); System.out.println("list ------>  " + list);
 * assertEquals(reqService.all(), list); }
 * 
 * }
 */