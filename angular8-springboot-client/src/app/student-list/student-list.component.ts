import { Component, OnInit } from '@angular/core';

import { Observable } from "rxjs";
import { StudentService } from "../student-service/student.service";
import { Student } from "../student-model/student";
import { Router } from '@angular/router';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  students: Observable<Student[]>;

  constructor(private studentService: StudentService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.students = this.studentService.getstudentsList();
    //console.log("fff"+this.students);
  }

  deleteStudent(id: number) {
    this.studentService.deletestudent(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  studentDetails(id: number){
    this.router.navigate(['details', id]);
  }

  studentUpdate(id: number){
    this.router.navigate(['update', id]);
  }
}