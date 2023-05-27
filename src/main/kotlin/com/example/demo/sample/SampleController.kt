package com.example.demo.sample

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(
    private val sampleRepository: SampleRepository,
    private val redisTemplate: RedisTemplate<String, String>,
) {
    @GetMapping("/sample")
    fun sample(): String {
        return "Hello, world! , " + sampleRepository.findAll().joinToString { it.name }
    }

    @GetMapping("/setRedis")
    fun redisSet(): String {
        redisTemplate.opsForValue().set("test", "redis test set")
        redisTemplate.opsForValue().set("test2", "redis test set 2")
        return "setRedis"
    }

    @GetMapping("/getRedis")
    fun redisGet(): String {
        return redisTemplate.opsForValue().get("test") ?: "null"
    }
}