package com.metallic.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "system_metrics")
public class SystemMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String componentName;
    private String status;

    public SystemMetric() {}

    public SystemMetric(String componentName, String status) {
        this.componentName = componentName;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getComponentName() { return componentName; }
    public String getStatus() { return status; }
}
