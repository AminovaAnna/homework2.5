package pro.sky.skyprospringhomework25.exteptions;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeStorageIsFullException extends RuntimeException{
}
