package com.library.library.Classes.DTO;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Value;

@Value
public class PageResponse<T> {
    List<T> context;
    Metadata metadata;

    public static <T> PageResponse<T> of(Page<T> page) {
        var medata = new Metadata(page.getNumber(), page.getSize(), page.getTotalElements());
        return new PageResponse<>(page.getContent(), medata);
        
    }
    @Value
    public static class Metadata {
        int page;
        int size;
        long totalElements;
    }
}
