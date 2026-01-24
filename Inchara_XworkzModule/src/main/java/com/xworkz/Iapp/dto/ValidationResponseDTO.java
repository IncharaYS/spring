package com.xworkz.Iapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationResponseDTO {
    private boolean exists;
    private int attempts;
}
