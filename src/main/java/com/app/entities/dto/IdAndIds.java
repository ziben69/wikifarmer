package com.app.entities.dto;

import java.util.List;

public class IdAndIds {
    private Long id;
    private List<Long> ids;

    public IdAndIds() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
