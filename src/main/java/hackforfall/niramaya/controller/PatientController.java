package hackforfall.niramaya.controller;

import hackforfall.niramaya.entity.Doctor;
import hackforfall.niramaya.entity.Patient;
import hackforfall.niramaya.repro.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class PatientController {
    @Autowired
    private PatientRepository pRepo;

    @PostMapping(value = {"/login-patient"})
    public ResponseEntity<?> patientLogin(@RequestBody Patient p){
        Optional<Patient> p1 = pRepo.findByEmail(p.getEmail());
        if(p1.isPresent()) {
            if(p1.get().getPassword().equals(p.getPassword())){
                return new ResponseEntity(p1.get(), HttpStatus.OK);
            }
            else return new ResponseEntity("Incorrect password", HttpStatus.FORBIDDEN);
        }
        else
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = {"/signup-patient"})
    public ResponseEntity<?> patientSignup(@RequestBody Patient p){
        if(pRepo.findByEmail(p.getEmail()).isPresent()){
            return new ResponseEntity<>("User exists", HttpStatus.BAD_REQUEST);
        }
        else {
            pRepo.save(p);
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
    }

    @GetMapping(value = {"/patient/{id}"})
    public ResponseEntity<Patient> findDoctorById(@PathVariable Long id){
        Optional<Patient> d = pRepo.findById(id);
        if(d.isPresent())
            return new ResponseEntity<>(d.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
