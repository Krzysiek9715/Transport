package com.example.projektkoncowy.model;

import javax.persistence.*;
import java.util.Objects;

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


    @Column(columnDefinition = "ENUM('WITH_IMPORT','WITHOUT_IMPORT','IMPORT')")
    @Enumerated(EnumType.STRING)
    private LoadImport loadImport;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Drivers drivers;

    @OneToOne
    @JoinColumn(name = "import_id")
    private Loads importLoads;

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

    public Loads getImportLoads() {
        return importLoads;
    }

    public void setImportLoads(Loads importLoads) {
        this.importLoads = importLoads;
    }

    @Override
    public String toString() {
        return "Loads{" +
                "id=" + id +
                ", loadCity='" + loadCity + '\'' +
                ", unloadCity='" + unloadCity + '\'' +
                ", price=" + price +
                ", kilometers=" + kilometers +
                ", loadImport=" + loadImport +
                ", drivers=" + drivers +
                ", importLoads=" + importLoads +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loads loads = (Loads) o;
        return id.equals(loads.id) && Objects.equals(loadCity, loads.loadCity) && Objects.equals(unloadCity, loads.unloadCity) && Objects.equals(price, loads.price) && Objects.equals(kilometers, loads.kilometers) && loadImport == loads.loadImport && Objects.equals(drivers, loads.drivers) && Objects.equals(importLoads, loads.importLoads);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loadCity, unloadCity, price, kilometers, loadImport, drivers, importLoads);
    }
}
