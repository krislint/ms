package com.moelyon.ms.provider;

import io.lettuce.core.RedisURI;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

/**
 * application
 *
 * @author : wlt
 * @date : 2020-12-22 17:37
 **/
@EnableAutoConfiguration
public class ProviderApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class);
    }


    @Bean
    public RedisClusterClient getRedisCluster(){
        RedisURI redisUri = RedisURI.create("127.0.0.1",9001);
        return RedisClusterClient.create(redisUri);
    }

    @Autowired
    RedisClusterClient clusterClient;

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private static final String REDIS_KEY = "PROFILE:NOTE";
    @Override
    public void run(ApplicationArguments args) throws Exception {
        StatefulRedisClusterConnection<String, String> connection = clusterClient.connect();
        RedisAdvancedClusterCommands<String, String> syncCommands = connection.sync();
        if(syncCommands.hexists(REDIS_KEY,"666")){
            syncCommands.hset(REDIS_KEY,"666","QAQ");
        }
        String ans = syncCommands.hget(REDIS_KEY, "666");

        log.info(ans);
    }
}
