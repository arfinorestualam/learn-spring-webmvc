package pzn.belajarspringwebmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {

    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String email;
    //add address request to become nested
    private CreateAddressRequest address;
}
