package ra.btss17.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name ="employee")
public class Employee {
    @Id
    @Column(name = "empId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    @Column(name = "empName")
    @NotEmpty(message = "Employee name is empty!")
    private String empName;
    @Column(name = "address")
    @NotEmpty(message = "Adress Employee is empty!")
    private String address;
    @Column(name = "dob")
    @NotNull(message = "Birthday is empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Date is not valid")
    private Date dob;
    @Column(name = "phone")
    @NotEmpty(message = "Phone is empty!")
    private String phone;
}
