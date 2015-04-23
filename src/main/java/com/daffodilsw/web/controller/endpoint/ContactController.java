package com.daffodilsw.web.controller.endpoint;

import com.daffodilsw.web.controller.endpoint.dto.ContactDto;
import com.daffodilsw.web.controller.endpoint.dto.ContactRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 23/4/15.
 */
@RestController
@RequestMapping("/feeds")
public class ContactController {

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ResponseEntity listContact() {
        ContactRequestDto contactRequestDto = new ContactRequestDto();
        ContactDto contactDto = new ContactDto();
        contactDto.setFirstName("deepak");
        contactDto.setLastName("rai");
        contactDto.setEmail("deepak.rai@daffodilsw.com");
        contactDto.setPhoneNumber("11111111111");
        contactDto.setUserName("deepak.rai");
        List<ContactDto> contactDtos = new ArrayList<>();
        contactDtos.add(contactDto);

        contactDto = new ContactDto();
        contactDto.setFirstName("deepak1");
        contactDto.setLastName("rai1");
        contactDto.setEmail("deepak.rai@daffodilsw.com1");
        contactDto.setPhoneNumber("111111111112");
        contactDto.setUserName("deepak.rai1");
        contactDtos.add(contactDto);

        contactRequestDto.setContactDtos(contactDtos);
        contactRequestDto.setOwenerId((long) 2);

        return new ResponseEntity<ContactRequestDto>(contactRequestDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/contact", method = RequestMethod.PUT)
    public ResponseEntity<ContactRequestDto> createContactList(@RequestBody ContactRequestDto contactRequestDto) {

        return new ResponseEntity<ContactRequestDto>(contactRequestDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public ResponseEntity<ContactRequestDto> updateContactList(@RequestBody ContactRequestDto contactRequestDto) {

        return new ResponseEntity<ContactRequestDto>(contactRequestDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/contact", method = RequestMethod.DELETE)
    private ResponseEntity listContactDelete(@RequestBody ContactRequestDto contactRequestDto) {
        return new ResponseEntity<ContactRequestDto>(contactRequestDto, HttpStatus.OK);
    }
}
