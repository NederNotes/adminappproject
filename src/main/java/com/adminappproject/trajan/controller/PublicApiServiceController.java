package com.adminappproject.trajan.controller;

import org.springframework.http.ResponseEntity;

/**
 * Created by pickxilated on 22/04/2017.
 * Everything about Url that is available to PAP
 */

public interface PublicApiServiceController {
    public ResponseEntity<String> extractAllUsersAndSettings(String extractType, String userName);
}
