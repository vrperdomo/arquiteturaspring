package io.github.vrperdomo.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository todoRepository;

    public TodoValidator(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void validar(TodoEntity todoEntity) {
        if (existeTodoComDescricao(todoEntity.getDescricao())){
            throw new IllegalArgumentException("Já existe um TODO com está descrição!");
        }
    }

    private boolean existeTodoComDescricao(String descricao) {
        return todoRepository.existsByDescricao(descricao);
    }

}
