import { Component, OnInit } from '@angular/core';
import { TaskService } from './services/task.service';
import { Task } from './Task';
import { FormControl, FormGroup, NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
 
  constructor(private taskService: TaskService) { }

  tasks: Task[];
  greetings = "Welcome to Tasks Management Page!!";
  task: Task;
  isAdded = false;
  taskForm: FormGroup;  
  title: "Tracker";
  editTask: Task;

  ngOnInit(): void {
        this.greetings;
        this.taskForm = new FormGroup({
          text: new FormControl(''),
          day: new FormControl(''),     
          reminder: new FormControl('')
         });
    }

  addTask(addForm: NgForm){
    this.taskService.addTask(addForm.value)
                    .subscribe(data=> {
                      console.log(data);
                      this.isAdded = true;
                      this.getTask();
                      this.resetUserForm();
                    }, error=>alert(error.message))
  }

  updateTask(editTask, id){
    this.taskService.updateTask(editTask, id)
                    .subscribe(data=> {
                      console.log(data);
                      this.isAdded = true;
                      this.getTask();
                    }, error=>alert(error.message))
  }

  resetUserForm(){
    this.isAdded = false;
    this.taskForm.reset();
  }

  getTask(){
      this.taskService.GetTasks().subscribe(data =>{  
        this.tasks = data;
       })
    }

    public searchEmployees(key: string): void {
      console.log(key);
      const results: Task[] = [];
      for (const task of this.tasks) {
        if (task.day.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || task.text.toLowerCase().indexOf(key.toLowerCase()) !== -1
        ) {
          results.push(task);
        }
      }
      this.tasks = results;
      if (results.length === 0 || !key) {
        this.getTask();
      }
    }
  
    public onOpenModal(task: Task, mode: string): void {
      const container = document.getElementById('main-container');
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-toggle', 'modal');
      if (mode === 'add') {
        button.setAttribute('data-target', '#addEmployeeModal');
      }
      if (mode === 'edit') {
        this.task = task;
        button.setAttribute('data-target', '#updateEmployeeModal');
      }
      if (mode === 'delete') {
        this.task = task;
        button.setAttribute('data-target', '#deleteEmployeeModal');
      }
      container.appendChild(button);
      button.click();
    }
  

}
