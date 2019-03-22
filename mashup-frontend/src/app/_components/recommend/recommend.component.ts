import { QuestionserviceService } from './../../services/questionservice.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-recommend',
  templateUrl: './recommend.component.html',
  styleUrls: ['./recommend.component.css']
})
export class RecommendComponent implements OnInit {

  constructor(public _route: ActivatedRoute, private router: Router, public fetchservice: QuestionserviceService) { }
  public fetch: any;
  ngOnInit(): any {
    this.fetchservice.getallquestioninfo().subscribe(
      data => {
        this.fetch = data;
      },
      error => {
        console.log(error.errorMessage);
      }
    );
  }
  openEditor(questionId) {
    this.router.navigate(['/execution', questionId]);
  }

}
