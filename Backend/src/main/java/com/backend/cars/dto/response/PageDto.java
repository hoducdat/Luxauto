package com.backend.cars.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PageDto extends ResponseDto {

    @JsonProperty("total_page")
    private int totalPage;
    @JsonProperty("size")
    private int size;
    private Long total;
    @JsonProperty("page")
    private int page;

    public PageDto(Object data, int size, Long total, int page) {
        super(data);
        this.totalPage = (int) (total % (long) size > 0 ? total / (long) size + 1 : total / (long) size);
        this.size = size;
        this.total = total;
        this.page = page;
    }

    public PageDto(int size, Long total, int page) {
        this.totalPage = (int) (total % (long) size > 0 ? total / (long) size + 1 : total / (long) size);
        this.size = size;
        this.total = total;
        this.page = page;
    }

    public PageDto() {

    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
