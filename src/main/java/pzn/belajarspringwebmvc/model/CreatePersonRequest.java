package pzn.belajarspringwebmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    //add 2 other to became list
    //regular list
    private List<String> hobbies;
    //list with model
    private List<CreateSocialMediaRequest> socialMedias;
}
