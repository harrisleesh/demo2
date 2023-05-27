package com.example.demo.sample

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Sample(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    val name: String,
)
