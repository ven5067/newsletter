//package com.newsletter.audit;
//
//import java.util.Optional;
//
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EmployeeAudtiting implements AuditorAware<String>{
//
//    @Override
//    public Optional<String> getCurrentAuditor() {
//
//        String uname = SecurityContextHolder.getContext().getAuthentication().getName();
//        return Optional.of(uname);
//    }
//
//}