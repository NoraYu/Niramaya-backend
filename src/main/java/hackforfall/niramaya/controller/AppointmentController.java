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
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AppointmentController {
    @Autowired
    AppointmentRepository aRepo;
    @Autowired
    PatientRepository pRepo;
    @Autowired
    DoctorRepository dRepo;

    @PostMapping(value = {"/make-appointment/{pid}/{did}"})
    public ResponseEntity<?> makeAppointment(@PathVariable Long pid, @PathVariable Long did, @RequestBody Appointment a){
            Appointment app = new Appointment();
            Patient p = pRepo.findById(pid).get();
            Doctor d = dRepo.findById(did).get();
            app.setPatient(p);
            app.setDoctor(d);
            app.setTime(a.getTime());
        System.out.println(app.getDoctor().getId());
            aRepo.save(app);
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
