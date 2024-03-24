package ng.com.nokt.bakery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
}
