package com.adminappproject.trajan.controller.impl;

import com.adminappproject.trajan.controller.PublicApiServiceController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pickxilated on 23/04/2017.
 */
@RestController
@RequestMapping(value = "/publicApi")
public class PublicApiServiceControllerImpl implements PublicApiServiceController {

    @Override
    @RequestMapping(value = "/migrateDataAndEmail", method = RequestMethod.GET)
    public ResponseEntity<String> extractAllUsersAndSettings(@RequestParam("objectType") String extractType, @RequestParam("userName") String userName) {
        return new ResponseEntity<String>("Data Migration Started", HttpStatus.OK);
    }
}
