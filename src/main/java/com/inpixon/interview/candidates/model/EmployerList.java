package com.inpixon.interview.candidates.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployerList {
    List<Employer> employers;

    public List<Employer> getEmployers() {
        return Optional.ofNullable(employers).orElse(new ArrayList<>());
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }
}
