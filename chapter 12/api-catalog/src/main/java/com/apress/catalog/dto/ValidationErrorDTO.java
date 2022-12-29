package com.apress.catalog.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO {
    private List<ViolationDTO> violations;

    public ValidationErrorDTO() {
        violations = new ArrayList<>();
    }

    public List<ViolationDTO> getViolations() {
        return violations;
    }

    public void setViolations(List<ViolationDTO> violations) {
        this.violations = violations;
    }
}
