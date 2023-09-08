package ra.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name",length=45)
    @Size(min=5,max=45)
    private String firstName;
    @Column(name="last_name",length=45)
    @Size(min=5,max=45)
    private String lastName;
    @Column(name = "phone_number",length = 11)
    @Pattern(regexp = "^0\\d{9,10}$",message = "Phone Number is not valid")
    private String phoneNumber;
    @Column(name = "age")
    @Min(value=18)
    private int age;
    @Pattern(regexp = "^(.+)@(\\S+)$",message = "Email is not valid")
    @Email
    private String email;
}
