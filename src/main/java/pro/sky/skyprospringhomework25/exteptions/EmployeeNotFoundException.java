package pro.sky.skyprospringhomework25.exteptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeNotFoundException extends RuntimeException {
}
