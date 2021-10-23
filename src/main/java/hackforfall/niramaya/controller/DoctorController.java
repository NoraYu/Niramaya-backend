package hackforfall.niramaya.controller;

import hackforfall.niramaya.entity.Doctor;
import hackforfall.niramaya.repro.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    DoctorRepository docrepo;
    @GetMapping(value = {"/alldocs"},produces = "application/json")
    public ResponseEntity<List<Doctor>> getAllDocs(){
        return new ResponseEntity<>(docrepo.findAll(), HttpStatus.OK);
    }
}
