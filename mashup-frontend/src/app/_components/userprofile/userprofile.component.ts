import { Component, OnInit, ViewChild, NgModule } from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { UserprofileServiceService } from '../../services/userprofile-service.service';
import { Token } from '@angular/compiler';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { ScorebadgeService } from 'src/app/services/scorebadge.service';
import { Profile } from 'selenium-webdriver/firefox';

export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}
export interface PeriodicElement {
  name: string;
  position: number;
}

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent implements OnInit {
  profileState: string;
  profile;
  public uname: string;

  // for getting data from scoreand badge service
  public userData = {};

  // tslint:disable-next-line:max-line-length
  constructor(private token: TokenStorageService, private userService: UserprofileServiceService, private scorebadgeservice: ScorebadgeService) { }
  tiles: Tile[] = [
    {text: 'One', cols: 1, rows: 5, color: 'white'},
    {text: 'Two', cols: 2, rows: 2.5, color: 'white'},
    {text: 'three', cols: 2, rows: 2.5, color: 'grey'},
  ];

  ngOnInit() {
    this.uname = this.token.getUsername();
    this.userService.getUserProfile(this.uname).subscribe(data => this.profile = data);
    this.profileState = 'currentProfile';

    // call score and badge service to get data(added by pratima on 27th feb2019)
    this.scorebadgeservice.getUserData(this.uname).subscribe(
      data => {
       this.userData = data;
    },
      error => {
        // alert(error);
      }
    );
  }

  updateProfile() {
    this.profileState = 'updatingProfile';
  }
  submitUpdatedProfile(age, gender, company, college, course, discipline) {
    this.profile.age = age;
    this.profile.gender = gender;
    this.profile.company = company;
    this.profile.college = college;
    this.profile.course = course;
    this.profile.disciple = discipline;
    this.userService.updateProfile(this.profile).subscribe();
    this.profileState = 'currentProfile';
  }

  deleteUserProfile() {
    this.userService.deleteUserProfile(this.profile.username).subscribe();
  }
}
