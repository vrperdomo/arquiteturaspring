package io.github.vrperdomo.arquiteturaspring.montadora.configuration;

import io.github.vrperdomo.arquiteturaspring.montadora.Motor;
import io.github.vrperdomo.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MontadoraConfiguration {


    @Bean(name = "motorAspirado")
    public Motor motorAspirado(){
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("XPTO-0");
        motor.setLitragem(2.0);
        motor.setTipoMotor(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean(name = "motorEletrico")
    public Motor motorEletrico(){
        var motor = new Motor();
        motor.setCavalos(100);
        motor.setCilindros(4);
        motor.setModelo("TH10-0");
        motor.setLitragem(1.0);
        motor.setTipoMotor(TipoMotor.ELETRICO);
        return motor;
    }

    @Primary
    @Bean(name = "motorTurbo")
    public Motor motorTurbo(){
        var motor = new Motor();
        motor.setCavalos(180);
        motor.setCilindros(4);
        motor.setModelo("XXX-0");
        motor.setLitragem(2.0);
        motor.setTipoMotor(TipoMotor.TURBO);
        return motor;
    }
}
