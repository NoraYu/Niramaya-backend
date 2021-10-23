package hackforfall.niramaya.entity;

import javax.persistence.*;

@Entity
public class Doctor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String specificity;
    private String zoomURL;
    private String email;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    private Appointment appointment;
    public Doctor() {

    }

    public Doctor(String firstName, String lastName, String specificity, String zoomURL) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specificity = specificity;
        this.zoomURL = zoomURL;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getSpecificity() {
        return specificity;
    }

    public void setSpecificity(String specificity) {
        this.specificity = specificity;
    }

    public String getZoomURL() {
        return zoomURL;
    }

    public void setZoomURL(String zoomURL) {
        this.zoomURL = zoomURL;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}