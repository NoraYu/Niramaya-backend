package hackforfall.niramaya;

import hackforfall.niramaya.entity.Doctor;
import hackforfall.niramaya.entity.Patient;
import hackforfall.niramaya.repro.DoctorRepository;
import hackforfall.niramaya.repro.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NiramayaApplication implements CommandLineRunner {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository pRepo;
    public static void main(String[] args) {
        SpringApplication.run(NiramayaApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception{
        Doctor d1=new Doctor("John","Smith","john.smith@Niramaya.com","xxx");
        Doctor d2=new Doctor("Jessie","Dong","jessie.dong@Niramaya.com","xxx");
        Doctor d3=new Doctor("Nora","Yu","nora.yu@Niramaya.com","xxx");
        Patient d4=new Patient("Ben", "Roberts","ben.roberts@Niramaya.com","xxx");
        Patient d5=new Patient("Mark", "Smith","mark.smith@Niramaya.com","xxx");
        doctorRepository.save(d1);
        doctorRepository.save(d2);
        doctorRepository.save(d3);
        pRepo.save(d4);
        pRepo.save(d5);

    }
}
