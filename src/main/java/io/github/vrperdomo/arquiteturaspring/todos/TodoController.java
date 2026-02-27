package io.github.vrperdomo.arquiteturaspring.todos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todoEntity){
        return this.todoService.salvar(todoEntity);
    }

    @PutMapping("{id}")
    public void atualizarStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todoEntity) {
        todoEntity.setId(id);
        todoService.atualizarStatus(todoEntity);
    }

    @GetMapping("{id}")
    public TodoEntity buscarTodoPorId(@PathVariable("id") Integer id){
        return todoService.consultarTodoPorId(id); 

    }
}
