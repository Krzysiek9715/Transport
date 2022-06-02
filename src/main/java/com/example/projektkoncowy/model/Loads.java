package com.example.projektkoncowy.model;

import javax.persistence.*;

@Entity
@Table(name = "loads")
public class Loads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String loadCity;

    @Column
    private String unloadCity;

    @Column
    private Integer price;

    @Column
    private Integer kilometers;

    private LoadImport loadImport;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Drivers drivers;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoadCity() {
        return loadCity;
    }

    public void setLoadCity(String loadCity) {
        this.loadCity = loadCity;
    }

    public String getUnloadCity() {
        return unloadCity;
    }

    public void setUnloadCity(String unloadCity) {
        this.unloadCity = unloadCity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public LoadImport getLoadImport() {
        return loadImport;
    }

    public void setLoadImport(LoadImport loadImport) {
        this.loadImport = loadImport;
    }

    public Drivers getDrivers() {
        return drivers;
    }

    public void setDrivers(Drivers drivers) {
        this.drivers = drivers;
    }
}
