package com.example.demo.sample

import org.springframework.data.jpa.repository.JpaRepository

interface SampleRepository : JpaRepository<Sample, Long>
