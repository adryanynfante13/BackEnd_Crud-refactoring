package co.com.sofka.crud.Controllers;

import co.com.sofka.crud.Entidades.Todo;
import co.com.sofka.crud.DAO.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/*
 * @version 2.0
 * @autor Adryan Ynfante <adryanynfante@gmail.com>
 * Controller de tareas endpoint api/grouplists, declaramos origen para admitir la conexion del front,
 * metodos guardar, editar , eliminar y  actualizar tareas
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<Todo> list(){
        return service.list();
    }

    @GetMapping(value = "api/{idGroup}/todos")
    public Iterable<Todo> listByGroup(@PathVariable("idGroup") Long idGroup) {
       return  service.listTodoByGroup(idGroup);
    }

    @PostMapping(value = "api/todo")
    public Todo save(@RequestBody Todo todo){
        return service.save(todo);
    }

    @PutMapping(value = "api/todo")
    public Todo update(@RequestBody Todo todo){
        if(todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public Todo get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
