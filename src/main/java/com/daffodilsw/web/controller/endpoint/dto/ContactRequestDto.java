package com.daffodilsw.web.controller.endpoint.dto;

import java.util.List;

/**
 * Created by user on 23/4/15.
 */
public class ContactRequestDto {

    private List<ContactDto> contactDtos;

    private Long owenerId;

    public List<ContactDto> getContactDtos() {
        return contactDtos;
    }

    public void setContactDtos(List<ContactDto> contactDtos) {
        this.contactDtos = contactDtos;
    }

    public Long getOwenerId() {
        return owenerId;
    }

    public void setOwenerId(Long owenerId) {
        this.owenerId = owenerId;
    }
}
