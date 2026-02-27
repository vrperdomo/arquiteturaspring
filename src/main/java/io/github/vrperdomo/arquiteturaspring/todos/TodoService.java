package io.github.vrperdomo.arquiteturaspring.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public TodoEntity salvar(TodoEntity novoTodo){
        return todoRepository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todoEntity){
        todoRepository.save(todoEntity);
    }

    public TodoEntity consultarTodoPorId(Integer id) {
        return todoRepository.findById(id).orElse(null);
    }

}
