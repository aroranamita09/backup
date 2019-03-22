import { Component, OnInit } from '@angular/core';
import { ScorebadgeService } from '../../services/scorebadge.service';

@Component({
  selector: 'app-scoreandbadge',
  templateUrl: './scoreandbadge.component.html',
  styleUrls: ['./scoreandbadge.component.css']
})
export class ScoreandbadgeComponent implements OnInit {

  constructor(public scorebadgeservice: ScorebadgeService ) { }

  ngOnInit() {
  }

}
