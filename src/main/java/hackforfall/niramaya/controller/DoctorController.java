package hackforfall.niramaya.controller;

import hackforfall.niramaya.entity.Doctor;
import hackforfall.niramaya.entity.Patient;
import hackforfall.niramaya.repro.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {
    @Autowired
    DoctorRepository docrepo;
    @GetMapping(value = {"/alldocs"},produces = "application/json")
    public ResponseEntity<List<Doctor>> getAllDocs(){
        return new ResponseEntity<>(docrepo.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = {"/login-doctor"})
    public ResponseEntity<?> patientLogin(@RequestBody Doctor p){
        Optional<Doctor> p1 = docrepo.findByEmail(p.getEmail());
        if(p1.isPresent()) {
            if(p1.get().getPassword().equals(p.getPassword())){
                return new ResponseEntity(p1.get(), HttpStatus.OK);
            }
            else return new ResponseEntity("Incorrect password", HttpStatus.FORBIDDEN);
        }
        else
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = {"signup-doctor"})
    public ResponseEntity<?> patientSignup(@RequestBody Doctor p){
        if(docrepo.findByEmail(p.getEmail()).isPresent()){
            return new ResponseEntity<>("User exists", HttpStatus.BAD_REQUEST);
        }
        else {
            docrepo.save(p);
            return new ResponseEntity<>("Successful sign up", HttpStatus.OK);
        }
    }
}
