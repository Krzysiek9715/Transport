package com.example.projektkoncowy.model;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "cars")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String plates;

    @Column
    private String brand;

    @Column
    private Integer yearOfProduction;

    @OneToOne
    private Drivers driver;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Drivers getDriver() {
        return driver;
    }

    public void setDriver(Drivers driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", plates='" + plates + '\'' +
                ", brand='" + brand + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", kierowca= "+ driver.getFirstName()+" "+driver.getLastName()+
                '}';
    }
}
