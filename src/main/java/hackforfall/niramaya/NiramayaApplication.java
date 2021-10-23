package hackforfall.niramaya;

import hackforfall.niramaya.entity.Doctor;
import hackforfall.niramaya.repro.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NiramayaApplication implements CommandLineRunner {
    @Autowired
    DoctorRepository doctorRepository;
    public static void main(String[] args) {
        SpringApplication.run(NiramayaApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception{
        Doctor d1=new Doctor("John","Smith","N","xxx");
        Doctor d2=new Doctor("Jessie","Dong","N","xxx");
        Doctor d3=new Doctor("Nora","Yu","N","xxx");
        Doctor d4=new Doctor("Ben", "Roberts","Counselors","xxx");
        Doctor d5=new Doctor("Mark", "Smith","Clinicians","xxx");
        doctorRepository.save(d1);
        doctorRepository.save(d2);
        doctorRepository.save(d3);
        doctorRepository.save(d4);
        doctorRepository.save(d5);
    }
}
