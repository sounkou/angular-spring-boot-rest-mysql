import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private baseUrl : string = environment.ApiUrl;

  constructor(private http: HttpClient) { }

  getstudent(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}`+ `/student/${id}`);
  }

  createstudent(student: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/student`, student);
  }

  updatestudent(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}`+ `/student/${id}`, value);
  }

  deletestudent(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}`+ `/student/${id}`, { responseType: 'text' });
  }

  getstudentsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}` + `/students`);
  }
}