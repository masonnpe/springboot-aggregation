package com.masonnpe.springboot.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class RegisterVO {
    @Length(min = 6)
    private String name;

    @Length(min = 8,message = "密码不少于8位")
    private String password;
}
