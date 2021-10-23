package hackforfall.niramaya.controller;

import hackforfall.niramaya.entity.Appointment;
import hackforfall.niramaya.entity.Doctor;
import hackforfall.niramaya.entity.Patient;
import hackforfall.niramaya.repro.AppointmentRepository;
import hackforfall.niramaya.repro.DoctorRepository;
import hackforfall.niramaya.repro.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
    @Autowired
    AppointmentRepository aRepo;
    @Autowired
    PatientRepository pRepo;
    @Autowired
    DoctorRepository dRepo;

    @PostMapping(value = {"{pid}/{did}/make-appointment/"})
    public ResponseEntity<?> makeAppointment(@PathVariable Long pid, @PathVariable Long did, @RequestBody Appointment a){
            Patient p = pRepo.findById(pid).get();
            Doctor d = dRepo.findById(did).get();
            a.setPatient(p);
            a.setDoctorId(d);
            aRepo.save(a);
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
