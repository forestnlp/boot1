package com.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @NotNull(message = "id不能为空")
    private int id;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @Min(value = 1, message = "年龄要大于1岁")
    private int age;
    @Email(message = "email格式不准确")
    private String email;
    @Past(message = "生日要小于当日")
    LocalDate birthDay;
}
