package com.mysql.model;

import java.sql.Date;

public record UsersDataDTO(
    int id,
    String name,
    Integer age, // intではなくIntegerを使用してnullを許容
    String birthPlace,
    Date birthDay,
    Boolean isAdmin // tinyint(1)はJavaのBooleanとして扱う
) {

}
