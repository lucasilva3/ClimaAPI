package com.servidor.clima.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servidor.clima.model.Clima;

public interface ClimaRepository extends JpaRepository<Clima, Long> {
}
