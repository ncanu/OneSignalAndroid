package global.inin.mytestingos.login;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class LoginResponse {

    @JsonProperty
    private String token;

    @JsonProperty
    private long id;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private String email;

    @JsonProperty
    private long countryId;

    @JsonProperty
    private String alphanumericId;

    @JsonProperty
    private String image;

    @JsonProperty
    private boolean canAdminUsers;

    @JsonProperty
    private boolean canAdminCompanies;

    @JsonProperty
    private boolean seller;

    @JsonProperty
    private boolean adviser;

    @JsonProperty
    private boolean associate;

    @JsonProperty
    private boolean miContaGT;

    @JsonProperty
    private boolean contadorGT;

    @JsonProperty
    private boolean credit;

    @JsonProperty
    private boolean directAdviser;

    @JsonProperty
    private boolean validated;

    @JsonProperty
    private BigDecimal balance;

    @JsonProperty
    private Integer currency;

    @JsonProperty
    private BigDecimal companiesReservedBalance;

//    @JsonProperty
//    private List<Role> services;
//
//    @JsonProperty
//    private List<CompanyRolesResponse> companyRoles;

    @JsonProperty
    private boolean passOk;

}
