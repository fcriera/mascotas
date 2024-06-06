package com.frc.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api", produces="application/json")
@CrossOrigin(origins="*")
public class MascotaControllerApi {

}
