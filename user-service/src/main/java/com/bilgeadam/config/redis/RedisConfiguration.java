package com.bilgeadam.config.redis;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableCaching
@EnableRedisRepositories // reddis configuration icin ozel anatasyonlar
public class RedisConfiguration {
    // redis onbelleklemeye yarar database'e gonderdigin bir istegi tekrarlarsan bosu bosuna databasede yeni bir search
    // yapmaz onbellekten sana verir

    @Bean
    public LettuceConnectionFactory redisConnectionFactory(){
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost",6379));
    }


}
