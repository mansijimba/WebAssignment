package org.example.webassignment.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ProductResponse {
    private int id;
    private Integer adminId;
    private String name;
    private String price;
    private String description;
    private int quantity;
    private String image;
    private Integer userId;

}
