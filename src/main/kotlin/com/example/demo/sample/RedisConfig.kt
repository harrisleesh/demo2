package com.example.demo.sample

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
@EnableRedisRepositories
class RedisConfig {
    @Value("\${spring.cache.redis.host}")
    private val host: String? = null

    @Value("\${spring.cache.redis.port}")
    private val port = 0

    /**
     * 내장 혹은 외부의 Redis를 연결
     */
    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory {
        return LettuceConnectionFactory(host!!, port)
    }

    /**
     * RedisConnection에서 넘겨준 byte 값 객체 직렬화
     */
    @Bean
    fun redisTemplate(): RedisTemplate<*, *> {
        val redisTemplate = RedisTemplate<ByteArray, ByteArray>()
        redisTemplate.setConnectionFactory(redisConnectionFactory())
        redisTemplate.keySerializer = StringRedisSerializer()
        return redisTemplate
    }
}