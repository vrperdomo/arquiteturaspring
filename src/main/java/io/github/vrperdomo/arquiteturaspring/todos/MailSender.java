package io.github.vrperdomo.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

import java.time.Clock;

@Component
public class MailSender {

    public void enviar(String mensagem) {
        System.out.println("Enviado email: " + mensagem);
    }

}
