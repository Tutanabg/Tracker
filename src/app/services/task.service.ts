import { Injectable } from '@angular/core';
import { Task } from '../Task'
import { Observable, throwError } from 'rxjs'
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, retry } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class TaskService {

  baseUrl = 'http://localhost:8081/tracker/';

  constructor(private http: HttpClient) { }
     // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  // GET
  GetTasks() {
    return this.http.get<Task[]>(this.baseUrl + "all")
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  addTask(data): Observable<Task>{
    return this.http.post<Task>(this.baseUrl + "add", JSON.stringify(data), this.httpOptions);
  }

  updateTask(data, id): Observable<Task>{
    return this.http.put<Task>(this.baseUrl + "update/" + `${id}`, JSON.stringify(data), this.httpOptions);
  }
  
  // Error handling
  errorHandl(error) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }

}
