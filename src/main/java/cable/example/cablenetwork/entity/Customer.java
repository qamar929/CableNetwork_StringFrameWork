package cable.example.cablenetwork.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@NotBlank(message = "Bill code can't be empty")
@Size(min=2 ,max=10)
private String billCode;

    @NotBlank(message = "Name can't be empty")
    @Size(min=2 ,max=30)
private String name;

private Long phoneNumber;

private String Address;

private int bill;
private String Date;
}
