package com.sm.dto;

import com.sm.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookDto {

    private Long id;
    private String title;
    private List<AuthorDto> authors = new ArrayList<>();
}
