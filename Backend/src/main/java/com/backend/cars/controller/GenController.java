package com.backend.cars.controller;

import com.backend.cars.util.ResponseUtil;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class GenController {
    protected static ResponseUtil responseUtil;
    static {
        responseUtil = new ResponseUtil();
    }
}
