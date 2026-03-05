package io.github.vrperdomo.arquiteturaspring.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    private TodoValidator todoValidator;

    private MailSender mailSender;

    public TodoService(TodoRepository todoRepository, TodoValidator todoValidator, MailSender mailSender){

        this.todoRepository = todoRepository;
        this.todoValidator = todoValidator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity novoTodo){
        todoValidator.validar(novoTodo);
        return todoRepository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todoEntity){
        todoRepository.save(todoEntity);
        String status = todoEntity.getConcluido() == Boolean.TRUE ? "Concluído" : "Não concluído";
        mailSender.enviar("Todo : " + todoEntity.getDescricao() + " foi atualizado para " + status );
    }

    public TodoEntity consultarTodoPorId(Integer id) {
        return todoRepository.findById(id).orElse(null);
    }

}
