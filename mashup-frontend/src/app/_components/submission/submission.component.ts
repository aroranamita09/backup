import { Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { SubmissionService } from '../../services/submission.service';

@Component({
  selector: 'app-submission',
  templateUrl: './submission.component.html',
  styleUrls: ['./submission.component.css']
})
export class SubmissionComponent implements OnInit {
  // displayedColumns: string[] = ['title', 'difficulty', 'tag', 'testpassed', 'totaltest', 'solution'];
  questionId;
  username;
  submissionData;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private submission: SubmissionService,private _route: ActivatedRoute, private token: TokenStorageService) {}

  ngOnInit() {
    this.questionId = this._route.snapshot.paramMap.get('qid');
    this.username = this.token.getUsername();
    this.submission.getSubmission(this.username,this.questionId).subscribe(
      data => {
       this.submissionData = data;
    },
      error => {
        // alert(error);
      }
    );
  }
}