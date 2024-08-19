package org.example.webassignment.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalApiResponse <T>{
    private String message;
    private String status;
    private T data;
}
