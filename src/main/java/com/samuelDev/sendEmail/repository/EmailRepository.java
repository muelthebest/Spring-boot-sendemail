package com.samuelDev.sendEmail.repository;

import com.samuelDev.sendEmail.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
