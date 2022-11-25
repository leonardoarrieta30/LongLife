package com.io.longlife.experience.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




@Configuration("experienceMappingConfiguration")
public class MappingConfiguration{

   @Bean
   public BigTreeMapper bigTreeMapper(){
       return new BigTreeMapper();
   }

}
