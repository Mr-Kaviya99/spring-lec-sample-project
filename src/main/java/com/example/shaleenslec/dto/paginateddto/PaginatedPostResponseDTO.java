package com.example.shaleenslec.dto.paginateddto;

import com.example.shaleenslec.dto.responsedto.PostResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedPostResponseDTO {
    private List<PostResponseDTO> List;
    private long dataCount;
}
