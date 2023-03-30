package com.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(indexes = {@Index(name="uk_email",columnList = "email",unique = true)})
public class User {
    @NotNull(message = "id不能为空")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "姓名不能为空")
    @Column(nullable = false,columnDefinition = "varchar(20) comment '姓名' ")
    private String name;

    @Min(value = 1, message = "年龄要大于1岁")
    @Transient
    private int age;

    @Email(message = "email格式不准确")
    @Column(nullable = false,columnDefinition = "varchar(50) comment '邮箱' ")
    private String email;

    @Past(message = "生日要小于当日")
    LocalDate birthDay;
}
