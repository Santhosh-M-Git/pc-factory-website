package com.pcstore.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pc_orders")
public class PCOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pc_orders_seq")
	@SequenceGenerator(name = "pc_orders_seq", sequenceName = "pc_orders_seq", allocationSize = 1)
	private Long id;
	
    private String cpu;
    private String gpu;
    private String ram;
    private String ssd;
    private String psu;
    private String cabinet;

    private Double totalPrice;

    private String customerName;
    private String email;
    private String phone;

    // Getters and Setters
    public Long getId() { return id; }

    public String getCpu() { return cpu; }
    public void setCpu(String cpu) { this.cpu = cpu; }

    public String getGpu() { return gpu; }
    public void setGpu(String gpu) { this.gpu = gpu; }

    public String getRam() { return ram; }
    public void setRam(String ram) { this.ram = ram; }

    public String getSsd() { return ssd; }
    public void setSsd(String ssd) { this.ssd = ssd; }

    public String getPsu() { return psu; }
    public void setPsu(String psu) { this.psu = psu; }

    public String getCabinet() { return cabinet; }
    public void setCabinet(String cabinet) { this.cabinet = cabinet; }

    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}