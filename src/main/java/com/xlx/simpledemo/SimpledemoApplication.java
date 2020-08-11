package com.xlx.simpledemo;

import com.pagoda.fastdfs.rpc.FileDomainRpcService;
import com.pagoda.platform.contract.EnableServiceContract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableServiceContract(clients = FileDomainRpcService.class)
public class SimpledemoApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(SimpledemoApplication.class, args);
    }

}
