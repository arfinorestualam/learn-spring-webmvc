package pzn.belajarspringwebmvc.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {

    //using @NotBlank as validation

    @NotBlank
    private String firstName;
    private String middleName;
    private String lastName;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String email;
    //add address request to become nested
    private CreateAddressRequest address;
    //add 2 other to became list
    //regular list
    private List<String> hobbies;
    //list with model
    private List<CreateSocialMediaRequest> socialMedias;
}
